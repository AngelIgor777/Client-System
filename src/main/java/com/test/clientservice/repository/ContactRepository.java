package com.test.clientservice.repository;


import com.test.clientservice.entity.Contact;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {
    Page<Contact> findByClientId(Long clientId, Pageable pageable);

    Page<Contact> findByClientIdAndType(Long clientId, Contact.ContactType type, Pageable pageable);
}

