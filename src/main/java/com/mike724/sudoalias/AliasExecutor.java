package com.mike724.sudoalias;

import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.command.CommandSender;

/**
 * ?
 * 
 * @author mike724
*/
public class AliasExecutor implements Runnable {

	/**
	 * The alias
	*/
    private Alias alias;
    
    /**
	 * The command
	*/
    private String cmd;
    
    /**
	 * ?
	 * 
	 * @todo Fill this in
	*/
    private CommandSender sender;
    
    /**
	 * ?
	 * 
	 * @todo fill this in, I think it's the player name
	*/
    private String pName;

	/**
	 * Class constructor
	 * 
	 * @param alias The alias
	 * @param cmd The command string
	 * @param sender ?
	 * @param pName ?
	 * @todo Fill this in
	*/
    public AliasExecutor(Alias alias, String cmd, CommandSender sender, String pName) {
        this.alias = alias;
        this.cmd = cmd;
        this.sender = sender;
        this.pName = pName;
    }

	/**
	 * Thread Run method
	*/
    @Override
    public void run() {
    	// Check for permissions first
        if (!sender.hasPermission(alias.getPermNode())) {
        	// @todo Create a standardized static messaging class with methods like
        	// .warn, .log, and .error, etc... Good programming practice, makes
        	// modifications easier, and creates consistency and shorter typing, less
        	// duplicate code
            sender.sendMessage(ChatColor.RED + "Sorry, you don't have permission to do that.");
            return;
        }
        
        // Don't understand this at all,
        // @todo needs clarification
        String[] args = alias.getArgs(cmd);
        int argAmt = args.length;
        for (String command : alias.getCommandsToRun()) {
            if (command.startsWith("$wait:")) {
                String[] data = command.split(":");
                if (data.length != 2) {
                    continue;
                }
                long time = 1000l;
                try {
                    time = Long.parseLong(data[1]);
                } catch (NumberFormatException ex) {
                    SudoAlias.getInstance().getLogger().warning("Invalid long time value " + data[1] + " defaulting to 1000.");
                }
                try {
                    Thread.sleep(time);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                if (pName != null && !pName.isEmpty()) {
                    command = command.replace("$player", pName);
                }
                for (int i = 0; i < argAmt; i++) {
                    command = command.replace("$" + i, args[i]);
                }
                Server server = SudoAlias.getInstance().getServer();
                if(alias.getRunAs() == AliasRunAs.CONSOLE) {
                    server.getScheduler().scheduleSyncDelayedTask(SudoAlias.getInstance(),
                            new AliasCmdExecutor(server.getConsoleSender(), command));
                } else if(alias.getRunAs() == AliasRunAs.PLAYER) {
                    server.getScheduler().scheduleSyncDelayedTask(SudoAlias.getInstance(),
                            new AliasCmdExecutor(sender, command));
                }
            }
        }
        
        // Now that everything is over issue the success message if there is one
        String successMsg = alias.getSuccessMessage();
        if (!successMsg.isEmpty() && successMsg != null) {
            sender.sendMessage(successMsg);
        }
    }

}
