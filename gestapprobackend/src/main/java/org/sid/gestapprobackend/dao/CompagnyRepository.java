package org.sid.gestapprobackend.dao;

import java.util.List;
import java.util.Optional;

import org.sid.gestapprobackend.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
@CrossOrigin("*")
public interface CompagnyRepository extends JpaRepository<Company, Long> {
    Optional<Company> findByName(String name);

    List<Company> findByCode(String code);

    List<Company> findByNameOrCode(String name, String code);

    Optional<Company> findAllByNameOrCode(String name, String code);

    List<Company> findAllByName(String name);
}