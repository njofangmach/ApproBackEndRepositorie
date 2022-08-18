package org.sid.gestapprobackend.dao;

import java.util.List;
import java.util.Optional;

import org.sid.gestapprobackend.entities.Site;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
@CrossOrigin("*")
public interface SiteRepository extends JpaRepository<Site, Long> {
    Optional<Site> findByName(String name);

    Optional<Site> findByCode(String code);

    List<Site> findByNameOrCode(String name, String code);

    Optional<Site> findAllByNameOrCode(String name, String code);

    java.util.List<Site> findAllByName(String name);
}