package com.ap.Factura_micro_service.service;

import com.ap.Producto_micro_service.client.ProductoClientFallbackFactory;
import com.ap.Producto_micro_service.dto.ProductDTO;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
@FeignClient(name = "producto-client", url = "${producto.service.url}", fallbackFactory = ProductoClientFallbackFactory.class)
public interface ProductoClient {
    @GetMapping("/productos/{id}")
    ProductDTO getProductoById(@PathVariable("id") String id);

	List<ProductDTO> getAllProductos();
}
