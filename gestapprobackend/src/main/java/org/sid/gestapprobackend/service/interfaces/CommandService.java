package org.sid.gestapprobackend.service.interfaces;

import java.util.List;
import java.util.Optional;

import org.sid.gestapprobackend.entities.Command;
import org.springframework.stereotype.Component;

@Component
public interface CommandService {
    Command create_command(Command command);

    Optional<Command> update_command(Long id_command);

    void cancel_command(Long id_command);

    List<Command> list_command();


}
