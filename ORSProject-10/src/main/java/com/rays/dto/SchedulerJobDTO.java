package com.rays.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import com.rays.common.BaseDTO;

@Entity
@Table(name = "ST_SCHEDULER_JOB")
public class SchedulerJobDTO extends BaseDTO {

    @Column(name = "JOB_CODE", length = 50, unique = true)
    private String jobCode;

    @Column(name = "JOB_NAME", length = 100)
    private String jobName;

    @Column(name = "CRON_EXPRESSION", length = 100)
    private String cronExpression;

    @Column(name = "STATUS", length = 50)
    private String status;

    // Getters and Setters

    public String getJobCode() {
        return jobCode;
    }

    public void setJobCode(String jobCode) {
        this.jobCode = jobCode;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getCronExpression() {
        return cronExpression;
    }

    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "SchedulerJobDTO [jobCode=" + jobCode + ", jobName=" + jobName + 
               ", cronExpression=" + cronExpression + ", status=" + status + "]";
    }

    @Override
    public String getKey() {
        return getId() != null ? String.valueOf(getId()) : "";
    }

    @Override
    public String getValue() {
        return jobName != null ? jobName : "";
    }

    @Override
    public String getUniqueKey() {
        return "jobCode";
    }

    @Override
    public String getUniqueValue() {
        return jobCode;
    }

    @Override
    public String getLabel() {
        return "Job Code";
    }

    @Override
    public String getTableName() {
        return "Scheduler Job";
    }
}