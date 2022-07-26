package org.sid.gestapprobackend.dao;

import java.util.List;
import java.util.Optional;

import org.sid.gestapprobackend.entities.Site;
import org.sid.gestapprobackend.entities.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface WarehouseRepository extends JpaRepository<Warehouse, Long> {
    Optional<Warehouse> findByName(String name);

    List<Warehouse> findByNameOrCode(String name, String code);

    Optional<Warehouse> findAllByNameOrCode(String name, String code);

    java.util.List<Warehouse> findAllByName(String name);

    List<Warehouse> findByNameAndCodeAndSite(String name, String code, Site site);

    java.util.List<Warehouse> findAllBySite(Site site);
}