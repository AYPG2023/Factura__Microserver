package com.ap.Producto_micro_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import com.ap.Producto_micro_service.entity.ProductEntity;
import com.ap.Producto_micro_service.repository.ProductRepository;
import com.ap.Producto_micro_service.exception.CustomException;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    // Crear un producto (Create)
    public ProductEntity createProduct(ProductEntity product) {
        return productRepository.save(product);
    }

    // Obtener todos los productos (Read)
    public List<ProductEntity> getAllProducts() {
        return productRepository.findAll();
    }

    // Obtener un producto por ID (Read)
    public ProductEntity getProductById(String id) {
        return productRepository.findById(id)
            .orElseThrow(() -> new CustomException("Producto no encontrado con el ID: " + id));
    }

    // Actualizar un producto (Update)
    public ProductEntity updateProduct(String id, ProductEntity productDetails) {
        ProductEntity product = productRepository.findById(id)
            .orElseThrow(() -> new CustomException("Producto no encontrado con el ID: " + id));

        product.setNombre(productDetails.getNombre());
        product.setStock(productDetails.getStock());
        product.setPrecio(productDetails.getPrecio());
        product.setDescripcion(productDetails.getDescripcion());

        return productRepository.save(product);
    }

    // Eliminar un producto (Delete)
    public void deleteProduct(String id) {
        ProductEntity product = productRepository.findById(id)
            .orElseThrow(() -> new CustomException("Producto no encontrado con el ID: " + id));

        productRepository.delete(product);
    }
}

