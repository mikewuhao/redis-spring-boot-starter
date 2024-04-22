
package com.wuhao.redis.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Copyright 2022 skyworth
 *
 * @Author: wuhao
 * @CreateTime: 2024-04-22 11:51
 * @Description: redis配置属性
 * @Version: 1.0
 **/
@ConfigurationProperties("spring.redis")
public class RedisProperties {

    @Value("${host:127.0.0.1}")
    private String host;

    @Value("${port:6379}")
    private int port;

    @Value("${database:0}")
    private int database;

    @Value("${password:}")
    private String password;

    @Value("${timeOut:3000}")
    private int timeOut;

    @Value("${maxTotal:10000}")
    private int maxTotal;

    @Value("${maxIdLe:50}")
    private int maxIdLe;

    @Value("${maxWaitMillis:5000}")
    private long maxWaitMillis;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public int getDatabase() {
        return database;
    }

    public void setDatabase(int database) {
        this.database = database;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(int timeOut) {
        this.timeOut = timeOut;
    }

    public int getMaxTotal() {
        return maxTotal;
    }

    public void setMaxTotal(int maxTotal) {
        this.maxTotal = maxTotal;
    }

    public int getMaxIdLe() {
        return maxIdLe;
    }

    public void setMaxIdLe(int maxIdLe) {
        this.maxIdLe = maxIdLe;
    }

    public long getMaxWaitMillis() {
        return maxWaitMillis;
    }

    public void setMaxWaitMillis(long maxWaitMillis) {
        this.maxWaitMillis = maxWaitMillis;
    }
}
