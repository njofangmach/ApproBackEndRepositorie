package org.sid.gestapprobackend.service.implementation;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.sid.gestapprobackend.dao.CommandRepository;
import org.sid.gestapprobackend.dao.CommandlineRepository;
import org.sid.gestapprobackend.dao.StateRepository;
import org.sid.gestapprobackend.dao.UnitiesRepository;
import org.sid.gestapprobackend.entities.Command;
import org.sid.gestapprobackend.entities.CommandLines;
import org.sid.gestapprobackend.entities.CommandView;
import org.sid.gestapprobackend.entities.State;
import org.sid.gestapprobackend.entities.Unity;
import org.sid.gestapprobackend.service.interfaces.CommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;

@Service
@CrossOrigin("*")
public class CommandImplement implements CommandService {

    @PersistenceContext
    EntityManager em;

    @Autowired
    CommandRepository commandRepository;
    @Autowired
    UnitiesRepository unitiesRepository;
    @Autowired
    CommandlineRepository commandlineRepository;
    @Autowired
    StateRepository stateRepository;

    @Override
    @Transactional
    public Command create_command(Command command, List<CommandLines> commandLines) {
        if (command.getOid() == null) {
            if (commandLines.isEmpty() || commandLines == null) {
                throw new ResourceNotFoundException(
                        "Pour effectuer une commande une faux avoir au moins une ligne de commande");
            } else {
                // Optional<Command> get_command =
                // commandRepository.findByAsknumOrNumcmd(command.getAsknum(),command.getNumcmd());
                Command new_command = commandRepository.save(command);
                for (int i = 0; i < commandLines.size(); i++) {
                    commandLines.get(i).setQuantity(commandLines.get(i).getQuantity());
                    commandLines.get(i).setUnitprice(commandLines.get(i).getUnitprice());
                    commandLines.get(i).setReduction(commandLines.get(i).getReduction());
                    commandLines.get(i).setProduct(commandLines.get(i).getProduct());
                    commandLines.get(i).setCommand(new_command);
                    commandlineRepository.save(commandLines.get(i));
                }
                return new_command;
            }
        } else {
            Optional<Command> last_command = commandRepository.findById(command.getOid());
            if (last_command.isPresent()) {
                last_command.get().setDatecmd(command.getDatecmd());
                last_command.get().setNumcmd(command.getNumcmd());
                last_command.get().setCoastcenter(command.getCoastcenter());
                last_command.get().setProvider(command.getProvider());
                commandRepository.save(last_command.get());

                for (int j = 0; j < commandLines.size(); j++) {
                    Optional<CommandLines> get_commandLine = commandlineRepository
                            .findById(commandLines.get(j).getOid());
                    if (get_commandLine.isPresent()) {
                        get_commandLine.get().setQuantity(commandLines.get(j).getQuantity());
                        get_commandLine.get().setUnity(commandLines.get(j).getUnity());
                        get_commandLine.get().setUnitprice(commandLines.get(j).getUnitprice());
                        get_commandLine.get().setReduction(commandLines.get(j).getReduction());
                        commandlineRepository.save(get_commandLine.get());
                    }
                }

            }

        }
        return (command);
    }
    @Override
    public List<CommandLines> CommandLinesByCommand(Command command) {
        return commandlineRepository.findByCommand(command);
    }

    @Override
    public List<Unity> list_Unities() {
        return unitiesRepository.findAll();
    }

    @Override
    public List<State> list_state() {
        return stateRepository.findAll();
    }

    @Override
    public List<CommandView> list_command() {
        return commandRepository.findAllCommandBy();
    }

    @Override
    public List<Command> findCmdWithCmdLine(Long id_command) {
        return commandRepository.findByOid(id_command);
    }

    @Override
    public Optional<Command> update_command(Command command) {
        // TODO Auto-generated method stub
        return Optional.empty();
    }

    @Override
    public void cancel_command(Long id_command) {
        // TODO Auto-generated method stub

    }


}
