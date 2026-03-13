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

import com.rays.dto.UserDTO;

public abstract class BaseCtl<T extends BaseDTO, F extends BaseForm<T>, S extends BaseServiceInt<T>> {

	@Autowired
	protected S service;

	@Value("${page.size}")
	protected int pageSize = 0;

	protected UserContext userContext = null;

	@ModelAttribute
	public void setUserContext(HttpSession session) {
		userContext = (UserContext) session.getAttribute("userContext");
		if (userContext == null) {
			UserDTO dto = new UserDTO();
			dto.setLoginId("rajput@gmail.com"); // fallback
			userContext = new UserContext(dto);
		}
	}

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

	@PostMapping(value = "save")
	public ORSResponse save(@RequestBody @Valid F form, BindingResult bindingResult) {

		ORSResponse res = new ORSResponse();

		res = validate(bindingResult);

		if (!res.isSuccess()) {
			return res;
		}

		try {
			T dto = form.getDto();

			if (dto.getUniqueKey() != null && !dto.getUniqueKey().equals("")) {

				T existsDTO = service.findByUniqueKey(dto.getUniqueKey(), dto.getUniqueValue(), userContext);
				System.out.println(existsDTO != null && (dto.getId() == 0 || existsDTO.getId() != dto.getId()));

				if (existsDTO != null && (dto.getId() == 0 || existsDTO.getId() != dto.getId())) {
					res.addMessage(dto.getLabel() + " already exists");
					res.setSuccess(false);
					return res;
				}
			}

			long exId = dto.getId();

			long id = service.save(dto, userContext);
			if (id > 0 && exId == 0) {
				res.addMessage(dto.getTableName() + " added successfully");
				res.addData(dto);
			} else if (id == dto.getId()) {
				res.addMessage(dto.getTableName() + " updated successfully");
				res.addData(dto);
			} else {
				res.addMessage("issue in adding");
				res.setSuccess(false);
			}
		} catch (Exception e) {
			res.setSuccess(false);
			res.addMessage(e.getMessage());
			e.printStackTrace();
		}
		return res;
	}

	@GetMapping(value = "get/{id}")
	public ORSResponse get(@PathVariable long id) {
		ORSResponse res = new ORSResponse(true);
		try {

			T dto = service.findById(id, userContext);

			if (dto != null) {
				res.addData(dto);
			} else {
				res.setSuccess(false);
				res.addMessage("Record not Found");
			}
		} catch (Exception e) {
			res.setSuccess(false);
			res.addMessage(e.getMessage());
			e.printStackTrace();
		}
		return res;
	}

	@PostMapping(value = "delete/{ids}")
	public ORSResponse delete(@PathVariable Long[] ids) {
		ORSResponse res = new ORSResponse();
		try {
			for (long id : ids) {
				service.delete(id, userContext);
			}
			res.setSuccess(true);
			res.addMessage("Records Deleted Successfully");
		} catch (Exception e) {
			res.setSuccess(false);
			res.addMessage("Error in Delete");
			res.addMessage(e.getMessage());
			e.printStackTrace();
		}
		return res;
	}

	@RequestMapping(value = "search/{pageNo}", method = { RequestMethod.GET, RequestMethod.POST })
	public ORSResponse search(@RequestBody(required = false) F form, @PathVariable(required = false) int pageNo) {
		ORSResponse response = new ORSResponse();

		try {
			pageNo = (pageNo < 0) ? 0 : pageNo;

			T dto = form.getDto();
			

			if(dto.getId()==0) {
				dto = null;
			}
			
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
		} catch (Exception e) {
			response.setSuccess(false);
			response.addMessage("Error in Delete");
			response.addMessage(e.getMessage());
			e.printStackTrace();
		}
		return response;
	}

}
