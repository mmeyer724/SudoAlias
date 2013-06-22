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
        return this.command;
    }

    /**
     * Simple setter for the command variable
     * 
     * @param value the new value to replace the old one
    */
    public String setCommand(String value) {
        return this.command = value;
    }

    /**
     * Simple getter for the amountOfArgs variable
     * 
     * @return the current variable in memory
    */
    public int getAmountOfArgs() {
        return this.amountOfArgs;
    }

    /**
     * Simple setter for the amountOfArgs variable
     * 
     * @param value the new value to replace the old one
     * @note returning the old value or both old and new is common practice
    */
    public int setAmountOfArgs(int value) {
        return this.amountOfArgs = value;
    }

    /**
     * Simple getter for the commandsToRun variable
     * 
     * @return the current variable in memory
    */
    public List<String> getCommandsToRun() {
        return this.commandsToRun;
    }

    /**
     * Simple setter for the commandsToRun variable
     * 
     * @param value the new value to replace the old one
    */
    public List<String> setCommandsToRun(List<String> value) {
        return this.commandsToRun = value;
    }

    /**
     * Simple getter for the successMsg variable
     * 
     * @return the current variable in memory
    */
    public String getSuccessMessage() {
        return this.successMsg;
    }

    /**
     * Simple setter for the successMsg variable
     * 
     * @param value the new value to replace the old one
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
    */
    public String setPermNode(String value) {
        return this.permNode = value;
    }

    /**
     * Simple getter for the runAs variable
     * 
     * @return the current variable in memory
    */
    public AliasRunAs getRunAs() {
        return this.runAs;
    }

    /**
     * Simple setter for the runAs variable
     * 
     * @param value the new value to replace the old one
     * @todo replace runAs with value for unification and to make future changes easier
     * @note returning the old value or both old and new is common practice
    */
    public AliasRunAs setRunAs(AliasRunAs value) {
        return this.runAs = value;
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
        
        // Check for a match
	// prefix the slash to the alias stored here since that's removed upon storing here
        if (command.startsWith("/" + this.getCommand())) {
        
            // Break the entered command into individual arguments
            String[] args = this.getArgs(command);
            
            // Get the length of the arguments
            int amountOfArgs = args.length;
            
            // Confirm the number of arguments match the ones stored here
            if (amountOfArgs != this.getAmountOfArgs()) {
                return false;
            }
            return true;
        }
        return false;
    }

    /**
     * Breaks the command string into individual segments
     * 
     * @param command the command string
     * @return the command segments
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
