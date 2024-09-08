package com.ap.Factura_micro_service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ap.Cliente_micro_service.exception.ClienteNotFoundException;
import com.ap.Producto_micro_service.exception.ProductoNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(FacturaNotFoundException.class)
    public ResponseEntity<String> handleFacturaNotFoundException(FacturaNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(ClienteNotFoundException.class)
    public ResponseEntity<String> handleClienteNotFoundException(ClienteNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ProductoNotFoundException.class)
    public ResponseEntity<String> handleProductoNotFoundException(ProductoNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

}
