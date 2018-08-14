package com.eshequ.msa.crm.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.session.data.redis.config.ConfigureRedisAction;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.web.http.CookieHttpSessionStrategy;
import org.springframework.session.web.http.HttpSessionStrategy;

@Configuration
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 360000)
public class HttpSessionConfig {

    @Value(value = "${spring.redis.host}")
    private String host;
    @Value(value = "${spring.redis.port}")
    private Integer port;
    @Value(value = "${spring.redis.database}")
    private Integer database;
    
    @Bean
    public JedisConnectionFactory connectionFactory() {
    	JedisConnectionFactory factory = new JedisConnectionFactory(redisStandaloneConfiguration());
    	return factory;
    }
    
    @Bean
    public RedisStandaloneConfiguration redisStandaloneConfiguration() {
    	
        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
        redisStandaloneConfiguration.setHostName(host);
        redisStandaloneConfiguration.setPort(port);
        redisStandaloneConfiguration.setDatabase(database);
        return redisStandaloneConfiguration;
    }
    
    @Bean
    public HttpSessionStrategy httpSessionStrategy() {
    	CookieHttpSessionStrategy c =  new CookieHttpSessionStrategy();
    	return c;
    }
    
    /**
     * If you are using @EnableRedisHttpSession the SessionMessageListener and enabling the necessary Redis Keyspace events is done automatically. 
     * However, in a secured Redis enviornment the config command is disabled. 
     * This means that Spring Session cannot configure Redis Keyspace events for you. 
     * To disable the automatic configuration add ConfigureRedisAction.NO_OP as a bean.
     * @return
     */
    @Bean
    public static ConfigureRedisAction configureRedisAction() {
    	return ConfigureRedisAction.NO_OP;
    }
    
}
