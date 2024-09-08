package com.ap.Implementacion_micro_service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.ap.Producto_micro_service.dto.ProductDTO;
import com.ap.Producto_micro_service.entity.ProductEntity;

@FeignClient(name = "producto-service", url = "http://localhost:8082/api/products")
public interface ProductoClient {
    @GetMapping("/{id}")
    ProductEntity getProductById(@PathVariable String id);
}