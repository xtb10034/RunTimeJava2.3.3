package com.xtb.restful.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;

@Configuration
@ConfigurationProperties(prefix="batch.task.executor")
public class TaskExecutorConfiguration {

    @Value("${batch.task.executor.maxSize:10}")
    private int maxSize;

    @Value("${batch.task.executor.threadNamePrefix:SISBatch}")
    private String threadNamePrefix;

    @Bean(name="SISBatchExecutor")
    public TaskExecutor batchTaskExecutor() {
        SimpleAsyncTaskExecutor asyncTaskExecutor = new SimpleAsyncTaskExecutor();
        asyncTaskExecutor.setConcurrencyLimit(maxSize);
        asyncTaskExecutor.setThreadNamePrefix(threadNamePrefix);
        return asyncTaskExecutor;
    }

}
