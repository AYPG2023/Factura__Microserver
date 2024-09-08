package com.ap.Implementacion_micro_service.service;

import com.ap.Cliente_micro_service.dto.ClienteDTO;
import com.ap.Cliente_micro_service.entity.Cliente;
import com.ap.Factura_micro_service.dto.FacturaDTO;
import com.ap.Producto_micro_service.dto.ProductDTO;
import com.ap.Producto_micro_service.entity.ProductEntity;
import com.ap.Implementacion_micro_service.client.ClienteClient;
import com.ap.Implementacion_micro_service.client.FacturaClient;
import com.ap.Implementacion_micro_service.client.ProductoClient;
import com.ap.Implementacion_micro_service.exception.IntegracionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IntegracionService {

    @Autowired
    private ClienteClient clienteClient;

    @Autowired
    private ProductoClient productoClient;

    @Autowired
    private FacturaClient facturaClient;

    /**
     * Obtiene la información de un cliente por su ID utilizando el microservicio de Cliente.
     * @param clienteId El ID del cliente a obtener.
     * @return ClienteDTO con los datos del cliente.
     */
    public ClienteDTO obtenerCliente(String clienteId) {
        try {
            ClienteDTO cliente = clienteClient.getClienteById(clienteId);
            if (cliente == null) {
                throw new IntegracionException("Cliente no encontrado con el ID: " + clienteId);
            }
            return cliente;
        } catch (Exception e) {
            throw new IntegracionException("Error al obtener el cliente con ID: " + clienteId);
        }
    }

    /**
     * Obtiene la información de un producto por su ID utilizando el microservicio de Producto.
     * @param productoId El ID del producto a obtener.
     * @return ProductDTO con los datos del producto.
     */
    public ProductEntity obtenerProducto(String productoId) {
        try {
            ProductEntity producto = productoClient.getProductById(productoId);
            if (producto == null) {
                throw new IntegracionException("Producto no encontrado con el ID: " + productoId);
            }
            return producto;
        } catch (Exception e) {
            throw new IntegracionException("Error al obtener el producto con ID: " + productoId);
        }
    }
    /**
     * Obtiene la información de una factura por su ID utilizando el microservicio de Factura.
     * @param facturaId El ID de la factura a obtener.
     * @return FacturaDTO con los datos de la factura.
     */
    public FacturaDTO obtenerFactura(String facturaId) {
        try {
            FacturaDTO factura = facturaClient.getFacturaById(facturaId);
            if (factura == null) {
                throw new IntegracionException("Factura no encontrada con el ID: " + facturaId);
            }
            return factura;
        } catch (Exception e) {
            throw new IntegracionException("Error al obtener la factura con ID: " + facturaId);
        }
    }

    /**
     * Ejemplo de método para obtener detalles completos de una factura,
     * incluyendo la información del cliente y productos.
     * @param facturaId El ID de la factura a obtener.
     * @return FacturaDTO con los detalles completos.
     */
    public FacturaDTO obtenerDetallesCompletosDeFactura(String facturaId) {
        FacturaDTO factura = obtenerFactura(facturaId);

        // Obtener detalles del cliente asociado a la factura
        ClienteDTO cliente = obtenerCliente(factura.getClienteId());
        factura.setClienteNombre(cliente.getNombre());  // Aquí se asigna el nombre del cliente

        // Obtener detalles de cada producto en la factura
        List<ProductDTO> productos = factura.getProductos();
        for (ProductDTO producto : productos) {
            ProductEntity detallesProducto = obtenerProducto(producto.getId());
            producto.setNombre(detallesProducto.getNombre());
            producto.setPrecio(detallesProducto.getPrecio());
            producto.setStock(detallesProducto.getStock());
        }

        return factura;
    }

}
