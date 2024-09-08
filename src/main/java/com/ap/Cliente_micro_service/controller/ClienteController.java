package com.ap.Cliente_micro_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ap.Cliente_micro_service.dto.ClienteDTO;
import com.ap.Cliente_micro_service.service.ClienteService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> getClienteById(@PathVariable String id) {
        ClienteDTO cliente = clienteService.getClienteById(id);
        return ResponseEntity.ok(cliente);
    }

    @PostMapping
    public ResponseEntity<ClienteDTO> createCliente(@RequestBody @Valid ClienteDTO clienteDTO) {
        ClienteDTO cliente = clienteService.createCliente(clienteDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
    }


    @PutMapping("/{id}")
    public ResponseEntity<ClienteDTO> updateCliente(@PathVariable String id, @RequestBody ClienteDTO clienteDTO) {
        ClienteDTO cliente = clienteService.updateCliente(id, clienteDTO);
        return ResponseEntity.ok(cliente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCliente(@PathVariable String id) {
        clienteService.deleteCliente(id);
        return ResponseEntity.noContent().build();
    }
}
