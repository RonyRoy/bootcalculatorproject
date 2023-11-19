package com.example.bootcalculatorproject.config;

import java.time.Duration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;

@Configuration
public class CacheConfig {
	/*
	 * @Bean public RedisCacheConfiguration cacheConfiguration() { return
	 * RedisCacheConfiguration.defaultCacheConfig() .entryTtl(Duration.ofMinutes(1))
	 * .disableCachingNullValues()
	 * .serializeValuesWith(SerializationPair.fromSerializer( new
	 * GenericJackson2JsonRedisSerializer())); }
	 * 
	 * @Bean public RedisCacheManagerBuilderCustomizer
	 * redisCacheManagerBuilderCustomizer() { return (builder) -> builder
	 * .withCacheConfiguration("requestResponseEntity",
	 * RedisCacheConfiguration.defaultCacheConfig()
	 * .entryTtl(Duration.ofMinutes(0))); }
	 */
	
	@Primary
	  @Bean
	  public RedisCacheManager cacheManager(final RedisConnectionFactory connectionFactory) {
	    final RedisCacheWriter redisCacheWriter = RedisCacheWriter.lockingRedisCacheWriter(connectionFactory);
	    final RedisCacheConfiguration cacheConfiguration = RedisCacheConfiguration.defaultCacheConfig();
	    final RedisCacheManager redisCacheManager = new RedisCacheManager(redisCacheWriter, cacheConfiguration);
	    return redisCacheManager;
	  }

	  @Bean(name = "requestResponseEntityManager")
	  public RedisCacheManager requestResponseEntityManager(final RedisConnectionFactory connectionFactory) {
	    final RedisCacheWriter redisCacheWriter = RedisCacheWriter.lockingRedisCacheWriter(connectionFactory);
	    RedisCacheConfiguration cacheConfiguration = RedisCacheConfiguration.defaultCacheConfig();
	    cacheConfiguration = cacheConfiguration.entryTtl(Duration.ofSeconds(60));
	    final RedisCacheManager redisCacheManager = new RedisCacheManager(redisCacheWriter, cacheConfiguration);
	    return redisCacheManager;
	  }

}
