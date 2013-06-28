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

// Java Imports
import java.util.Arrays;
import java.util.List;

/**
 * This class holds a single alias in memory
 * 
 * @author mike724
*/
@SuppressWarnings("unused")
public class Alias {

    /**
     * The alias command
    */
    private String command;
    
    /**
     * The commands to run
    */
    private List<String> commandsToRun;
    
    /**
     * The success message
    */
    private String successMsg;
    
    /**
     * The permission node
    */
    private String permNode;
    
    /**
     * The commands to run as
    */
    private AliasRunAs runAs;
    
    /**
     * The number of arguments
    */
    private int amountOfArgs;
    
    /**
     * All the local defines
    */
    public List<Define> localDefines;
    
    /**
     * Whether to enable strict args mode
     * 
     * If enabled the arguments given must match exactly or the command will be skipped
     * all together, if disabled the arguments are optional and more or less can be given
     */
    private boolean strictArgs;

    /**
     * Class constructor
     * 
     * @param command 		The command without slash
     * @param amountOfArgs 	number of arguments with command
     * @param commandToRun 	list of commands to run
     * @param successMsg 	the success message
     * @param permNode 		the command permission string
     * @param runAs 		run as who value
    */
    public Alias(String command, 
            int amountOfArgs, 
            List<String> commandToRun, 
            String successMsg, 
            String permNode, 
            AliasRunAs runAs, 
            boolean strictArgs,
            List<Define> localDefines) {
        this.command = command;
        this.amountOfArgs = amountOfArgs;
        this.commandsToRun = commandToRun;
        this.successMsg = (successMsg == null) ? "" : successMsg;
        this.permNode = permNode;
        this.runAs = runAs;
        this.strictArgs = strictArgs;
        this.localDefines = localDefines;
    }

    /**
     * Simple getter for the command variable
     * 
     * @return the current value
    */
    public String getCommand() {
        return this.command;
    }

    /**
     * Simple setter for the command variable
     * 
     * @param value the new value to replace the old one
     * @return The newly stored value
    */
    public String setCommand(String value) {
        return this.command = value;
    }

    /**
     * Simple getter for the amountOfArgs variable
     * 
     * @return the current value in memory
    */
    public int getAmountOfArgs() {
        return this.amountOfArgs;
    }

    /**
     * Simple setter for the amountOfArgs variable
     * 
     * @param value the new value to replace the old one
     * @return the newly stored value
    */
    public int setAmountOfArgs(int value) {
        return this.amountOfArgs = value;
    }

    /**
     * Simple getter for the commandsToRun variable
     * 
     * @return the current value in memory
    */
    public List<String> getCommandsToRun() {
        return this.commandsToRun;
    }

    /**
     * Simple setter for the commandsToRun variable
     * 
     * @param value the new value to replace the old one
     * @return the newly stored value
    */
    public List<String> setCommandsToRun(List<String> value) {
        return this.commandsToRun = value;
    }

    /**
     * Simple getter for the successMsg variable
     * 
     * @return the current value in memory
    */
    public String getSuccessMessage() {
        return this.successMsg;
    }

    /**
     * Simple setter for the successMsg variable
     * 
     * @param value the new value to replace the old one
     * @return the newly stored value
    */
    public String setSuccessMessage(String value) {
        return this.successMsg = value;
    }

    /**
     * Simple getter for the permNode variable
     * 
     * @return the current variable in memory
    */
    public String getPermNode() {
        return this.permNode;
    }

    /**
     * Simple setter for the permNode variable
     * 
     * @param value the new value to replace the old one
     * @return the newly stored value
    */
    public String setPermNode(String value) {
        return this.permNode = value;
    }

    /**
     * Simple getter for the runAs variable
     * 
     * @return the current value in memory
    */
    public AliasRunAs getRunAs() {
        return this.runAs;
    }

    /**
     * Simple setter for the runAs variable
     * 
     * @param value the new value to replace the old one
     * @return the newly stored value
    */
    public AliasRunAs setRunAs(AliasRunAs value) {
        return this.runAs = value;
    }
    
    /**
     * Simple getter for the strictArgs variable
     * 
     * @return the current value in memory
    */
    public boolean getStrictArgs() {
        return this.strictArgs;
    }

    /**
     * Simple setter for the strictArgs variable
     * 
     * @param value the new value to replace the old one
     * @return the newly stored value
    */
    public boolean setStrictArgs(boolean value) {
        return this.strictArgs = value;
    }

    /**
     * Is the entered value a complete match
     * 
     * Does a comparison to see if the entered command is the same as this alias
     * and also makes sure the arguments are an exact match as well or the whole request
     * is rejected
     * 
     * @param command The raw command string entered by the user (Slash as well)
     * @return boolean whether the command is a complete match or not
    */
    public boolean isMatch(String command) {
        
        // Take raw command string, trim it, then split it up
        String[] cmdExploded = command.trim().split(" ");
        
        // Make sure it's got at least 1 segment (The Command)
        if(cmdExploded == null || cmdExploded.length < 1) return false;
        
        // Extract command
        String cmd = cmdExploded[0];
        int args = 0;
        
        // Check for arguments, if it has any note how many
        if(cmdExploded.length > 1) { args = cmdExploded.length - 1; }
        
        // Check for slash prefix, if it has one then remove it
        if(cmd.startsWith("/")) { cmd = cmd.substring(1); }
        
        // Now begin comparing
        // If strict args mode is on compare the name and the args, else just the name
        if(this.strictArgs)
        {
            if(
                    this.getCommand().equalsIgnoreCase(cmd) &&
                    this.getAmountOfArgs() == args
              )
            {
                return true;
            }
            
            return false;
        }
        else
        {
            if(
                    this.getCommand().equalsIgnoreCase(cmd)
              )
            {
                return true;
            }
            
            return false;
        }
    }

    /**
     * Breaks the command string into individual segments
     * 
     * @param command the command string
     * @return the command segments minus the command itself
    */
    public String[] getArgs(String command) {
        
    	// Break the command up into segments (command as well)
        String[] commandExploded = command.substring(("/" + this.getCommand()).length(), command.length()).split(" ");
        
        // Return all segments but the first one (the command)
        return Arrays.copyOfRange(commandExploded, 1, commandExploded.length);
    }

    /**
     * Custom class serialization
     * 
     * @return the serialized class
    */
    @Override
    public String toString() {
        String info = "Alias Information\n";
        info += "=================\n";
        info += "command: " + command + "\n";
        info += "amountOfArgs: " + amountOfArgs + "\n";
        info += "commandToRun: " + commandsToRun + "\n";
        info += "successMsg: " + successMsg + "\n";
        info += "permNode: " + permNode + "\n";
        info += "runAs: " + runAs.name() + "";
        return info;
    }

}
