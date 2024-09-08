package com.ap.Producto_micro_service.dto;

import lombok.Data;

@Data
public class ProductDTO {
    private String id; // Agregado para identificar el producto
    private String nombre;
    private int stock;
    private double precio;
    private String descripcion;
}
