package org.sid.gestapprobackend.service.implementation;

import java.util.List;
import java.util.Optional;

import org.sid.gestapprobackend.dao.CommandRepository;
import org.sid.gestapprobackend.dao.CommandlineRepository;
import org.sid.gestapprobackend.dao.UnitiesRepository;
import org.sid.gestapprobackend.entities.Command;
import org.sid.gestapprobackend.entities.CommandLines;
import org.sid.gestapprobackend.entities.Unity;
import org.sid.gestapprobackend.service.interfaces.CommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

public class CommandImplement implements CommandService {

    @Autowired
    CommandRepository commandRepository;
    @Autowired
    UnitiesRepository unitiesRepository;
    @Autowired
    CommandlineRepository commandlineRepository;

    @Override
    public Command create_command(Command command, List<CommandLines> commandLines) {
        if (commandLines.isEmpty()) {
            throw new ResourceNotFoundException(
                    "Pour effectuer une commande une faux avoir au moins une ligne de commande");
        }
        else{
            List<Command> get_command = commandRepository.findByAsknumOrNumcmd(command.getAsknum(), command.getNumcmd());
            if (get_command.isEmpty()) {
                Command new_command = commandRepository.save(command);
                for (int i = 0; i < commandLines.size(); i++) {
                    commandLines.get(i).setQuantity(commandLines.get(i).getQuantity());
                    commandLines.get(i).setUnitprice(commandLines.get(i).getUnitprice());
                    commandLines.get(i).setReduction(commandLines.get(i).getReduction());
                    commandLines.get(i).setProduct(commandLines.get(i).getProduct());
                    commandLines.get(i).setCommand(new_command);
                    commandlineRepository.save(commandLines.get(i));
                }
                throw new ResourceNotFoundException("La commande a été effectuée avec succes");
            } else {
                throw new ResourceNotFoundException("This command exist");
            }
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

    @Override
    public List<Unity> list_Unities() {
        return unitiesRepository.findAll();
    }

}
