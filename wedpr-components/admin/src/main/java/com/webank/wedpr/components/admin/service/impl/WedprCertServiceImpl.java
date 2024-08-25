package com.webank.wedpr.components.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.webank.wedpr.components.admin.entity.WedprCert;
import com.webank.wedpr.components.admin.mapper.WedprCertMapper;
import com.webank.wedpr.components.admin.service.WedprCertService;
import org.springframework.stereotype.Service;

/**
 * 服务实现类
 *
 * @author caryliao
 * @since 2024-08-22
 */
@Service
public class WedprCertServiceImpl extends ServiceImpl<WedprCertMapper, WedprCert>
        implements WedprCertService {}
