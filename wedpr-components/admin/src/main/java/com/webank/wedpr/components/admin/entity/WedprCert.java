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
@TableName("wedpr_cert")
@ApiModel(value = "WedprCert对象", description = "")
public class WedprCert implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "证书id")
    private String certId;

    @ApiModelProperty(value = "机构编号")
    private String agencyNo;

    @ApiModelProperty(value = "机构名")
    private String agencyName;

    @ApiModelProperty(value = "机构证书请求文件内容")
    private String csrFileText;

    @ApiModelProperty(value = "机构证书文件内容")
    private String certFileText;

    @ApiModelProperty(value = "过期时间")
    private LocalDateTime expireTime;

    @ApiModelProperty(value = "证书状态(0：无证书，1：有效，2：过期，3：禁用)")
    private Integer certStatus;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private String createBy;

    private String updateBy;

    public String getCertId() {
        return certId;
    }

    public void setCertId(String certId) {
        this.certId = certId;
    }

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

    public String getCsrFileText() {
        return csrFileText;
    }

    public void setCsrFileText(String csrFileText) {
        this.csrFileText = csrFileText;
    }

    public String getCertFileText() {
        return certFileText;
    }

    public void setCertFileText(String certFileText) {
        this.certFileText = certFileText;
    }

    public LocalDateTime getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(LocalDateTime expireTime) {
        this.expireTime = expireTime;
    }

    public Integer getCertStatus() {
        return certStatus;
    }

    public void setCertStatus(Integer certStatus) {
        this.certStatus = certStatus;
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
        return "WedprCert{"
                + "certId="
                + certId
                + ", agencyNo="
                + agencyNo
                + ", agencyName="
                + agencyName
                + ", csrFileText="
                + csrFileText
                + ", certFileText="
                + certFileText
                + ", expireTime="
                + expireTime
                + ", certStatus="
                + certStatus
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
