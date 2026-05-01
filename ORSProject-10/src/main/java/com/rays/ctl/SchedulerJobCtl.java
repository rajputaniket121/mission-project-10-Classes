package com.rays.ctl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.rays.common.BaseCtl;
import com.rays.dto.SchedulerJobDTO;
import com.rays.form.SchedulerJobForm;
import com.rays.service.SchedulerJobServiceInt;

@RestController
@RequestMapping(value = "SchedulerJob")	
public class SchedulerJobCtl extends BaseCtl<SchedulerJobDTO, SchedulerJobForm, SchedulerJobServiceInt> {


}