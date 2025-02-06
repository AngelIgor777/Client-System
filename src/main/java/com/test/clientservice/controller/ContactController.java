package com.test.clientservice.controller;

import com.test.clientservice.dto.request.ContactRequestDto;
import com.test.clientservice.dto.response.ContactResponseDto;
import com.test.clientservice.entity.Contact;
import com.test.clientservice.mapper.ContactMapper;
import com.test.clientservice.service.ClientContactService;
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
    private final ClientContactService clientContactService;

    @PostMapping
    public ContactResponseDto addContact(@RequestBody ContactRequestDto contactDto) {
        return ContactMapper.INSTANCE.toDto(clientContactService.addContact(contactDto));
    }

    @GetMapping("/client/{clientId}")
    public Page<ContactResponseDto> getContactsByClientId(@PathVariable Long clientId, Pageable pageable) {
        return contactService.getContactsByClientId(clientId, pageable).map(ContactMapper.INSTANCE::toDto);
    }

    @GetMapping("/client/{clientId}/type/{type}")
    public Page<ContactResponseDto> getContactsByClientIdAndType(@PathVariable Long clientId, @PathVariable Contact.ContactType type, Pageable pageable) {
        return contactService.getContactsByClientIdAndType(clientId, type, pageable).map(ContactMapper.INSTANCE::toDto);
    }
}
