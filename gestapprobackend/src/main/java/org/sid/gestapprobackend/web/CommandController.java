package org.sid.gestapprobackend.web;

import java.util.List;

import org.sid.gestapprobackend.entities.Command;
import org.sid.gestapprobackend.entities.CommandLines;
import org.sid.gestapprobackend.entities.State;
import org.sid.gestapprobackend.entities.Unity;
import org.sid.gestapprobackend.service.interfaces.CommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class CommandController {
    @Autowired
    CommandService commandService;

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

    @GetMapping(value = "/list_state")
    public List<State> list_state() {
        return commandService.list_state();
    }

    @GetMapping(value = "/list_unity")
    public List<Unity> list_unity() {
        return commandService.list_Unities();
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