package com.ap.Producto_micro_service.exception;

public class CustomException extends RuntimeException {
    public CustomException(String message) {
        super(message);
    }
}
