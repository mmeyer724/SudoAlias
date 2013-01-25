package com.mike724.sudoalias;

import java.util.List;

public class Alias {
	
	private String command;
	private List<String> commandsToRun;
	private String successMsg;
	private String permNode;
	private AliasRunAs runAs;
	
	public Alias(String command, List<String> commandToRun, String successMsg, String permNode, AliasRunAs runAs) {
		this.command = command;
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
		info += "commandToRun: "+commandsToRun+"\n";
		info += "successMsg: "+successMsg+"\n";
		info += "permNode: "+permNode+"\n";
		info += "runAs: "+runAs.name()+"";
		return info;
	}
	
}
