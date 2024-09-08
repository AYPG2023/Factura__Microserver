package com.ap.Producto_micro_service.client;

import com.ap.Factura_micro_service.service.ProductoClient;
import com.ap.Producto_micro_service.dto.ProductDTO;
import com.ap.Producto_micro_service.exception.ProductoNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class ProductoClientFallbackFactory implements ProductoClient {

    @Override
    public ProductDTO getProductoById(String id) {
        // Fallback cuando el microservicio de productos no está disponible
        throw new ProductoNotFoundException("No se pudo obtener el producto con ID: " + id + " debido a un error en el servicio de productos.");
    }

    @Override
    public List<ProductDTO> getAllProductos() {
        // Fallback para obtener todos los productos
        return Collections.emptyList();  // Retorna una lista vacía como fallback
    }
}
