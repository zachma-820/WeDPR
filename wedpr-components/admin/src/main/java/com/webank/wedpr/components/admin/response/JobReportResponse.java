package com.webank.wedpr.components.admin.response;

import java.util.List;
import lombok.Data;

/** Created by caryliao on 2024/9/5 11:28 */
@Data
public class JobReportResponse {
    private Integer code;
    private String msg;
    private List<String> jobIdList;
}
