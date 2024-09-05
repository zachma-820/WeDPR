package com.webank.wedpr.components.report.handler;

import com.webank.wedpr.components.transport.model.Message;
import lombok.Data;

/** Created by caryliao on 2024/9/4 11:04 */
@Data
public class ProjectMessage implements Message {
    private String id;
    private String name;
    private String projectDesc;
    private String owner;
    private String ownerAgency;
    private String label;
    private Integer reportStatus;
    private String projectType;
    private String createTime;
    private String lastUpdateTime;

    @Override
    public MessageHeader getHeader() {
        return null;
    }

    @Override
    public byte[] getPayload() {
        return new byte[0];
    }
}
