package org.nanulik.command;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

/**
 * @author Nane Petrosyan
 * 13.07.24
 */

@ShellComponent
public class TableCommands {

    @ShellMethod(key = "create table")
    public void createCollection(
            @ShellOption(value = {"-n", "--name"}) String name,
            @ShellOption(value = {"-s", "--schema"}, optOut = true) String schema,
            @ShellOption(value = {"-db", "--database-alias" }) String database
    ) {
        // fetch database type from storage
        // create a table/collection in the db
    }

    @ShellMethod(key = "remove table")
    public void removeCollection(
            @ShellOption(value = {"-n", "--name"}) String name,
            @ShellOption(value = {"-db", "--database-alias" }) String database
    ) {
        // fetch database type from storage
        // remove the table in the db
    }

    @ShellMethod(key = "update table")
    public void updateCollection(
            @ShellOption(value = {"-n", "--name"}) String name,
            @ShellOption(value = {"-b", "--body"}) String body,
            @ShellOption(value = {"-db", "--database-alias" }) String database
    ) {
        // fetch database type from storage
        // update the table in the db
    }

    @ShellMethod(key = "read table")
    public void readCollection( // TODO: map
            @ShellOption(value = {"-n", "--name"}) String name,
            @ShellOption(value = {"-db", "--database-alias" }) String database,
            @ShellOption(optOut = true, value = {"-f", "--fields" }) String fields,
            @ShellOption(optOut = true, value = {"--filter" }) String filter
    ) {
        // fetch database type from storage
        // read table from the db
    }
}
