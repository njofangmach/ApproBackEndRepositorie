package org.sid.gestapprobackend.service.implementation;

import java.util.List;
import java.util.Optional;

import org.sid.gestapprobackend.dao.CommandRepository;
import org.sid.gestapprobackend.dao.CommandlineRepository;
import org.sid.gestapprobackend.dao.StateRepository;
import org.sid.gestapprobackend.dao.UnitiesRepository;
import org.sid.gestapprobackend.entities.Command;
import org.sid.gestapprobackend.entities.CommandLines;
import org.sid.gestapprobackend.entities.State;
import org.sid.gestapprobackend.entities.Unity;
import org.sid.gestapprobackend.service.interfaces.CommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CommandImplement implements CommandService {

    @Autowired
    CommandRepository commandRepository;
    @Autowired
    UnitiesRepository unitiesRepository;
    @Autowired
    CommandlineRepository commandlineRepository;
    @Autowired
    StateRepository stateRepository;

    @Override
    public Command create_command(Command command, List<CommandLines> commandLines) {
        if (commandLines.isEmpty() || commandLines.size() == 0) {
            throw new ResourceNotFoundException(
                    "Pour effectuer une commande une faux avoir au moins une ligne de commande");
        } else {
            Optional<Command> get_command = commandRepository.findByAsknumOrNumcmd(command.getAsknum(),
                    command.getNumcmd());
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
                for (int i = 0; i < commandLines.size(); i++) {
                    commandLines.get(i).setQuantity(commandLines.get(i).getQuantity());
                    commandLines.get(i).setUnitprice(commandLines.get(i).getUnitprice());
                    commandLines.get(i).setReduction(commandLines.get(i).getReduction());
                    commandLines.get(i).setProduct(commandLines.get(i).getProduct());
                    commandLines.get(i).setCommand(get_command.get());
                    commandlineRepository.save(commandLines.get(i));
                }
                throw new ResourceNotFoundException("La commande a été effectuée avec succes");
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

    @Override
    public List<State> list_state() {
        return stateRepository.findAll();
    }

}
