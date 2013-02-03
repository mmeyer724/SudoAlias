package com.mike724.sudoalias;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class SudoAlias extends JavaPlugin {
	
	private static SudoAlias instance;
	public List<Alias> aliases;
	public Logger log;

	@Override
	public void onEnable() {
		instance = this;
		aliases = new ArrayList<Alias>();
		log = this.getLogger(); 
	
		if(!this.getDataFolder().exists()) {
			this.getDataFolder().mkdir();
		}
		FileConfiguration config = this.getConfig();
		config.options().copyDefaults(true);
		config.options().copyHeader(true);
		this.saveConfig();
		aliases = load(config);
		
		this.getServer().getPluginManager().registerEvents(new AliasListener(), this);
		this.getCommand("sudoalias").setExecutor(new SudoAliasCommandExecutor());
	}
	
	private List<Alias> load(FileConfiguration config) {
		List<Alias> aliasList = new ArrayList<Alias>();
		Set<String> keys = config.getConfigurationSection("aliases").getKeys(false);
		for(String key : keys) {
			String path = "aliases."+key;
			String perm = "SudoAlias.alias."+key;
			
			String commandOrig = config.getString(path+".command");
			
			String command = commandOrig.substring(0, commandOrig.indexOf(' ')-1);
			String args = commandOrig.substring(command.length()+1);
			int argCount = args.length() - args.replace("?", "").length();
			log.info("commandOrig: "+commandOrig);
			log.info("command: "+command);
			log.info("args: "+args);
			log.info("argCount: "+argCount);
			
			List<String> commandsToRun = config.getStringList(path+".runCommand");
			String successMsg = config.getString(path+".successMessage");
			String runAsString = config.getString(path+".runAs");
			AliasRunAs runAs = null;
			if(runAsString!=null) {
				runAs = AliasRunAs.valueOf(runAsString.toUpperCase().trim());
			}
			if(runAs==null || command==null || commandsToRun==null) {
				log.warning("Alias "+key+" skipped due to missing/incorrect information");
				continue;
			}
			aliasList.add(new Alias(command, commandsToRun, successMsg, perm, runAs));
		}
		return aliasList;
	}
	
	public void reload() {
		this.reloadConfig();
		FileConfiguration config = this.getConfig();
		aliases = load(config);
	}
	
	public static SudoAlias getInstance() {
		return instance;
	}
	
	@Override
	public void onDisable() {
		super.onDisable();
	}

}
