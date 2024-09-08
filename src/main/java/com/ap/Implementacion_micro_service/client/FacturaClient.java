package com.ap.Implementacion_micro_service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.ap.Factura_micro_service.dto.FacturaDTO;

@FeignClient(name = "factura-service", url = "http://localhost:8083/facturas")
public interface FacturaClient {

    @GetMapping("/{id}")
    FacturaDTO getFacturaById(@PathVariable("id") String id);
}
