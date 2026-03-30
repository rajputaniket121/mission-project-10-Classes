package com.rays.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rays.common.impl.BaseServiceImpl;
import com.rays.dao.impl.AttachmentDAOImpl;
import com.rays.dto.AttachmentDTO;
import com.rays.service.AttachmentServiceInt;

/**
 * Implementation of AttachmentServiceInt interface. Provides business logic
 * operations for managing file attachments.
 * 
 * @author Aniket Rajput
 */
@Service
@Transactional
public class AttachmentServiceImpl extends BaseServiceImpl<AttachmentDTO, AttachmentDAOImpl>
		implements AttachmentServiceInt {

}