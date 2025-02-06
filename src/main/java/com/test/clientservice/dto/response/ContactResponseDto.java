package com.test.clientservice.dto.response;


import com.test.clientservice.entity.Contact;
import lombok.Data;

@Data
public class ContactResponseDto {
    private Long id;
    private Contact.ContactType type;
    private String value;
}