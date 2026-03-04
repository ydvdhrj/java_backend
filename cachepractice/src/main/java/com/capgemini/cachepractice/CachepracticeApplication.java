package com.capgemini.cachepractice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableCaching
public class CachepracticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(CachepracticeApplication.class, args);
	}
	
	@Bean
	public CacheManager getCacheManager() {
		return new ConcurrentMapCacheManager();
	}

}
