package com.test.clientservice.service;

import com.test.clientservice.entity.Contact;
import com.test.clientservice.repository.ContactRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ContactService {
    private final ContactRepository contactRepository;

    public Contact addContact(Contact contact) {
        return contactRepository.save(contact);
    }

    public Page<Contact> getContactsByClientId(Long clientId, Pageable pageable) {
        return contactRepository.findByClientId(clientId, pageable);
    }

    public Page<Contact> getContactsByClientIdAndType(Long clientId, Contact.ContactType type, Pageable pageable) {
        return contactRepository.findByClientIdAndType(clientId, type, pageable);
    }
}