package com.rays.ctl;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.rays.common.BaseCtl;
import com.rays.common.DropdownList;
import com.rays.common.ORSResponse;
import com.rays.dto.RoleDTO;
import com.rays.form.RoleForm;
import com.rays.service.RoleServiceInt;

/**
 * Controller for managing Role entities. Provides REST endpoints for CRUD
 * operations and preload data.
 * 
 * @author Aniket Rajput
 */
@RestController
@RequestMapping(value = "Role")
public class RoleCtl extends BaseCtl<RoleDTO, RoleForm, RoleServiceInt> {

	/**
	 * Preloads role list for dropdown in forms.
	 * 
	 * @return ORSResponse containing roleList for dropdown selection
	 */
	@GetMapping(value = "preload")
	public ORSResponse preload() {
		ORSResponse orsResponse = new ORSResponse(true);
		try {
			List<DropdownList> roleList = service.search(null, userContext);
			orsResponse.addResult("roleList", roleList);
		} catch (Exception e) {
			orsResponse.setSuccess(false);
			orsResponse.addMessage(e.getMessage());
			e.printStackTrace();
		}
		return orsResponse;
	}

}