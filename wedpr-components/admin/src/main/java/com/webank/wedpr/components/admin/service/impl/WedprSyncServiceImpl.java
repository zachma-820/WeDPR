package com.webank.wedpr.components.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.webank.wedpr.components.admin.common.Utils;
import com.webank.wedpr.components.admin.request.GetWedprAuditLogListRequest;
import com.webank.wedpr.components.admin.service.WedprSyncService;
import com.webank.wedpr.components.sync.dao.ResourceActionDO;
import com.webank.wedpr.components.sync.dao.SyncStatusMapper;
import com.webank.wedpr.components.sync.service.impl.ResourceStatusResult;
import java.time.LocalDateTime;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/** Created by caryliao on 2024/9/1 23:11 */
@Service
public class WedprSyncServiceImpl extends ServiceImpl<SyncStatusMapper, ResourceActionDO>
        implements WedprSyncService {
    @Override
    public ResourceStatusResult queryRecordSyncStatus(GetWedprAuditLogListRequest request) {
        LambdaQueryWrapper<ResourceActionDO> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        String ownerAgencyName = request.getOwnerAgencyName();
        String resourceAction = request.getResourceAction();
        String resourceType = request.getResourceType();
        String status = request.getStatus();
        String startTimeStr = request.getStartTime();
        String endTimeStr = request.getEndTime();
        Integer pageNum = request.getPageNum();
        Integer pageSize = request.getPageSize();
        if (!StringUtils.isEmpty(ownerAgencyName)) {
            lambdaQueryWrapper.like(ResourceActionDO::getAgency, ownerAgencyName);
        }
        if (!StringUtils.isEmpty(resourceAction)) {
            lambdaQueryWrapper.eq(ResourceActionDO::getResourceAction, resourceAction);
        }
        if (!StringUtils.isEmpty(resourceType)) {
            lambdaQueryWrapper.eq(ResourceActionDO::getResourceType, resourceType);
        }
        if (!StringUtils.isEmpty(status)) {
            lambdaQueryWrapper.eq(ResourceActionDO::getStatus, status);
        }
        if (!StringUtils.isEmpty(startTimeStr)) {
            LocalDateTime startTime = Utils.getLocalDateTime(startTimeStr);
            lambdaQueryWrapper.ge(ResourceActionDO::getCreateTime, startTime);
        }
        if (!StringUtils.isEmpty(endTimeStr)) {
            LocalDateTime endTime = Utils.getLocalDateTime(endTimeStr);
            lambdaQueryWrapper.le(ResourceActionDO::getCreateTime, endTime);
        }
        lambdaQueryWrapper.orderByDesc(ResourceActionDO::getLastUpdateTime);
        Page<ResourceActionDO> ResourceActionDOPage = new Page<>(pageNum, pageSize);
        Page<ResourceActionDO> page = page(ResourceActionDOPage, lambdaQueryWrapper);
        ResourceStatusResult resourceStatusResult = new ResourceStatusResult();
        resourceStatusResult.setTotal(page.getTotal());
        resourceStatusResult.setDataList(page.getRecords());
        return resourceStatusResult;
    }
}
