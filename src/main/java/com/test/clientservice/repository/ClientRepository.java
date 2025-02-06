package com.test.clientservice.repository;


import com.test.clientservice.entity.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Long> {
    @EntityGraph(attributePaths = "contacts")
    Page<Client> findAll(Pageable pageable);

    @EntityGraph(attributePaths = {"contacts"})
    Optional<Client> findById(Long id);
}

