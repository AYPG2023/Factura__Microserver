package com.ap.Cliente_micro_service.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

@Document(collection = "clientes")
@Data
public class Cliente {
    @Id
    private String id;
    private String nombre;
    private String email;
    private String telefono;
    private String direccion;


}

