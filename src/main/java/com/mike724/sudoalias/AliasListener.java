/*
    This file is part of SudoAlias.

    SudoAlias is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    SudoAlias is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with SudoAlias.  If not, see <http://www.gnu.org/licenses/>.
*/
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