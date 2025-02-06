package com.test.clientservice.entity;


import javax.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity
@Table(name = "clients",schema = "clients_system")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Contact> contacts;
}