package com.rays.service.impl;

import org.springframework.stereotype.Service;
import com.rays.common.impl.BaseServiceImpl;
import com.rays.dao.SchedulerJobDAOInt;
import com.rays.dto.SchedulerJobDTO;
import com.rays.service.SchedulerJobServiceInt;

@Service
public class SchedulerJobServiceImpl extends BaseServiceImpl<SchedulerJobDTO, SchedulerJobDAOInt> implements SchedulerJobServiceInt {

}