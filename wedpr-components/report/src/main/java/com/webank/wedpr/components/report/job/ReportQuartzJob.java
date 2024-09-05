/** Copyright (C) @2014-2022 Webank */
package com.webank.wedpr.components.report.job;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.webank.wedpr.components.project.dao.ProjectDO;
import com.webank.wedpr.components.project.service.ProjectService;
import com.webank.wedpr.components.report.handler.ProjectReportMessageHandler;
import com.webank.wedpr.components.transport.Transport;
import com.webank.wedpr.core.config.WeDPRCommonConfig;
import com.webank.wedpr.core.protocol.TransportTopicEnum;
import com.webank.wedpr.core.utils.ObjectMapperFactory;
import com.webank.wedpr.core.utils.WeDPRException;
import java.time.LocalDateTime;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@DisallowConcurrentExecution
@Slf4j
public class ReportQuartzJob implements Job {
    @Autowired private ProjectService projectService;

    private Transport transport;

    @Override
    public void execute(JobExecutionContext context) {
        log.info("ReportQuartzJob run at:{}", LocalDateTime.now());
        try {
            doReport();
        } catch (Throwable e) {
            log.warn("ReportQuartzJob run error", e);
        }
    }

    @Transactional(rollbackFor = Exception.class)
    private void doReport() {
        log.info("do report...");
        try {
            String agency = WeDPRCommonConfig.getAgency();
            reportProjectInfo(agency);
        } catch (Exception e) {
            throw new RuntimeException("report error", e);
        }
    }

    private void reportProjectInfo(String agency) throws WeDPRException, JsonProcessingException {
        ProjectReportMessageHandler projectReportMessageHandler = new ProjectReportMessageHandler();
        List<ProjectDO> projectDOList = projectService.queryProjectForReport();
        byte[] payload = ObjectMapperFactory.getObjectMapper().writeValueAsBytes(projectDOList);
        transport.asyncSendMessageByAgency(
                TransportTopicEnum.PROJECT_REPORT.name(),
                agency,
                payload,
                0,
                WeDPRCommonConfig.getReportTimeout(),
                projectReportMessageHandler);
    }
}
