package com.rays.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rays.common.impl.BaseServiceImpl;
import com.rays.dao.TimetableDAOInt;
import com.rays.dto.TimetableDTO;
import com.rays.service.TimetableServiceInt;

@Service
@Transactional
public class TimetableServiceImpl extends BaseServiceImpl<TimetableDTO,TimetableDAOInt> implements TimetableServiceInt {

}
