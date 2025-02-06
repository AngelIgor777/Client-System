package com.test.clientservice.controller;

import com.test.clientservice.entity.Contact;
import com.test.clientservice.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/contacts")
@RequiredArgsConstructor
public class ContactController {
    private final ContactService contactService;

    @PostMapping
    public Contact addContact(@RequestBody Contact contact) {
        return contactService.addContact(contact);
    }

    @GetMapping("/client/{clientId}")
    public Page<Contact> getContactsByClientId(@PathVariable Long clientId, Pageable pageable) {
        return contactService.getContactsByClientId(clientId, pageable);
    }

    @GetMapping("/client/{clientId}/type/{type}")
    public Page<Contact> getContactsByClientIdAndType(@PathVariable Long clientId, @PathVariable Contact.ContactType type, Pageable pageable) {
        return contactService.getContactsByClientIdAndType(clientId, type, pageable);
    }
}
