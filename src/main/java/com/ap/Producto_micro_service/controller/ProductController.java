package com.ap.Producto_micro_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.ap.Producto_micro_service.entity.ProductEntity;
import com.ap.Producto_micro_service.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    // Crear un nuevo producto
    @PostMapping
    public ProductEntity createProduct(@RequestBody ProductEntity product) {
        return productService.createProduct(product);
    }

    // Obtener todos los productos
    @GetMapping
    public List<ProductEntity> getAllProducts() {
        return productService.getAllProducts();
    }

    // Obtener un producto por ID
    @GetMapping("/{id}")
    public ProductEntity getProductById(@PathVariable String id) {
        return productService.getProductById(id);
    }

    // Actualizar un producto
    @PutMapping("/{id}")
    public ProductEntity updateProduct(@PathVariable String id, @RequestBody ProductEntity productDetails) {
        return productService.updateProduct(id, productDetails);
    }

    // Eliminar un producto
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable String id) {
        productService.deleteProduct(id);
    }
}
