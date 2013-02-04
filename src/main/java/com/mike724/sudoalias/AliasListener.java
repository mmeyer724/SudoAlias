package com.mike724.sudoalias;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class AliasListener implements Listener {
	
	@EventHandler(priority = EventPriority.HIGH)
	public void handleCommandEvent(PlayerCommandPreprocessEvent pcpe) {
		SudoAlias plugin = SudoAlias.getInstance();
		String message = pcpe.getMessage();
		String[] split = message.split(" ");
		String calledCmd = message;
		int amtArgs = 0;
		if(split.length != 0) {
			calledCmd = split[0];
			amtArgs = split.length-1;
		}
		for(Alias alias : plugin.aliases) {
			if(calledCmd.equalsIgnoreCase("/"+alias.getCommand()) && alias.getAmountOfArgs() == amtArgs) {
				//dev
				plugin.log.info("\n"+alias.toString());
				Player player = pcpe.getPlayer();
				if(player.hasPermission(alias.getPermNode())) {
					CommandSender sender = null;
					switch(alias.getRunAs()) {
						case CONSOLE:
							sender = plugin.getServer().getConsoleSender();
							break;
						case PLAYER:
							sender = (CommandSender)player;
							break;
						default:
							break;
					}
					String playerName = player.getName();
					for(String cmd : alias.getCommandsToRun()) {
						cmd = cmd.replace("$player", playerName);
						for(int i=0;i<amtArgs;i++) {
							cmd = cmd.replace("$"+i, split[i+1]);
						}
						plugin.getServer().dispatchCommand(sender, cmd.replace("$player", playerName));	
					}
					String successMsg = alias.getSuccessMessage();
					if(successMsg!="") {
						player.sendMessage(successMsg);
					}
					pcpe.setCancelled(true);
				} else {
					player.sendMessage(ChatColor.RED+"Permission denied!");
					pcpe.setCancelled(true);
					return;
				}
			}
		}
	}
}