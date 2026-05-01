package com.rays.dao.impl;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.springframework.stereotype.Repository;
import com.rays.common.impl.BaseDAOImpl;
import com.rays.dao.SchedulerJobDAOInt;
import com.rays.dto.SchedulerJobDTO;

@Repository
public class SchedulerJobDAOImpl extends BaseDAOImpl<SchedulerJobDTO> implements SchedulerJobDAOInt {


    @Override
    public Class<SchedulerJobDTO> getDTOClass() {
        return SchedulerJobDTO.class;
    }

	@Override
	protected List<Predicate> getWhereClause(SchedulerJobDTO dto, CriteriaBuilder builder,
			Root<SchedulerJobDTO> qRoot) {
		List<Predicate> whereCondition = new ArrayList<>();

        if (dto != null) {

            if (!isEmptyString(dto.getJobCode())) {
                whereCondition.add(builder.equal(qRoot.get("jobCode"), dto.getJobCode()));
            }

            if (!isEmptyString(dto.getJobName())) {
                whereCondition.add(builder.like(qRoot.get("jobName"), "%" + dto.getJobName() + "%"));
            }

            if (!isEmptyString(dto.getCronExpression())) {
                whereCondition.add(builder.equal(qRoot.get("cronExpression"), dto.getCronExpression()));
            }

            if (!isEmptyString(dto.getStatus())) {
                whereCondition.add(builder.equal(qRoot.get("status"), dto.getStatus()));
            }
        }

        return whereCondition;
	}
}