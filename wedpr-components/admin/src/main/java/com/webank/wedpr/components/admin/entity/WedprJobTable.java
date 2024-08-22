package com.webank.wedpr.components.admin.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author caryliao
 * @since 2024-08-22
 */
@TableName("wedpr_job_table")
@ApiModel(value = "WedprJobTable对象", description = "")
public class WedprJobTable implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "任务ID")
    private String id;

    @ApiModelProperty(value = "任务名称")
    private String name;

    @ApiModelProperty(value = "任务所属项目")
    private String projectName;

    @ApiModelProperty(value = "任务发起人")
    private String owner;

    @ApiModelProperty(value = "任务发起机构")
    private String ownerAgency;

    @ApiModelProperty(value = "任务类型")
    private String jobType;

    @ApiModelProperty(value = "任务相关机构信息(json)")
    private String parties;

    @ApiModelProperty(value = "任务参数(json)")
    private String param;

    @ApiModelProperty(value = "任务状态")
    private String status;

    @ApiModelProperty(value = "任务执行结果(json)")
    private String jobResult;

    @ApiModelProperty(value = "任务创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "任务更新时间")
    private LocalDateTime lastUpdateTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getOwnerAgency() {
        return ownerAgency;
    }

    public void setOwnerAgency(String ownerAgency) {
        this.ownerAgency = ownerAgency;
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public String getParties() {
        return parties;
    }

    public void setParties(String parties) {
        this.parties = parties;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getJobResult() {
        return jobResult;
    }

    public void setJobResult(String jobResult) {
        this.jobResult = jobResult;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(LocalDateTime lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    @Override
    public String toString() {
        return "WedprJobTable{"
                + "id="
                + id
                + ", name="
                + name
                + ", projectName="
                + projectName
                + ", owner="
                + owner
                + ", ownerAgency="
                + ownerAgency
                + ", jobType="
                + jobType
                + ", parties="
                + parties
                + ", param="
                + param
                + ", status="
                + status
                + ", jobResult="
                + jobResult
                + ", createTime="
                + createTime
                + ", lastUpdateTime="
                + lastUpdateTime
                + "}";
    }
}
