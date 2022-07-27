package org.sid.gestapprobackend.service.interfaces;

import java.util.List;
import java.util.Optional;

import org.sid.gestapprobackend.entities.CommandLines;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

@Component
@CrossOrigin("*")
@Service
public interface CommandlineService {
    CommandLines create_commandline(CommandLines commandline);

    Optional<CommandLines> update_commandline(Integer id_commandline);

    void cancel_commandline(Integer id_commandline);

    List<CommandLines> list_commandline();

}
