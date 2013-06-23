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

// Core Bukkit Imports

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.PluginDescriptionFile;

/**
 * Plugin Command Executor
 *
 * @author mike724
 */
public class SudoAliasCommandExecutor implements CommandExecutor {

    /**
     * When a command is sent from somewhere
     *
     * @param sender Sender Details
     * @param cmd    Command Details
     * @param label  ?
     * @param args   ? (Command Arguments?)
     * @return ?
     * @todo Fill this out
     */
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        // If someone typed /sudoalias (Case insensitive)
        if (cmd.getName().equalsIgnoreCase("sudoalias")) {
            if (args.length != 0) {

                // With one argument
                if (args.length == 1) {

                    // @note there is a permission SudoAlias.reload
                    // @note reload can be called from anywhere
                    if (args[0].equalsIgnoreCase("reload") && sender.hasPermission("SudoAlias.reload")) {

                        // And that argument is reload
                        SudoAlias.getInstance().reload();
                        sender.sendMessage(ChatColor.GREEN + "SudoAlias configuration reloaded!");
                        return true;

                    } else if (args[0].equalsIgnoreCase("nothing")) {
                        // @note Part of the hack workaround
                        return true;
                    }
                }
            } else {
                // If called without args
                PluginDescriptionFile pdf = SudoAlias.getInstance().getDescription();
                sender.sendMessage(ChatColor.AQUA + "SudoAlias " + ChatColor.YELLOW + "v" + pdf.getVersion() + ChatColor.AQUA + " by " + ChatColor.YELLOW + pdf.getAuthors().get(0) + ChatColor.AQUA + " is " + ChatColor.GREEN + "running");
                return true;
            }
        }

        // Signal that we're ignoring this one
        return false;
    }

}
