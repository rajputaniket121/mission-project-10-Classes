package com.rays.ctl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.common.DropdownList;
import com.rays.common.ORSResponse;
import com.rays.dto.RoleDTO;
import com.rays.dto.UserDTO;
import com.rays.form.UserForm;
import com.rays.service.RoleServiceInt;
import com.rays.service.UserServiceInt;

@RestController
@RequestMapping(value = "User")
public class UserCtl extends BaseCtl<UserDTO, UserForm, UserServiceInt> {
	@Autowired
	private RoleServiceInt roleService;
	
	@GetMapping(value = "preload")
	public ORSResponse preload() {
		ORSResponse orsResponse = new ORSResponse(true);
		try {
			List<DropdownList> roleList = roleService.search(null, userContext);
			orsResponse.addResult("roleList",roleList);
		}catch (Exception e) {
			orsResponse.setSuccess(false);
			orsResponse.addMessage(e.getMessage());
			e.printStackTrace();
		}
		return orsResponse;
	}
}
