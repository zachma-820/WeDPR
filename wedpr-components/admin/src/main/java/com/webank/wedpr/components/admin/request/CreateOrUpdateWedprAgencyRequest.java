package com.webank.wedpr.components.admin.request;

import javax.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

/** Created by caryliao on 2024/8/22 16:58 */
@Data
public class CreateOrUpdateWedprAgencyRequest {

    @Length(max = 64, message = "机构id最多64个字符")
    private String agencyId;

    @NotBlank(message = "机构名不能为空")
    @Length(max = 64, message = "机构名最多64个字符")
    private String agencyName;

    @Length(max = 1000, message = "机构联系人最多1000个字符")
    private String agencyDesc;

    @NotBlank(message = "机构联系人不能为空")
    @Length(max = 64, message = "机构联系人最多64个字符")
    private String agencyContact;

    @NotBlank(message = "联系电话不能为空")
    @Length(max = 64, message = "联系电话最多64个字符")
    private String contactPhone;

    @NotBlank(message = "机构网关地址不能为空")
    @Length(max = 64, message = "机构网关地址最多64个字符")
    private String gatewayEndpoint;
}
