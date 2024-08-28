package com.webank.wedpr.components.report.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 数据集记录表
 *
 * @author caryliao
 * @since 2024-08-27
 */
@TableName("wedpr_dataset")
@ApiModel(value = "WedprDataset对象", description = "数据集记录表")
public class WedprDataset implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "数据集id")
    private String datasetId;

    @ApiModelProperty(value = "数据集标题")
    private String datasetTitle;

    @ApiModelProperty(value = "数据集标签")
    private String datasetLabel;

    @ApiModelProperty(value = "数据集描述")
    private String datasetDesc;

    @ApiModelProperty(value = "数据源字段以及预览信息")
    private String datasetFields;

    @ApiModelProperty(value = "数据集hash")
    private String datasetVersionHash;

    @ApiModelProperty(value = "数据集大小")
    private Long datasetDataSize;

    @ApiModelProperty(value = "数据集记录数目")
    private Long datasetRecordCount;

    @ApiModelProperty(value = "数据集列数目")
    private Integer datasetColumnCount;

    @ApiModelProperty(value = "数据集存储类型")
    private String datasetStorageType;

    @ApiModelProperty(value = "数据集存储路径")
    private String datasetStoragePath;

    @ApiModelProperty(value = "数据集所属机构id")
    private String ownerAgencyId;

    @ApiModelProperty(value = "数据集所属机构名称")
    private String ownerAgencyName;

    @ApiModelProperty(value = "数据集所属用户名id")
    private String ownerUserId;

    @ApiModelProperty(value = "数据集所属用户名")
    private String ownerUserName;

    @ApiModelProperty(value = "数据源类型 : CSV、DB、XLSX、FPS、HDFS、HIVE")
    private String dataSourceType;

    @ApiModelProperty(value = "数据源参数信息，JSON字符串")
    private String dataSourceMeta;

    @ApiModelProperty(value = "数据集可见性, 0: 私有，1: 公开可见")
    private Integer visibility;

    @ApiModelProperty(value = "数据源可见范围描述, visibility 为1时有效")
    private String visibilityDetails;

    @ApiModelProperty(value = "数据集状态, 0: 有效，其他无效")
    private Integer status;

    @ApiModelProperty(value = "数据集状态描述")
    private String statusDesc;

    private LocalDateTime createAt;

    private LocalDateTime updateAt;

    public String getDatasetId() {
        return datasetId;
    }

    public void setDatasetId(String datasetId) {
        this.datasetId = datasetId;
    }

    public String getDatasetTitle() {
        return datasetTitle;
    }

    public void setDatasetTitle(String datasetTitle) {
        this.datasetTitle = datasetTitle;
    }

    public String getDatasetLabel() {
        return datasetLabel;
    }

    public void setDatasetLabel(String datasetLabel) {
        this.datasetLabel = datasetLabel;
    }

    public String getDatasetDesc() {
        return datasetDesc;
    }

    public void setDatasetDesc(String datasetDesc) {
        this.datasetDesc = datasetDesc;
    }

    public String getDatasetFields() {
        return datasetFields;
    }

    public void setDatasetFields(String datasetFields) {
        this.datasetFields = datasetFields;
    }

    public String getDatasetVersionHash() {
        return datasetVersionHash;
    }

    public void setDatasetVersionHash(String datasetVersionHash) {
        this.datasetVersionHash = datasetVersionHash;
    }

    public Long getDatasetDataSize() {
        return datasetDataSize;
    }

    public void setDatasetDataSize(Long datasetDataSize) {
        this.datasetDataSize = datasetDataSize;
    }

    public Long getDatasetRecordCount() {
        return datasetRecordCount;
    }

    public void setDatasetRecordCount(Long datasetRecordCount) {
        this.datasetRecordCount = datasetRecordCount;
    }

    public Integer getDatasetColumnCount() {
        return datasetColumnCount;
    }

    public void setDatasetColumnCount(Integer datasetColumnCount) {
        this.datasetColumnCount = datasetColumnCount;
    }

    public String getDatasetStorageType() {
        return datasetStorageType;
    }

    public void setDatasetStorageType(String datasetStorageType) {
        this.datasetStorageType = datasetStorageType;
    }

    public String getDatasetStoragePath() {
        return datasetStoragePath;
    }

    public void setDatasetStoragePath(String datasetStoragePath) {
        this.datasetStoragePath = datasetStoragePath;
    }

    public String getOwnerAgencyId() {
        return ownerAgencyId;
    }

    public void setOwnerAgencyId(String ownerAgencyId) {
        this.ownerAgencyId = ownerAgencyId;
    }

    public String getOwnerAgencyName() {
        return ownerAgencyName;
    }

    public void setOwnerAgencyName(String ownerAgencyName) {
        this.ownerAgencyName = ownerAgencyName;
    }

    public String getOwnerUserId() {
        return ownerUserId;
    }

    public void setOwnerUserId(String ownerUserId) {
        this.ownerUserId = ownerUserId;
    }

    public String getOwnerUserName() {
        return ownerUserName;
    }

    public void setOwnerUserName(String ownerUserName) {
        this.ownerUserName = ownerUserName;
    }

    public String getDataSourceType() {
        return dataSourceType;
    }

    public void setDataSourceType(String dataSourceType) {
        this.dataSourceType = dataSourceType;
    }

    public String getDataSourceMeta() {
        return dataSourceMeta;
    }

    public void setDataSourceMeta(String dataSourceMeta) {
        this.dataSourceMeta = dataSourceMeta;
    }

    public Integer getVisibility() {
        return visibility;
    }

    public void setVisibility(Integer visibility) {
        this.visibility = visibility;
    }

    public String getVisibilityDetails() {
        return visibilityDetails;
    }

    public void setVisibilityDetails(String visibilityDetails) {
        this.visibilityDetails = visibilityDetails;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getStatusDesc() {
        return statusDesc;
    }

    public void setStatusDesc(String statusDesc) {
        this.statusDesc = statusDesc;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }

    public LocalDateTime getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(LocalDateTime updateAt) {
        this.updateAt = updateAt;
    }

    @Override
    public String toString() {
        return "WedprDataset{"
                + "datasetId="
                + datasetId
                + ", datasetTitle="
                + datasetTitle
                + ", datasetLabel="
                + datasetLabel
                + ", datasetDesc="
                + datasetDesc
                + ", datasetFields="
                + datasetFields
                + ", datasetVersionHash="
                + datasetVersionHash
                + ", datasetDataSize="
                + datasetDataSize
                + ", datasetRecordCount="
                + datasetRecordCount
                + ", datasetColumnCount="
                + datasetColumnCount
                + ", datasetStorageType="
                + datasetStorageType
                + ", datasetStoragePath="
                + datasetStoragePath
                + ", ownerAgencyId="
                + ownerAgencyId
                + ", ownerAgencyName="
                + ownerAgencyName
                + ", ownerUserId="
                + ownerUserId
                + ", ownerUserName="
                + ownerUserName
                + ", dataSourceType="
                + dataSourceType
                + ", dataSourceMeta="
                + dataSourceMeta
                + ", visibility="
                + visibility
                + ", visibilityDetails="
                + visibilityDetails
                + ", status="
                + status
                + ", statusDesc="
                + statusDesc
                + ", createAt="
                + createAt
                + ", updateAt="
                + updateAt
                + "}";
    }
}
