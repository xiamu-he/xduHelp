package com.qinghuo.xduHelp.model.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author qzx
 * @create 2021-11-27 9:30
 * @function
 */

@Data
@ConfigurationProperties(prefix = "thread.pool")
public class TaskThreadPoolConfig {
    /**
     * 核心线程数
     */
    private int corePoolSize;

    /**
     * 最大线程数
     */
    private int maxPoolSize;

    /**
     * 线程空闲时间
     */
    private int keepAliveSeconds;

    /**
     * 任务队列容量（阻塞队列）
     */
    private int queueCapacity;
}
