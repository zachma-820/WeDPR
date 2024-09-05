/** Copyright (C) @2014-2022 Webank */
package com.webank.wedpr.components.report.job;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.webank.wedpr.components.project.dao.JobDO;
import com.webank.wedpr.components.project.dao.ProjectDO;
import com.webank.wedpr.components.project.dao.ProjectMapper;
import com.webank.wedpr.components.report.handler.JobReportMessageHandler;
import com.webank.wedpr.components.report.handler.ProjectReportMessageHandler;
import com.webank.wedpr.components.transport.Transport;
import com.webank.wedpr.core.config.WeDPRCommonConfig;
import com.webank.wedpr.core.protocol.TransportTopicEnum;
import com.webank.wedpr.core.utils.ObjectMapperFactory;
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
    @Autowired private ProjectMapper projectMapper;

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
            reportJobInfo(agency);
        } catch (Exception e) {
            log.warn("report error", e);
        }
    }

    private void reportJobInfo(String agency) throws JsonProcessingException {
        JobReportMessageHandler jobReportMessageHandler =
                new JobReportMessageHandler(projectMapper);
        JobDO jobDO = new JobDO();
        jobDO.setReportStatus(0);
        List<JobDO> jobDOList = projectMapper.queryJobs(false, jobDO, null);
        byte[] payload = ObjectMapperFactory.getObjectMapper().writeValueAsBytes(jobDOList);
        transport.asyncSendMessageByAgency(
                TransportTopicEnum.JOB_REPORT.name(),
                agency,
                payload,
                0,
                WeDPRCommonConfig.getReportTimeout(),
                jobReportMessageHandler);
    }

    private void reportProjectInfo(String agency) throws JsonProcessingException {
        ProjectReportMessageHandler projectReportMessageHandler =
                new ProjectReportMessageHandler(projectMapper);
        ProjectDO projectDO = new ProjectDO();
        projectDO.setReportStatus(0);
        List<ProjectDO> projectDOList = projectMapper.queryProject(false, projectDO);
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
