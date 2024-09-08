package com.ap.Factura_micro_service.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.ap.Producto_micro_service.entity.ProductEntity;

import java.util.List;

@Document(collection = "facturas")
public class Factura {
    @Id
    private String id;
    private String clienteId;
    private List<ProductEntity> productos; // Entidad para productos
    private double total;

    
}
