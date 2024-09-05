package com.webank.wedpr.components.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.webank.wedpr.components.admin.entity.WedprProjectTable;
import com.webank.wedpr.components.admin.request.GetWedprProjectListRequest;
import com.webank.wedpr.components.admin.response.ListProjectResponse;

/**
 * 服务类
 *
 * @author caryliao
 * @since 2024-09-04
 */
public interface WedprProjectTableService extends IService<WedprProjectTable> {

    ListProjectResponse listProject(GetWedprProjectListRequest getWedprProjectListRequest);
}
