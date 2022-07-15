package org.sid.gestapprobackend.dao;


import org.sid.gestapprobackend.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
public interface CompagnyRepository extends JpaRepository<Company, Long>{

}