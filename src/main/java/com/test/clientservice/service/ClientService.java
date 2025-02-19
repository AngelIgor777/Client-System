package com.test.clientservice.service;

import com.test.clientservice.entity.Client;
import com.test.clientservice.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;

    public Client addClient(Client client) {
        return clientRepository.save(client);
    }

    @Transactional(readOnly = true)
    public Page<Client> getAllClients(Pageable pageable) {
        return clientRepository.findAll(pageable);
    }

    @Transactional(readOnly = true)
    public Client getClientById(Long id) {
        return clientRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Client with id " + id + " not found"));
    }
}
