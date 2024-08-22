package com.webank.wedpr.components.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.webank.wedpr.components.admin.entity.WedprProjectTable;
import com.webank.wedpr.components.admin.mapper.WedprProjectTableMapper;
import com.webank.wedpr.components.admin.service.WedprProjectTableService;
import org.springframework.stereotype.Service;

/**
 * 服务实现类
 *
 * @author caryliao
 * @since 2024-08-22
 */
@Service
public class WedprProjectTableServiceImpl
        extends ServiceImpl<WedprProjectTableMapper, WedprProjectTable>
        implements WedprProjectTableService {}
