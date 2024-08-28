/** Copyright (C) @2014-2022 Webank */
package com.webank.wedpr.components.report;

import com.webank.wedpr.components.report.entity.WedprDataset;
import com.webank.wedpr.components.report.service.WedprDatasetService;
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

    @Autowired private WedprDatasetService wedprDatasetService;

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
        List<WedprDataset> wedprDatasetList = wedprDatasetService.list();
        log.info("do report...");
    }
}
