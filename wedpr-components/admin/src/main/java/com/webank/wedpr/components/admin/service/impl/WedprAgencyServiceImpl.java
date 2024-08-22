package com.webank.wedpr.components.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.webank.wedpr.components.admin.entity.WedprAgency;
import com.webank.wedpr.components.admin.mapper.WedprAgencyMapper;
import com.webank.wedpr.components.admin.request.CreateOrUpdateWedprAgencyRequest;
import com.webank.wedpr.components.admin.service.WedprAgencyService;
import com.webank.wedpr.components.token.auth.model.UserToken;
import com.webank.wedpr.core.utils.Constant;
import com.webank.wedpr.core.utils.WeDPRException;
import java.time.LocalDateTime;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * 服务实现类
 *
 * @author caryliao
 * @since 2024-08-22
 */
@Service
public class WedprAgencyServiceImpl extends ServiceImpl<WedprAgencyMapper, WedprAgency>
        implements WedprAgencyService {
    public String createOrUpdateAgency(
            CreateOrUpdateWedprAgencyRequest createOrUpdateWedprAgencyRequest, UserToken userToken)
            throws WeDPRException {
        String username = userToken.getUsername();
        String agencyNo = createOrUpdateWedprAgencyRequest.getAgencyNo();
        if (StringUtils.isEmpty(agencyNo)) {
            LambdaQueryWrapper<WedprAgency> lambdaQueryWrapper = new LambdaQueryWrapper<>();
            String agencyName = createOrUpdateWedprAgencyRequest.getAgencyName();
            lambdaQueryWrapper.eq(WedprAgency::getAgencyName, agencyName);
            WedprAgency queriedWedprAgency = getOne(lambdaQueryWrapper);
            // check agencyName
            if (queriedWedprAgency != null) {
                throw new WeDPRException(Constant.WEDPR_FAILED, "agencyName is already exists");
            } else {
                // save agency
                WedprAgency wedprAgency = new WedprAgency();
                wedprAgency.setAgencyName(createOrUpdateWedprAgencyRequest.getAgencyName());
                wedprAgency.setAgencyContact(createOrUpdateWedprAgencyRequest.getAgencyContact());
                wedprAgency.setContactPhone(createOrUpdateWedprAgencyRequest.getContactPhone());
                wedprAgency.setAgencyDesc(createOrUpdateWedprAgencyRequest.getAgencyDesc());
                wedprAgency.setGatewayEndpoint(
                        createOrUpdateWedprAgencyRequest.getGatewayEndpoint());
                wedprAgency.setCreateBy(username);
                wedprAgency.setUpdateBy(username);
                save(wedprAgency);
                return wedprAgency.getAgencyNo();
            }
        } else {
            WedprAgency queriedWedprAgency = getById(agencyNo);
            if (queriedWedprAgency == null) {
                throw new WeDPRException(Constant.WEDPR_FAILED, "agency does not exists");
            }
            // update agency
            queriedWedprAgency.setAgencyNo(createOrUpdateWedprAgencyRequest.getAgencyNo());
            queriedWedprAgency.setAgencyName(createOrUpdateWedprAgencyRequest.getAgencyName());
            queriedWedprAgency.setAgencyContact(
                    createOrUpdateWedprAgencyRequest.getAgencyContact());
            queriedWedprAgency.setContactPhone(createOrUpdateWedprAgencyRequest.getContactPhone());
            queriedWedprAgency.setAgencyDesc(createOrUpdateWedprAgencyRequest.getAgencyDesc());
            queriedWedprAgency.setGatewayEndpoint(
                    createOrUpdateWedprAgencyRequest.getGatewayEndpoint());
            queriedWedprAgency.setUpdateBy(username);
            queriedWedprAgency.setUpdateTime(LocalDateTime.now());
            updateById(queriedWedprAgency);
            return agencyNo;
        }
    }
}
