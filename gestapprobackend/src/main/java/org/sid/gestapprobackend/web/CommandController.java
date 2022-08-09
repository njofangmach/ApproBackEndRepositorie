package org.sid.gestapprobackend.web;

import java.util.List;

import org.sid.gestapprobackend.dao.CommandRepository;
import org.sid.gestapprobackend.entities.Command;
import org.sid.gestapprobackend.entities.CommandLines;
import org.sid.gestapprobackend.entities.CommandView;
import org.sid.gestapprobackend.service.interfaces.CommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class CommandController {
    @Autowired
    CommandService commandService;
    @Autowired
    CommandRepository commandRepository;

    @PostMapping(value = "/add_command")
    public Command add_command(@RequestBody Param param) {
        System.out.println(param.getCommand());
        System.out.println(param.getCommandLines());
        /*
         * Command command = new Command();
         * CommandLineWrapper commandLines = new CommandLineWrapper();
         * object.put("command", command);
         * object.put("commandLine", commandLines.getCommandLines());
         */
        return commandService.create_command(param.getCommand(), param.getCommandLines());
    }

    @GetMapping(value = "/CommandLinesByCommand/{id_command}")
    public List<CommandLines> CommandLinesByCommand(@PathVariable Command id_command) {
        return commandService.CommandLinesByCommand(id_command);
    }

    @GetMapping(value = "/list_command")
    public List<CommandView> list_command() {
        return commandService.list_command();
    }

    @GetMapping(value = "/findCmdWithCmdLine/{id_command}")
    public List<Command> list_command1(@PathVariable Long id_command) {
        return commandService.findCmdWithCmdLine(id_command);
    }

}

class Param {
    private List<CommandLines> commandLines;
    private Command command;

    public Param() {
    }

    public Param(List<CommandLines> commandLines, Command command) {
        this.commandLines = commandLines;
        this.command = command;
    }

    public List<CommandLines> getCommandLines() {
        return commandLines;
    }

    public void setCommandLines(List<CommandLines> commandLines) {
        this.commandLines = commandLines;
    }

    public Command getCommand() {
        return command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }
}