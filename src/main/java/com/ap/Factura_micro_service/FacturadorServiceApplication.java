package com.ap.Factura_micro_service;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class FacturadorServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(FacturadorServiceApplication.class, args);
    }
}