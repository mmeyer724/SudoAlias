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

import java.util.List;

public class Alias {
	
	private String command;
	private List<String> commandsToRun;
	private String successMsg;
	private String permNode;
	private AliasRunAs runAs;
	private int amountOfArgs;
	
	public Alias(String command, int amountOfArgs, List<String> commandToRun, String successMsg, String permNode, AliasRunAs runAs) {
		this.command = command;
		this.amountOfArgs = amountOfArgs;
		this.commandsToRun = commandToRun;
		this.successMsg = (successMsg==null) ? "" : successMsg;
		this.permNode = permNode;
		this.runAs = runAs;
	}

	public String getCommand() {
		return command;
	}

	public void setCommand(String command) {
		this.command = command;
	}

	public int getAmountOfArgs() {
		return amountOfArgs;
	}

	public void setAmountOfArgs(int amountOfArgs) {
		this.amountOfArgs = amountOfArgs;
	}

	public List<String> getCommandsToRun() {
		return commandsToRun;
	}

	public void setCommandsToRun(List<String> commandsToRun) {
		this.commandsToRun = commandsToRun;
	}

	public String getSuccessMessage() {
		return successMsg;
	}

	public void setSuccessMessage(String successMsg) {
		this.successMsg = successMsg;
	}

	public String getPermNode() {
		return permNode;
	}

	public void setPermNode(String permNode) {
		this.permNode = permNode;
	}

	public AliasRunAs getRunAs() {
		return runAs;
	}

	public void setRunAs(AliasRunAs runAs) {
		this.runAs = runAs;
	}
	
	@Override
	public String toString() {
		String info = "Alias Information\n";
		info += "=================\n";
		info += "command: "+command+"\n";
		info += "amountOfArgs: "+amountOfArgs+"\n";
		info += "commandToRun: "+commandsToRun+"\n";
		info += "successMsg: "+successMsg+"\n";
		info += "permNode: "+permNode+"\n";
		info += "runAs: "+runAs.name()+"";
		return info;
	}
	
}
