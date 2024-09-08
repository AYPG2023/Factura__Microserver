package com.ap.Factura_micro_service.exception;

public class FacturaNotFoundException extends RuntimeException {
    public FacturaNotFoundException(String message) {
        super(message);
    }
}
