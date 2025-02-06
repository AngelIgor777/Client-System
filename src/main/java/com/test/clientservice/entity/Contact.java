package com.test.clientservice.entity;


import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name = "contacts", schema = "clients_system")
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private ContactType type;

    private String value;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;


    public enum ContactType {
        PHONE, EMAIL
    }
}

