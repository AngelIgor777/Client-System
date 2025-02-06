package com.test.clientservice.validation;

import com.test.clientservice.dto.request.ContactRequestDto;
import com.test.clientservice.entity.Contact;
import org.springframework.stereotype.Component;
import java.util.regex.Pattern;

@Component
public class ContactValidator {
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
    private static final Pattern PHONE_PATTERN = Pattern.compile("^\\+?[0-9]{10,15}$");

    public void validate(ContactRequestDto contactRequest) {
        if (contactRequest.getType() == Contact.ContactType.EMAIL
                && !EMAIL_PATTERN.matcher(contactRequest.getValue()).matches()) {
            throw new IllegalArgumentException("Invalid email format");
        }
        if (contactRequest.getType() == Contact.ContactType.PHONE
                && !PHONE_PATTERN.matcher(contactRequest.getValue()).matches()) {
            throw new IllegalArgumentException("Invalid phone number format");
        }
    }
}