package com.webank.wedpr.components.admin.common;

import com.webank.wedpr.components.token.auth.TokenUtils;
import com.webank.wedpr.components.token.auth.model.UserToken;
import com.webank.wedpr.core.protocol.UserRoleEnum;
import com.webank.wedpr.core.utils.WeDPRException;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

/** Created by caryliao on 2024/8/22 22:29 */
@Slf4j
public class Utils {
    public static UserToken checkPermission(HttpServletRequest request) throws WeDPRException {
        UserToken userToken = TokenUtils.getLoginUser(request);
        String username = userToken.getUsername();
        if (!UserRoleEnum.AGENCY_ADMIN.getRoleName().equals(userToken.getRoleName())) {
            log.info("用户名：{}， 角色：{}", username, userToken.getRoleName());
            throw new WeDPRException("无权限访问该接口");
        }
        return userToken;
    }
}
