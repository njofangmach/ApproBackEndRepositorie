package org.sid.gestapprobackend.dao;

import org.sid.gestapprobackend.entities.Unity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
@CrossOrigin("*")
public interface UnitiesRepository extends JpaRepository<Unity, Long>{

}