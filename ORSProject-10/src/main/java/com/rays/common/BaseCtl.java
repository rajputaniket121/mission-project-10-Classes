package com.rays.common;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.rays.dto.UserDTO;

/**
 * Base controller class for common REST operations like search, save, get,
 * delete. Provides reusable CRUD operations for all entity controllers.
 * 
 * @author Aniket Rajput
 * @param <T> DTO type extending BaseDTO
 * @param <F> Form type extending BaseForm
 * @param <S> Service type extending BaseServiceInt
 */
public abstract class BaseCtl<T extends BaseDTO, F extends BaseForm<T>, S extends BaseServiceInt<T>> {

	@Autowired
	protected S service;

	@Value("${page.size}")
	protected int pageSize = 0;

	protected UserContext userContext = null;

	/**
	 * Sets user context from session or fallback. This method is invoked before
	 * each request to populate the user context.
	 * 
	 * @param session the HTTP session containing user information
	 */
	@ModelAttribute
	public void setUserContext(HttpSession session) {
		userContext = UserContextHolder.getContext();
		if (userContext == null) {
			UserDTO dto = new UserDTO();
			dto.setLoginId("rajput@gmail.com"); // fallback
			userContext = new UserContext(dto);
		}
	}

	/**
	 * Validates binding result and returns errors if any.
	 * 
	 * @param bindingResult the validation binding result containing field errors
	 * @return ORSResponse with success status and input errors map if validation
	 *         fails, or success true if no validation errors
	 */
	protected ORSResponse validate(BindingResult bindingResult) {
		ORSResponse response = new ORSResponse(true);
		if (bindingResult.hasErrors()) {
			response.setSuccess(false);
			Map<String, String> errorsMap = new HashMap<String, String>();
			List<FieldError> fieldErrors = bindingResult.getFieldErrors();
			for (FieldError error : fieldErrors) {
				errorsMap.put(error.getField(), error.getDefaultMessage());
			}
			response.addInputError(errorsMap);
		}
		return response;
	}

	/**
	 * Saves or updates the DTO. Performs validation and uniqueness check before
	 * saving.
	 * 
	 * @param form          the form containing DTO with entity data
	 * @param bindingResult validation result from form validation
	 * @return ORSResponse with success status, message, and saved/updated DTO data
	 */
	@PostMapping(value = "/save")
	public ORSResponse save(@RequestBody @Valid F form, BindingResult bindingResult) {
		ORSResponse res = validate(bindingResult);
		if (!res.isSuccess()) {
			return res;
		}
		T dto = form.getDto();
		T existsDTO = service.findByUniqueKey(dto.getUniqueKey(), dto.getUniqueValue(), userContext);
		if (existsDTO != null && (dto.getId() == null || existsDTO.getId() != dto.getId())) {
			res.addMessage(dto.getLabel() + " already exists");
			res.setSuccess(false);
			return res;
		}

		Long exId = dto.getId();
		long id = service.save(dto, userContext);
		if (exId == null) {
			res.addMessage(dto.getTableName() + " added successfully");
			res.addData(dto);
		} else {
			res.addMessage(dto.getTableName() + " updated successfully");
			res.addData(dto);
		}

		return res;
	}

	/**
	 * Gets DTO by ID from the database.
	 * 
	 * @param id the entity ID to retrieve
	 * @return ORSResponse with DTO data if found, or error message if not found
	 */
	@GetMapping(value = "/get/{id}")
	public ORSResponse get(@PathVariable long id) {
		ORSResponse res = new ORSResponse(true);
		T dto = service.findById(id, userContext);
		if (dto != null) {
			res.addData(dto);
		} else {
			res.setSuccess(false);
			res.addMessage("Record not Found");
		}

		return res;
	}

	/**
	 * Deletes multiple entities by comma-separated IDs.
	 * 
	 * @param ids    comma-separated IDs to delete
	 * @param pageNo page number for search after deletion
	 * @param form   form with DTO for search criteria
	 * @return ORSResponse with success status, message, data list, and next page
	 *         size
	 */
	@PostMapping("/deleteMany/{ids}")
	public ORSResponse deleteMany(@PathVariable String ids, @RequestParam("pageNo") String pageNo,
			@RequestBody F form) {
		ORSResponse res = new ORSResponse(true);
		for (String id : ids.split(",")) {
			service.delete(Long.parseLong(id), userContext);
		}
		T dto = form.getDto();
		List<T> list = service.search(dto, Integer.parseInt(pageNo), pageSize, userContext);
		List<T> nextList = service.search(dto, Integer.parseInt(pageNo) + 1, pageSize, userContext);
		if (list.size() == 0) {
			res.setSuccess(false);
			res.addMessage("Record not found..!!");
		} else {
			res.setSuccess(true);
			res.addMessage("Records Deleted Successfully");
			res.addData(list);
			res.addResult("nextListSize", nextList.size());
		}
		return res;
	}

	/**
	 * Searches entities with pagination based on the provided form criteria.
	 * 
	 * @param form   optional form with DTO for search criteria
	 * @param pageNo page number for pagination (default 0)
	 * @return ORSResponse with list data, message, and next page size
	 */
	@RequestMapping(value = "/search/{pageNo}", method = { RequestMethod.GET, RequestMethod.POST })
	public ORSResponse search(@RequestBody(required = false) F form, @PathVariable(required = false) int pageNo) {
		ORSResponse response = new ORSResponse();
		pageNo = (pageNo == 0) ? 0 : pageNo;
		T dto = form.getDto();
		List<T> list = service.search(dto, pageNo, pageSize, userContext);
		List<T> nextList = service.search(dto, pageNo + 1, pageSize, userContext);
		if (list.isEmpty()) {
			response.addMessage("No Record Found");
		} else {
			response.setSuccess(true);
			response.addMessage("Records Found");
			response.addResult("nextListSize", nextList.size());
			response.addData(list);
		}
		return response;
	}
}