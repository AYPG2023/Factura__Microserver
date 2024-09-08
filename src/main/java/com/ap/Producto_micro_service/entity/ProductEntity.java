package com.ap.Producto_micro_service.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "products")
public class ProductEntity {
    @Id
    private String id; 
    private String nombre;
    private int stock;
    private double precio;
    private String descripcion;
}


