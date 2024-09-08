package com.ap.Implementacion_micro_service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.ap.Cliente_micro_service.dto.ClienteDTO;
import com.ap.Cliente_micro_service.entity.Cliente;

@FeignClient(name = "cliente-service", url = "http://localhost:8081/api/clients")
public interface ClienteClient {
    @GetMapping("/{id}")
    ClienteDTO getClienteById(@PathVariable("id") String id);
}
