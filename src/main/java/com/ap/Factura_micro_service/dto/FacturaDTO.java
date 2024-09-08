package com.ap.Factura_micro_service.dto;

import lombok.Data;

import java.util.List;

import com.ap.Producto_micro_service.dto.ProductDTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Data

public class FacturaDTO {

	private String clienteNombre; // Nuevo campo para el nombre del cliente

	private String id;

	@NotNull(message = "El ID del cliente no puede ser nulo")
	private String clienteId;

	@NotNull(message = "Debe contener al menos un producto")
	@Size(min = 1, message = "Debe contener al menos un producto")
	private List<ProductDTO> productos;

	private double total;

}
