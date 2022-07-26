package org.sid.gestapprobackend.dao;

import java.util.List;
import java.util.Optional;

import org.sid.gestapprobackend.entities.Location;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
@CrossOrigin("*")
public interface LocationRepository extends JpaRepository<Location, Long> {
    Optional<Location> findByName(String name);

    Optional<Location> findByCode(String code);

    List<Location> findByNameOrCode(String name, String code);

    Optional<Location> findAllByNameOrCode(String name, String code);

    java.util.List<Location> findAllByName(String name);
}
