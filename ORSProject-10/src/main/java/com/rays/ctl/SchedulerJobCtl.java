package com.rays.ctl;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.rays.common.BaseCtl;
import com.rays.common.DropdownList;
import com.rays.common.ORSResponse;
import com.rays.dto.SchedulerJobDTO;
import com.rays.form.SchedulerJobForm;
import com.rays.service.SchedulerJobServiceInt;

@RestController
@RequestMapping(value = "SchedulerJob")	
public class SchedulerJobCtl extends BaseCtl<SchedulerJobDTO, SchedulerJobForm, SchedulerJobServiceInt> {
	
	@GetMapping(value = "/preload")
	public ORSResponse preload() {
		ORSResponse res = new ORSResponse(true);
		List<DropdownList> statusList =	service.search(null, userContext);
		res.addResult("statusList", statusList);
		
		return res;
	}


}