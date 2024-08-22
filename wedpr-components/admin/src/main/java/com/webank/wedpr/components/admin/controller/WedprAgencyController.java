package com.webank.wedpr.components.admin.controller;

import com.webank.wedpr.components.admin.common.Utils;
import com.webank.wedpr.components.admin.request.CreateOrUpdateWedprAgencyRequest;
import com.webank.wedpr.components.admin.response.CreateOrUpdateWedprAgencyResponse;
import com.webank.wedpr.components.admin.service.WedprAgencyService;
import com.webank.wedpr.components.token.auth.model.UserToken;
import com.webank.wedpr.core.utils.Constant;
import com.webank.wedpr.core.utils.WeDPRResponse;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 前端控制器
 *
 * @author caryliao
 * @since 2024-08-22
 */
@RestController
@RequestMapping(
        path = Constant.WEDPR_API_PREFIX + "/admin",
        produces = {"application/json"})
@Slf4j
public class WedprAgencyController {
    @Autowired private WedprAgencyService wedprAgencyService;
    /**
     * 创建或更新机构信息
     *
     * @param createOrUpdateWedprAgencyRequest
     * @param request
     * @return
     */
    @PostMapping("/createAgency")
    public WeDPRResponse createGroup(
            @Valid @RequestBody CreateOrUpdateWedprAgencyRequest createOrUpdateWedprAgencyRequest,
            HttpServletRequest request) {
        try {
            // check user permission
            UserToken userToken = Utils.checkPermission(request);
            String agencyNo =
                    wedprAgencyService.createOrUpdateAgency(
                            createOrUpdateWedprAgencyRequest, userToken);
            CreateOrUpdateWedprAgencyResponse response = new CreateOrUpdateWedprAgencyResponse();
            response.setAgencyNo(agencyNo);
            return new WeDPRResponse(Constant.WEDPR_SUCCESS, Constant.WEDPR_SUCCESS_MSG, response);
        } catch (Exception e) {
            log.error("create or update agency error", e);
            return new WeDPRResponse(Constant.WEDPR_FAILED, e.getMessage());
        }
    }
}
