package com.ap.Factura_micro_service.service;

import com.ap.Cliente_micro_service.dto.ClienteDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "cliente-service", url = "http://localhost:8081")
@Service
public interface ClienteClient {

    @GetMapping("/clientes/{id}")
    ClienteDTO getClienteById(@PathVariable("id") String id);
}
