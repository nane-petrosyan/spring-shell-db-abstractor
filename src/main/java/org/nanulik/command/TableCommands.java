package org.nanulik.command;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

/**
 * @author Nane Petrosyan
 * 13.07.24
 */

@ShellComponent
public class TableCommands {

    @ShellMethod(key = "create table")
    public String hello(String name) {
        return "Creating table, " + name;
    }
}
