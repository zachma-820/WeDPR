package com.webank.wedpr.components.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.webank.wedpr.components.admin.entity.WedprAgencyUser;
import com.webank.wedpr.components.admin.mapper.WedprAgencyUserMapper;
import com.webank.wedpr.components.admin.service.WedprAgencyUserService;
import org.springframework.stereotype.Service;

/**
 * 服务实现类
 *
 * @author caryliao
 * @since 2024-08-22
 */
@Service
public class WedprAgencyUserServiceImpl extends ServiceImpl<WedprAgencyUserMapper, WedprAgencyUser>
        implements WedprAgencyUserService {}
