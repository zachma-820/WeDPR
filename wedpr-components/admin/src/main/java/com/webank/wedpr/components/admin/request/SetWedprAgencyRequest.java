package com.webank.wedpr.components.admin.request;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

/** Created by caryliao on 2024/8/22 16:58 */
@Data
public class SetWedprAgencyRequest {

    @Length(max = 64, message = "机构id最多64个字符")
    private String agencyId;

    @Max(value = 1, message = "agencyStatu只能为0和1: 0表示启用")
    @Min(value = 0, message = "agencyStatus只能为0和1: 1表示禁用")
    private Integer agencyStatus;
}
