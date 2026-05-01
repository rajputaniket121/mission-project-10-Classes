package com.rays.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import com.rays.common.BaseForm;
import com.rays.dto.SchedulerJobDTO;

public class SchedulerJobForm extends BaseForm<SchedulerJobDTO> {

    @NotEmpty(message = "Job Code is required")
    @Pattern(regexp = "^[A-Z]+-[0-9]+$",message = "Job Code must be in ABC-1 only")
    private String jobCode;

    @NotEmpty(message = "Job Name is required")
    private String jobName;

    @NotEmpty(message = "Cron Expression is required")
    private String cronExpression;

    @NotNull(message = "Status is required")
    private String status;


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

    public SchedulerJobDTO getDto() {
        SchedulerJobDTO dto = initDTO(new SchedulerJobDTO());
        
        dto.setJobCode(jobCode);
        dto.setJobName(jobName);
        dto.setCronExpression(cronExpression);
        dto.setStatus(status);
        
        return dto;
    }

    @Override
    public String toString() {
        return "SchedulerJobForm [jobCode=" + jobCode + ", jobName=" + jobName + 
               ", cronExpression=" + cronExpression + ", status=" + status + "]";
    }
}