package com.ap.Factura_micro_service.service;

import com.ap.Cliente_micro_service.dto.ClienteDTO;
import com.ap.Cliente_micro_service.exception.ClienteNotFoundException;
import com.ap.Factura_micro_service.dto.FacturaDTO;
import com.ap.Producto_micro_service.dto.ProductDTO;
import com.ap.Producto_micro_service.exception.ProductoNotFoundException;
import com.ap.Factura_micro_service.entity.Factura;
import com.ap.Factura_micro_service.exception.FacturaNotFoundException;
import com.ap.Factura_micro_service.repository.FacturaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FacturaService {

    @Autowired
    private FacturaRepository facturaRepository;

    @Autowired
    private ModelMapper modelMapper;;

    @Autowired
    private ClienteClient clienteClient; // Feign client for Cliente microservice

    @Autowired
    private ProductoClient productoClient; // Feign client for Producto microservice

    public FacturaDTO createFactura(FacturaDTO facturaDTO) {
        // Validar y obtener información de cliente
        ClienteDTO cliente = clienteClient.getClienteById(facturaDTO.getClienteId());
        if (cliente == null) {
            throw new ClienteNotFoundException("Cliente no encontrado con el ID: " + facturaDTO.getClienteId());
        }

        // Obtener productos y calcular total
        List<ProductDTO> productos = facturaDTO.getProductos().stream()
                .map(productoDTO -> {
                    ProductDTO producto = productoClient.getProductoById(productoDTO.getId());
                    if (producto == null) {
                        throw new ProductoNotFoundException("Producto no encontrado con el ID: " + productoDTO.getId());
                    }
                    return producto;
                }).collect(Collectors.toList());

        double total = productos.stream().mapToDouble(ProductDTO::getPrecio).sum();
        facturaDTO.setTotal(total);

        // Guardar factura
        Factura factura = modelMapper.map(facturaDTO, Factura.class);
        Factura savedFactura = facturaRepository.save(factura);
        return modelMapper.map(savedFactura, FacturaDTO.class);
    }

    public FacturaDTO getFacturaById(String id) {
        Factura factura = facturaRepository.findById(id)
                .orElseThrow(() -> new FacturaNotFoundException("Factura no encontrada con el ID: " + id));
        return modelMapper.map(factura, FacturaDTO.class);
    }
}
