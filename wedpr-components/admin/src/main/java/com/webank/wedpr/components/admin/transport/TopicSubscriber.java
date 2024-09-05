package com.webank.wedpr.components.admin.transport;

import com.webank.wedpr.components.admin.entity.WedprProjectTable;
import com.webank.wedpr.components.admin.service.WedprProjectTableService;
import com.webank.wedpr.components.transport.Transport;
import com.webank.wedpr.core.protocol.TransportTopicEnum;
import com.webank.wedpr.core.utils.ObjectMapperFactory;
import java.io.IOException;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

/** Created by caryliao on 2024/9/4 15:03 */
@Service
@Slf4j
public class TopicSubscriber implements CommandLineRunner {
    private Transport transport;

    @Autowired private WedprProjectTableService wedprProjectTableService;

    @Override
    public void run(String... args) throws Exception {
        try {
            subscribeProjectTopic();
        } catch (Exception e) {
            log.warn("subscribe topic error", e);
        }
    }

    private void subscribeProjectTopic() {
        transport.registerTopicHandler(
                TransportTopicEnum.PROJECT_REPORT.name(),
                (message) -> {
                    byte[] payload = message.getPayload();
                    List<WedprProjectTable> wedprProjectTableList = null;
                    try {
                        wedprProjectTableList =
                                (List<WedprProjectTable>)
                                        ObjectMapperFactory.getObjectMapper()
                                                .readValue(payload, List.class);
                    } catch (IOException e) {
                        log.warn("parse message error", e);
                    }
                    for (WedprProjectTable wedprProjectTable : wedprProjectTableList) {
                        String id = wedprProjectTable.getId();
                        WedprProjectTable queriedWedprProjectTable =
                                wedprProjectTableService.getById(id);
                        if (queriedWedprProjectTable == null) {
                            wedprProjectTableService.save(wedprProjectTable);
                        } else {
                            wedprProjectTableService.updateById(wedprProjectTable);
                        }
                    }
                    // TODO send response message
                    //            transport.asyncSendMessage()
                });
    }
}
