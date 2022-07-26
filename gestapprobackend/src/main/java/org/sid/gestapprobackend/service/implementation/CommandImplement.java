package org.sid.gestapprobackend.service.implementation;

import java.util.List;
import java.util.Optional;

import org.sid.gestapprobackend.dao.CommandRepository;
import org.sid.gestapprobackend.entities.Command;
import org.sid.gestapprobackend.service.interfaces.CommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

public class CommandImplement implements CommandService{

    @Autowired
    CommandRepository commandRepository;

    @Override
    public Command create_command(Command command) {
        List<Command> get_command = commandRepository.findByAsknumOrNumcmd(command.getAsknum(), command.getNumcmd());
        if (get_command.isEmpty()) {
            return commandRepository.save(command);
        } else {
            throw new ResourceNotFoundException("This command exist");
        }
    }

    @Override
    public Optional<Command> update_command(Long id_command) {
        // TODO Auto-generated method stub
        return Optional.empty();
    }

    @Override
    public void cancel_command(Long id_command) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public List<Command> list_command() {
        // TODO Auto-generated method stub
        return null;
    }
    
}
