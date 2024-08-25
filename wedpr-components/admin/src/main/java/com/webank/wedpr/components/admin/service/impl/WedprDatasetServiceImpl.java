package com.webank.wedpr.components.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.webank.wedpr.components.admin.entity.WedprDataset;
import com.webank.wedpr.components.admin.mapper.WedprDatasetMapper;
import com.webank.wedpr.components.admin.service.WedprDatasetService;
import org.springframework.stereotype.Service;

/**
 * 数据集记录表 服务实现类
 *
 * @author caryliao
 * @since 2024-08-22
 */
@Service
public class WedprDatasetServiceImpl extends ServiceImpl<WedprDatasetMapper, WedprDataset>
        implements WedprDatasetService {}
