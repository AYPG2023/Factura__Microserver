package com.ap.Cliente_micro_service.service;

import com.ap.Cliente_micro_service.dto.ClienteDTO;
import com.ap.Cliente_micro_service.entity.Cliente;
import com.ap.Cliente_micro_service.exception.ClienteNotFoundException;
import com.ap.Cliente_micro_service.repository.ClienteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ModelMapper modelMapper;

    public ClienteDTO getClienteById(String id) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new ClienteNotFoundException("Cliente no encontrado con el ID: " + id));
        return modelMapper.map(cliente, ClienteDTO.class);
    }

    public ClienteDTO createCliente(ClienteDTO clienteDTO) {
        Cliente cliente = modelMapper.map(clienteDTO, Cliente.class);
        Cliente savedCliente = clienteRepository.save(cliente);
        return modelMapper.map(savedCliente, ClienteDTO.class);
    }

    public ClienteDTO updateCliente(String id, ClienteDTO clienteDTO) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new ClienteNotFoundException("Cliente no encontrado con el ID: " + id));
        modelMapper.map(clienteDTO, cliente);
        Cliente updatedCliente = clienteRepository.save(cliente);
        return modelMapper.map(updatedCliente, ClienteDTO.class);
    }

    public void deleteCliente(String id) {
        if (!clienteRepository.existsById(id)) {
            throw new ClienteNotFoundException("Cliente no encontrado con el ID: " + id);
        }
        clienteRepository.deleteById(id);
    }
}
