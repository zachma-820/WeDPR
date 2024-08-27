/** Copyright (C) @2014-2022 Webank */
package com.webank.wedpr.report;

import java.time.LocalDateTime;
import lombok.extern.slf4j.Slf4j;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.springframework.transaction.annotation.Transactional;

@DisallowConcurrentExecution
@Slf4j
public class ReportQuartzJob implements Job {

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
    }
}
