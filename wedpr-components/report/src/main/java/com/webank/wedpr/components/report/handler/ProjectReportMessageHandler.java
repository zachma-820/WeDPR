package com.webank.wedpr.components.report.handler;

import com.webank.wedpr.components.transport.Transport;
import com.webank.wedpr.components.transport.model.Message;
import com.webank.wedpr.core.utils.WeDPRException;

/** Created by caryliao on 2024/9/4 10:54 */
public class ProjectReportMessageHandler implements Transport.MessageHandler {
    @Override
    public void call(Message msg) throws WeDPRException {
        byte[] payload = msg.getPayload();
    }
}
