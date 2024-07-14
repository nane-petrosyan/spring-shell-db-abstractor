package org.nanulik.command;

import org.nanulik.model.DatabaseType;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

/**
 * @author Nane Petrosyan
 * 13.07.24
 */

@ShellComponent
public class DatabaseCommands {

    @ShellMethod(
            key = "add database",
            value = "Attaches a database to the engine."
    )
    public void addDatabase(
            @ShellOption(value = {"-a", "--alias"}) String alias,
            @ShellOption(value = {"-u", "--url"}) String url,
            @ShellOption(value = {"-t", "--type" }) DatabaseType type
    ) {
        // create a meta dir
        // write to file
    }

    @ShellMethod(
            key = "remove database",
            value = "Removes a database from the engine."
    )
    public void removeDatabase(
            @ShellOption(value = {"-a", "--alias"}) String alias
    ) {
        // remove data from meta file
    }
}
