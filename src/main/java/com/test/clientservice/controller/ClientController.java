package com.test.clientservice.controller;

import com.test.clientservice.dto.request.ClientRequestDto;
import com.test.clientservice.dto.response.ClientResponseDto;
import com.test.clientservice.entity.Client;
import com.test.clientservice.mapper.ClientMapper;
import com.test.clientservice.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/clients")
@RequiredArgsConstructor
public class ClientController {
    private final ClientService clientService;


    @PostMapping
    public ClientResponseDto addClient(@RequestBody ClientRequestDto clientDto) {
        Client client = clientService.addClient(ClientMapper.INSTANCE.toEntity(clientDto));
        return ClientMapper.INSTANCE.toDto(client);
    }

    @GetMapping
    public Page<ClientResponseDto> getAllClients(Pageable pageable) {
        return clientService.getAllClients(pageable).map(ClientMapper.INSTANCE::toDto);
    }

    @GetMapping("/{id}")
    public ClientResponseDto getClientById(@PathVariable Long id) {
        return ClientMapper.INSTANCE.toDto(clientService.getClientById(id));
    }
}