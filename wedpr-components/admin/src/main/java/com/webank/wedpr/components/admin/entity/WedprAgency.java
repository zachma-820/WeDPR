package com.webank.wedpr.components.admin.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author caryliao
 * @since 2024-08-22
 */
@TableName("wedpr_agency")
@ApiModel(value = "WedprAgency对象", description = "")
public class WedprAgency implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("agency_no")
    @ApiModelProperty(value = "机构编号")
    private String agencyNo;

    @ApiModelProperty(value = "机构名")
    private String agencyName;

    @ApiModelProperty(value = "机构描述")
    private String agencyDesc;

    @ApiModelProperty(value = "机构联系人")
    private String agencyContact;

    @ApiModelProperty(value = "联系电话")
    private String contactPhone;

    @ApiModelProperty(value = "网关地址")
    private String gatewayEndpoint;

    @ApiModelProperty(value = "机构状态(0:启用，1:禁用)")
    private Integer agencyStatus;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private String createBy;

    private String updateBy;

    public String getAgencyNo() {
        return agencyNo;
    }

    public void setAgencyNo(String agencyNo) {
        this.agencyNo = agencyNo;
    }

    public String getAgencyName() {
        return agencyName;
    }

    public void setAgencyName(String agencyName) {
        this.agencyName = agencyName;
    }

    public String getAgencyDesc() {
        return agencyDesc;
    }

    public void setAgencyDesc(String agencyDesc) {
        this.agencyDesc = agencyDesc;
    }

    public String getAgencyContact() {
        return agencyContact;
    }

    public void setAgencyContact(String agencyContact) {
        this.agencyContact = agencyContact;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getGatewayEndpoint() {
        return gatewayEndpoint;
    }

    public void setGatewayEndpoint(String gatewayEndpoint) {
        this.gatewayEndpoint = gatewayEndpoint;
    }

    public Integer getAgencyStatus() {
        return agencyStatus;
    }

    public void setAgencyStatus(Integer agencyStatus) {
        this.agencyStatus = agencyStatus;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    @Override
    public String toString() {
        return "WedprAgency{"
                + "agencyNo="
                + agencyNo
                + ", agencyName="
                + agencyName
                + ", agencyDesc="
                + agencyDesc
                + ", agencyContact="
                + agencyContact
                + ", contactPhone="
                + contactPhone
                + ", gatewayEndpoint="
                + gatewayEndpoint
                + ", agencyStatus="
                + agencyStatus
                + ", createTime="
                + createTime
                + ", updateTime="
                + updateTime
                + ", createBy="
                + createBy
                + ", updateBy="
                + updateBy
                + "}";
    }
}
