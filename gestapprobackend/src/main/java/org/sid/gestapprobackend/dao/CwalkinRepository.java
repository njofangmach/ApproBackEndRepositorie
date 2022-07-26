package org.sid.gestapprobackend.dao;

import org.sid.gestapprobackend.entities.Walkin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CwalkinRepository extends JpaRepository<Walkin, Long>{

}