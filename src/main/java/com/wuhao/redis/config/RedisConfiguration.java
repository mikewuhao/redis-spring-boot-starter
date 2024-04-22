package com.wuhao.redis.config;

import com.wuhao.redis.utils.RedisUtils;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Copyright 2022 skyworth
 *
 * @Author: wuhao
 * @CreateTime: 2024-04-22 11:51
 * @Description: redis配置类
 * @Version: 1.0
 **/
@Configuration
@EnableConfigurationProperties(RedisProperties.class)
public class RedisConfiguration {

    private final RedisProperties properties;

    public RedisConfiguration(RedisProperties redisProperties) {
        this.properties = redisProperties;
    }

    @Bean(name = "redisHandler")
    @ConditionalOnMissingBean(RedisUtils.class)
    public RedisUtils redisUtils() {
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        //最大连接数
        poolConfig.setMaxTotal(properties.getMaxTotal());
        //最多空闲数
        poolConfig.setMaxIdle(properties.getMaxIdLe());
        //当池中没有连接时，最多等待5秒
        poolConfig.setMaxWaitMillis(properties.getMaxWaitMillis());
        String pw = StringUtils.isEmpty(properties.getPassword()) ? null : properties.getPassword();
        return new RedisUtils(poolConfig, properties.getHost(), properties.getPort(), properties.getTimeOut(), pw, properties.getDatabase());
    }
}
