package com.webank.wedpr.components.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.webank.wedpr.components.admin.common.Utils;
import com.webank.wedpr.components.admin.request.GetWedprDatasetListRequest;
import com.webank.wedpr.components.admin.service.WedprDatasetService;
import com.webank.wedpr.components.dataset.dao.Dataset;
import com.webank.wedpr.components.dataset.mapper.DatasetMapper;
import com.webank.wedpr.components.dataset.message.ListDatasetResponse;
import java.time.LocalDateTime;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * 数据集记录表 服务实现类
 *
 * @author caryliao
 * @since 2024-08-29
 */
@Service
public class WedprDatasetServiceImpl extends ServiceImpl<DatasetMapper, Dataset>
        implements WedprDatasetService {

    @Override
    public ListDatasetResponse listDataset(GetWedprDatasetListRequest getWedprDatasetListRequest) {
        LambdaQueryWrapper<Dataset> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        String ownerAgencyName = getWedprDatasetListRequest.getOwnerAgencyName();
        String datasetTitle = getWedprDatasetListRequest.getDatasetTitle();
        String startTimeStr = getWedprDatasetListRequest.getStartTime();
        String endTimeStr = getWedprDatasetListRequest.getEndTime();
        Integer pageNum = getWedprDatasetListRequest.getPageNum();
        Integer pageSize = getWedprDatasetListRequest.getPageSize();
        if (!StringUtils.isEmpty(ownerAgencyName)) {
            lambdaQueryWrapper.like(Dataset::getOwnerAgencyName, ownerAgencyName);
        }
        if (!StringUtils.isEmpty(datasetTitle)) {
            lambdaQueryWrapper.like(Dataset::getDatasetTitle, datasetTitle);
        }
        if (!StringUtils.isEmpty(startTimeStr)) {
            LocalDateTime startTime = Utils.getLocalDateTime(startTimeStr);
            lambdaQueryWrapper.ge(Dataset::getCreateAt, startTime);
        }
        if (!StringUtils.isEmpty(endTimeStr)) {
            LocalDateTime endTime = Utils.getLocalDateTime(endTimeStr);
            lambdaQueryWrapper.le(Dataset::getCreateAt, endTime);
        }
        lambdaQueryWrapper.orderByDesc(Dataset::getUpdateAt);
        Page<Dataset> datasetPage = new Page<>(pageNum, pageSize);
        Page<Dataset> page = page(datasetPage, lambdaQueryWrapper);
        ListDatasetResponse listDatasetResponse =
                ListDatasetResponse.builder()
                        .totalCount(page.getTotal())
                        .isLast(!page.hasNext())
                        .content(page.getRecords())
                        .build();
        return listDatasetResponse;
    }
}
