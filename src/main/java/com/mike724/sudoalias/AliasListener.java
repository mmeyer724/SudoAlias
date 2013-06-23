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

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.server.ServerCommandEvent;

/**
 * Event listener (Event Controller)
 *
 * @author mike724
 */
@SuppressWarnings("unused")
public class AliasListener implements Listener {

    /**
     * Listens for when the user types a command then acts on it
     * <p/>
     * When the user types something starting with a slash this method
     * processes it to see if it needs to act on it by comparing it to the
     * list of aliases in memory
     *
     * @param PlayerCommandPreprocessEvent the details on the event
     * @todo Clarify that this is accurate
     */
    @EventHandler(priority = EventPriority.LOWEST)
    public void handleCommandEvent(PlayerCommandPreprocessEvent e) {

        // Get this plugins instance
        SudoAlias plugin = SudoAlias.getInstance();

        // Get all the registered aliases
        for (Alias alias : plugin.aliases) {

            // Compare the raw entered string with each alias for a match
            if (alias.isMatch(e.getMessage())) {

                // Trigger event
                plugin.getServer().getScheduler().runTaskAsynchronously(plugin,
                        new AliasExecutor(alias, e.getMessage(), e.getPlayer(), e.getPlayer().getName()));

                // ?
                // @todo Fill out
                e.setCancelled(true);
                return;
            }
        }
    }

    /**
     * Listens for when the server admin types a command then into the server then acts on it
     * <p/>
     * When the server admin types something into the server console this method
     * processes it to see if it needs to act on it by comparing it to the
     * list of aliases in memory
     *
     * @param ServerCommandEvent the details on the event
     * @todo Clarify that this is accurate
     */
    @EventHandler(priority = EventPriority.LOWEST)
    public void handleServerCommandEvent(ServerCommandEvent e) {

        // Get the plugin instance
        SudoAlias plugin = SudoAlias.getInstance();

        // Prefix a slash in front of the command
        // @note This slash thing is best to just leave as is, for different reasons
        String cmd = "/" + e.getCommand();

        // Get all the registered aliases
        for (Alias alias : plugin.aliases) {

            // Compare the raw entered string with each alias for a match
            if (alias.isMatch(cmd)) {

                // Trigger event
                plugin.getServer().getScheduler().runTaskAsynchronously(plugin,
                        new AliasExecutor(alias, cmd, e.getSender(), e.getSender().getName()));

                // ?
                // @todo Fill out
                // @todo Explain this hack and reason
                //No setCancelled, have to be "hacky"
                e.setCommand("sudoalias nothing");
                return;
            }
        }
    }

}