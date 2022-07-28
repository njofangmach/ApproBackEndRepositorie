package org.sid.gestapprobackend.dao;


import java.util.Optional;

import org.sid.gestapprobackend.entities.Command;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;



@RepositoryRestResource
@CrossOrigin("*")
public interface CommandRepository extends JpaRepository<Command, Long>{

    Optional<Command> findByAsknumOrNumcmd(String asknum, String numcmd);
}