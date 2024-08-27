/** Copyright (C) @2014-2022 Webank */
package com.webank.wedpr.report;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;

@Configuration
public class ApplicationListenerConfig implements ApplicationListener<ContextRefreshedEvent> {

    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired private QuartzBindJobConfig quartzBindJobConfig;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        quartzBindJobConfig.scheduleBind();
    }
}
