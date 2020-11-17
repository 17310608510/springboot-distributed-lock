package com.example.demo.redis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.integration.redis.util.RedisLockRegistry;

/** 
 * @author 作者 zuoruibo: 
 * @date 创建时间：2020年11月17日 下午3:17:46 
 * @version 1.0 
 * @parameter 
 * @since 
 * @return 
 */
@Configuration
public class RedisLockConfiguration {
	@Bean
	public RedisLockRegistry redisLockRegistry(RedisConnectionFactory redisConnectionFactory) {
		return new RedisLockRegistry(redisConnectionFactory, "spring-boot");
	}
}
