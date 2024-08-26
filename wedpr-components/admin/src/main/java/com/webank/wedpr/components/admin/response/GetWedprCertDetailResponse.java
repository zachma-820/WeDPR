package com.webank.wedpr.components.admin.response;

import java.time.LocalDateTime;
import lombok.Data;

/** Created by caryliao on 2024/8/22 23:23 */
@Data
public class GetWedprCertDetailResponse {
    private String certId;
    private String agencyId;
    private LocalDateTime expireTime;
    private String csrFile;
}
