package com.test.clientservice.service;

import com.test.clientservice.dto.request.ContactRequestDto;
import com.test.clientservice.entity.Client;
import com.test.clientservice.entity.Contact;
import com.test.clientservice.repository.ClientRepository;
import com.test.clientservice.repository.ContactRepository;
import com.test.clientservice.validation.ContactValidator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientContactService {

    private final ContactRepository contactRepository;
    private final ClientRepository clientRepository;
    private final ContactValidator contactValidator;

    public ClientContactService(ContactRepository contactRepository, ClientRepository clientRepository, ContactValidator contactValidator) {
        this.contactRepository = contactRepository;
        this.clientRepository = clientRepository;
        this.contactValidator = contactValidator;
    }

    @Transactional
    public Contact addContact(ContactRequestDto contactRequestDto) {
        contactValidator.validate(contactRequestDto);

        Client client = clientRepository.findById(contactRequestDto.getClientId())
                .orElseThrow(() -> new IllegalArgumentException("Client not found with id: " + contactRequestDto.getClientId()));

        Contact contact = new Contact();
        contact.setType(contactRequestDto.getType());
        contact.setValue(contactRequestDto.getValue());
        contact.setClient(client);

        return contactRepository.save(contact);
    }
}
