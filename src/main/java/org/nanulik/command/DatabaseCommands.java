package org.nanulik.command;

import org.nanulik.model.DatabaseMapping;
import org.nanulik.model.DatabaseMetadata;
import org.nanulik.model.DatabaseType;
import org.nanulik.service.DatabaseService;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.util.List;

/**
 * @author Nane Petrosyan
 * 13.07.24
 */

@ShellComponent
public class DatabaseCommands {
    private final DatabaseService databaseService;

    public DatabaseCommands(DatabaseService databaseService) {
        this.databaseService = databaseService;
    }

    @ShellMethod(
            key = "add database",
            value = "Attaches a database to the engine."
    )
    public void addDatabase(
            @ShellOption(value = {"-a", "--alias"}) String alias,
            @ShellOption(value = {"-u", "--url"}) String url,
            @ShellOption(value = {"-t", "--type" }) DatabaseType type
    ) {
        databaseService.addDatabaseMapping(url, alias, type);
    }

    @ShellMethod(
            key = "remove database",
            value = "Removes a database from the engine."
    )
    public void removeDatabase(
            @ShellOption(value = {"-a", "--alias"}) String alias
    ) {
        databaseService.removeDatabaseMapping(alias);
    }

    @ShellMethod(
            key = "list databases",
            value = "Reads databases from the engine."
    )
    public DatabaseMetadata listDatabases() {
        return databaseService.readDatabases();
    }
}
