/** Copyright (C) @2014-2022 Webank */
package com.webank.wedpr.report;

import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class QuartzBindJobConfig {
    @Autowired private QuartzJobFactory quartzJobFactory;
    @Autowired private Scheduler scheduler;

    @Value("${quartz-cron-report-job}")
    private String quartzCronReportJob;

    private final String jobGroup = "wedpr";

    public void scheduleBind() {
        try {
            scheduler.setJobFactory(quartzJobFactory);
            scheduleReportQuartzJob();
            scheduler.start();
        } catch (SchedulerException e) {
            log.error("scheduleBind error", e);
        }
    }

    private void scheduleReportQuartzJob() throws SchedulerException {
        JobDetail jobDetail =
                JobBuilder.newJob(ReportQuartzJob.class)
                        .withIdentity("ReportQuartzJob", jobGroup)
                        .withDescription("定时任务ReportQuartzJob")
                        .build();
        CronScheduleBuilder cronScheduleBuilder =
                CronScheduleBuilder.cronSchedule(quartzCronReportJob);
        CronTrigger cronTrigger =
                TriggerBuilder.newTrigger()
                        .withIdentity("ReportQuartzJobTrigger", jobGroup)
                        .withSchedule(cronScheduleBuilder)
                        .build();
        JobKey jobKey = jobDetail.getKey();
        if (scheduler.checkExists(jobKey)) {
            scheduler.deleteJob(jobKey);
        }
        scheduler.scheduleJob(jobDetail, cronTrigger);
    }
}
