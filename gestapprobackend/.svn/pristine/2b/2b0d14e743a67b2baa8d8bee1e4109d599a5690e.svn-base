package org.sid.gestapprobackend.dao;

import java.util.List;
import java.util.Optional;

import org.sid.gestapprobackend.entities.Coastcenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource
public interface CoastcenterRepository extends JpaRepository<Coastcenter, Long> {
    Optional<Coastcenter> findByName(String name);

    List<Coastcenter> findByNameOrCode(String name, String code);

    Optional<Coastcenter> findAllByNameOrCode(String name, String code);

    java.util.List<Coastcenter> findAllByName(String name);
}