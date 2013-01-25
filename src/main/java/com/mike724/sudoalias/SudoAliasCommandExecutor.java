package com.mike724.sudoalias;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.PluginDescriptionFile;

public class SudoAliasCommandExecutor implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("sudoalias")) {
			if(args.length!=0) {
				if(args.length==1) {
					if(args[0].equalsIgnoreCase("reload") && sender.hasPermission("SudoAlias.reload")) {
						SudoAlias.getInstance().reload();
						sender.sendMessage(ChatColor.GREEN+"SudoAlias configuration reloaded!");
						return true;
					}
				}
			} else {
				PluginDescriptionFile pdf = SudoAlias.getInstance().getDescription();
				sender.sendMessage(ChatColor.AQUA+"SudoAlias "+ChatColor.YELLOW+"v"+pdf.getVersion()+ChatColor.AQUA+" by "+ChatColor.YELLOW+pdf.getAuthors().get(0)+ChatColor.AQUA+" is "+ChatColor.GREEN+"running");
				return true;
			}
		}
		return false;
	}

}
