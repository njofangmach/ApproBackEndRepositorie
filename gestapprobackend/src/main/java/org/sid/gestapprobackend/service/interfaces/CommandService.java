package org.sid.gestapprobackend.service.interfaces;

import java.util.List;
import java.util.Optional;

import org.sid.gestapprobackend.entities.Command;
import org.sid.gestapprobackend.entities.CommandLines;
import org.sid.gestapprobackend.entities.CommandView;
import org.sid.gestapprobackend.entities.State;
import org.sid.gestapprobackend.entities.Unity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

@Service
@Component
@CrossOrigin("*")
public interface CommandService {
    Command create_command(Command command, List<CommandLines> commandLines);

    Optional<Command> update_command(Command command);

    void cancel_command(Long id_command);

    List<CommandLines> CommandLinesByCommand(Command command);

    List<CommandView> list_command();

    List<Command>findCmdWithCmdLine(Long id_command);

    List<Unity> list_Unities();

    List<State> list_state();


}
