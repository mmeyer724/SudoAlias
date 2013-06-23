package com.mike724.sudoalias;

import org.bukkit.command.CommandSender;

/**
 * ?
 *
 * @author mike724
 * @todo fill in the class description
 */
public class AliasCmdExecutor implements Runnable {

    /**
     * ?
     *
     * @todo Fill in the description
     */
    private CommandSender sender;

    /**
     * The command to execute
     */
    private String cmd;

    /**
     * Class constructor
     *
     * @param sender ?
     * @param cmd    the command string
     * @todo fill in the sender details
     */
    public AliasCmdExecutor(CommandSender sender, String cmd) {
        this.sender = sender;
        this.cmd = cmd;
    }

    /**
     * Thread run method
     *
     * @todo elaborate
     */
    @Override
    public void run() {
        SudoAlias.getInstance().getServer().dispatchCommand(sender, cmd);
    }
}
