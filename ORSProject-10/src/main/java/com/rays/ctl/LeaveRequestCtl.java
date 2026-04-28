package com.rays.ctl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.common.DropdownList;
import com.rays.common.ORSResponse;
import com.rays.dto.LeaveRequestDTO;
import com.rays.dto.UserDTO;
import com.rays.form.LeaveRequestForm;
import com.rays.service.LeaveRequestServiceInt;
import com.rays.service.UserServiceInt;

@RestController
@RequestMapping(value = "LeaveRequest")
public class LeaveRequestCtl extends BaseCtl<LeaveRequestDTO, LeaveRequestForm, LeaveRequestServiceInt> {

	@Autowired
	private UserServiceInt userService;

	@GetMapping(value = "/preload")
	public ORSResponse preload() {
		ORSResponse orsResponse = new ORSResponse(true);
		List<DropdownList> leaveRequestList = service.search(null, userContext);
		orsResponse.addResult("leaveRequestList", leaveRequestList);
		
		List<DropdownList> employeeList = userService.search(null, userContext);
		orsResponse.addResult("employeeList", employeeList);

		return orsResponse;

	}

}