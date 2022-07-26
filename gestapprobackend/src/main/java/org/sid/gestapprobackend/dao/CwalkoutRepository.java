package org.sid.gestapprobackend.dao;

import org.sid.gestapprobackend.entities.Walkout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CwalkoutRepository extends JpaRepository<Walkout, Long>{

}
