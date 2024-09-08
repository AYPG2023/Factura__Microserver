package com.ap.Factura_micro_service.controller;

import com.ap.Factura_micro_service.dto.FacturaDTO;
import com.ap.Factura_micro_service.service.FacturaService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/facturas")
public class FacturaController {

    @Autowired
    private FacturaService facturaService;

    @PostMapping
    public ResponseEntity<FacturaDTO> createFactura(@Valid @RequestBody FacturaDTO facturaDTO) {
        FacturaDTO factura = facturaService.createFactura(facturaDTO);
        return ResponseEntity.ok(factura);
    }


    @GetMapping("/{id}")
    public ResponseEntity<FacturaDTO> getFacturaById(@PathVariable String id) {
        FacturaDTO factura = facturaService.getFacturaById(id);
        return ResponseEntity.ok(factura);
    }
}
