package com.mike724.sudoalias;

import org.bukkit.command.CommandSender;

/**
 * Executes the alias command
 * 
 * @author mike724
*/
public class AliasCmdExecutor implements Runnable {

    /**
     * The details of the command sender
    */
    private CommandSender sender;
    
    /**
     * The raw command to execute
    */
    private String command;

    /**
     * Class constructor
     * 
     * Just copies the given values to memory
     * 
     * @param sender The sender details of the command
     * @param command the command string
    */
    public AliasCmdExecutor(CommandSender sender, String command) {
        this.sender = sender;
        this.command = command;
    }

    /**
     * Tells the server to execute the command using details from sender
    */
    @Override
    public void run() {
        SudoAlias.getInstance().getServer().dispatchCommand(sender, this.command);
    }
}
