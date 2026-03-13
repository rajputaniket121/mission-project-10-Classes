package com.rays.common.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.rays.common.BaseDAOInt;
import com.rays.common.BaseDTO;
import com.rays.common.BaseServiceInt;
import com.rays.common.UserContext;

@Transactional
public class BaseServiceImpl<T extends BaseDTO,D extends BaseDAOInt<T>> implements BaseServiceInt<T> {
	
	@Autowired
	protected D dao;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public long add(T dto, UserContext userContext) {
		 long id = dao.add(dto, userContext);
		return id;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void update(T dto, UserContext userContext) {
		T existDto = findById(dto.getId(), userContext);
		if(existDto!=null) {
			dto.setCreatedBy(existDto.getCreatedBy());
			dto.setCreatedDateTime(existDto.getCreatedDateTime());
		}
		dao.update(dto, userContext);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public long save(T dto, UserContext userContext) {
		Long id = dto.getId();
		if(id != null && id > 0) {
			update(dto, userContext);
		}else {
			id = add(dto, userContext);
		}
		return id;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public T delete(long id, UserContext userContext) {
		T dto = findById(id, userContext);
		dao.delete(dto, userContext);
		return dto;
	}

	@Override
	@Transactional(readOnly = true)
	public T findById(long id, UserContext userContext) {
		T dto =  dao.findByPk(id, userContext);
		return dto;
	}

	@Override
	@Transactional(readOnly = true)
	public T findByUniqueKey(String attribute, String val, UserContext userContext) {
		T dto =  dao.findByUniqueKey(attribute, val, userContext);
		return dto;
	}

	@Override
	@Transactional(readOnly = true)
	public List search(T dto, int pageNo, int pageSize, UserContext userContext) {
		List<T> list =  dao.search(dto, pageNo, pageSize, userContext);
		return list;
	}

	@Override
	@Transactional(readOnly = true)
	public List search(T dto, UserContext userContext) {
		return search(dto, 0, 0, userContext);
	}

}
