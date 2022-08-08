package org.sid.gestapprobackend.dao;

import java.util.List;

import org.sid.gestapprobackend.entities.Command;
import org.sid.gestapprobackend.entities.CommandLines;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
@CrossOrigin("*")
public interface CommandlineRepository extends JpaRepository<CommandLines, Long> {
    List<CommandLines> findByCommand(Command command);
}