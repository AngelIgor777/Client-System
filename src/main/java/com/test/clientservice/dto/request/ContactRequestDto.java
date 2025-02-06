package com.test.clientservice.dto.request;
import com.test.clientservice.entity.Contact;
import lombok.Data;

@Data
public class ContactRequestDto {
    private Contact.ContactType type;
    private String value;
    private Long clientId;
}
