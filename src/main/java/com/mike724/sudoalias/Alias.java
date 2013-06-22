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
     * Class constructor
     * 
     * @param command 		value to hold
     * @param amountOfArgs 	value to hold
     * @param commandToRun 	value to hold
     * @param successMsg 	value to hold
     * @param permNode 		value to hold
     * @param runAs 		value to hold
    */
    public Alias(String command, int amountOfArgs, List<String> commandToRun, String successMsg, String permNode, AliasRunAs runAs) {
        this.command = command;
        this.amountOfArgs = amountOfArgs;
        this.commandsToRun = commandToRun;
        this.successMsg = (successMsg == null) ? "" : successMsg;
        this.permNode = permNode;
        this.runAs = runAs;
    }

	/**
	 * Simple getter for the command variable
	 * 
	 * @return the current variable in memory
	*/
    public String getCommand() {
        return command;
    }

	/**
	 * Simple setter for the command variable
	 * 
	 * @param command 	the new value to replace the old one
	 * @todo replace command with value for unification and to make future changes easier
	 * @note returning the old value or both old and new is common practice
	*/
    public void setCommand(String command) {
        this.command = command;
    }

	/**
	 * Simple getter for the amountOfArgs variable
	 * 
	 * @return the current variable in memory
	*/
    public int getAmountOfArgs() {
        return amountOfArgs;
    }

	/**
	 * Simple setter for the amountOfArgs variable
	 * 
	 * @param amountOfargs	the new value to replace the old one
	 * @todo replace amountOfargs with value for unification and to make future changes easier
	 * @note returning the old value or both old and new is common practice
	*/
    public void setAmountOfArgs(int amountOfArgs) {
        this.amountOfArgs = amountOfArgs;
    }

	/**
	 * Simple getter for the commandsToRun variable
	 * 
	 * @return the current variable in memory
	*/
    public List<String> getCommandsToRun() {
        return commandsToRun;
    }

	/**
	 * Simple setter for the commandsToRun variable
	 * 
	 * @param commandsToRun	the new value to replace the old one
	 * @todo replace commandsToRun with value for unification and to make future changes easier
	 * @note returning the old value or both old and new is common practice
	*/
    public void setCommandsToRun(List<String> commandsToRun) {
        this.commandsToRun = commandsToRun;
    }

	/**
	 * Simple getter for the successMsg variable
	 * 
	 * @return the current variable in memory
	*/
    public String getSuccessMessage() {
        return successMsg;
    }

	/**
	 * Simple setter for the successMsg variable
	 * 
	 * @param successMsg	the new value to replace the old one
	 * @todo replace successMsg with value for unification and to make future changes easier
	 * @note returning the old value or both old and new is common practice
	*/
    public void setSuccessMessage(String successMsg) {
        this.successMsg = successMsg;
    }

	/**
	 * Simple getter for the permNode variable
	 * 
	 * @return the current variable in memory
	*/
    public String getPermNode() {
        return permNode;
    }

	/**
	 * Simple setter for the permNode variable
	 * 
	 * @param permNode	the new value to replace the old one
	 * @todo replace permNode with value for unification and to make future changes easier
	 * @note returning the old value or both old and new is common practice
	*/
    public void setPermNode(String permNode) {
        this.permNode = permNode;
    }

	/**
	 * Simple getter for the runAs variable
	 * 
	 * @return the current variable in memory
	*/
    public AliasRunAs getRunAs() {
        return runAs;
    }

	/**
	 * Simple setter for the runAs variable
	 * 
	 * @param runAs	the new value to replace the old one
	 * @todo replace runAs with value for unification and to make future changes easier
	 * @note returning the old value or both old and new is common practice
	*/
    public void setRunAs(AliasRunAs runAs) {
        this.runAs = runAs;
    }

	/**
	 * Is the entered value a complete match
	 * 
	 * Does a comparison to see if the entered command is the same as this alias
	 * and also makes sure the arguments are an exact match as well or the whole request
	 * is rejected
	 * 
	 * @param cmd The raw command string entered by the user (Slash as well)
	 * @return boolean whether the command is a complete match or not
	*/
    public boolean isMatch(String cmd) {
    	
    	// Get class alias
        String aliasCmd = this.getCommand();
        
        // Check for a match
		// prefix the slash to the alias stored here since that's removed upon storing here
        if (cmd.startsWith("/" + aliasCmd)) {
        
        	// Break the entered command into individual arguments
            String[] args = this.getArgs(cmd);
            
            // Get the length of the arguments
            int argAmt = args.length;
            
            // Confirm the number of arguments match the ones stored here
            if (argAmt != this.getAmountOfArgs()) {
                return false;
            }
            return true;
        }
        return false;
    }

	/**
	 * Breaks the command string into individual segments
	 * 
	 * @param cmd the command string
	 * @return the command segments
	*/
    public String[] getArgs(String cmd) {
    	// Break the command up into segments (command as well)
        String[] arr = cmd.substring(("/" + this.getCommand()).length(), cmd.length()).split(" ");
        
        // Return all segments but the first one (the command)
        return Arrays.copyOfRange(arr, 1, arr.length);
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
