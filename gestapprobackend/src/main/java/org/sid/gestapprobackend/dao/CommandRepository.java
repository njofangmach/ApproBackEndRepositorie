package org.sid.gestapprobackend.dao;

import java.util.List;
import java.util.Optional;

import org.sid.gestapprobackend.entities.Command;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
@CrossOrigin("*")
public interface CommandRepository extends JpaRepository<Command, Long> {

    Optional<Command> findByAsknumOrNumcmd(String asknum, String numcmd);

   // @Query(value = "SELECT c.asknum, c.askdate, c.numcmd, c.datecmd, c.delevrytime,c.reduction, c.company, c.provider, c.state, c.warehouse FROM Command c")
    //List<Object[]> findCommandWithQuery();

    //List<Command> findByCommandLines();

}