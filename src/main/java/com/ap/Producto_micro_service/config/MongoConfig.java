package com.ap.Producto_micro_service.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "com.ap.Producto_micro_service.repository")
public class MongoConfig {
    
	
}