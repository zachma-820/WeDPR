package com.webank.wedpr.components.report.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.webank.wedpr.components.dataset.dao.Dataset;
import com.webank.wedpr.components.report.mapper.WedprDatasetMapper;
import com.webank.wedpr.components.report.service.WedprDatasetService;
import org.springframework.stereotype.Service;

/**
 * 数据集记录表 服务实现类
 *
 * @author caryliao
 * @since 2024-08-27
 */
@Service
public class WedprDatasetServiceImpl extends ServiceImpl<WedprDatasetMapper, Dataset>
        implements WedprDatasetService {}
