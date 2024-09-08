package com.ap.Producto_micro_service.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.ap.Producto_micro_service.entity.ProductEntity;

public interface ProductRepository extends MongoRepository<ProductEntity, String> {
	
	
}
