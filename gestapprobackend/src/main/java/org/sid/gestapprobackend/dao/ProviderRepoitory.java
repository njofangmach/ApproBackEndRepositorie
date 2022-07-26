package org.sid.gestapprobackend.dao;

import java.util.List;
import java.util.Optional;

import org.sid.gestapprobackend.entities.Provider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ProviderRepoitory extends JpaRepository<Provider, Long>{
    Optional<Provider> findByName(String name);

    List<Provider> findByNameOrCode(String name, String code);

    Optional<Provider> findAllByNameOrCode(String name, String code);

    java.util.List<Provider>findAllByName(String name);
}