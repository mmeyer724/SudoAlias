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
// @todo Add import grouping to the other classes
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

// Java Imports
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The core Bukkit Class
*/
public class SudoAlias extends JavaPlugin {

    /**
     * The single plugin instance
    */
    private static SudoAlias instance;
    
    /**
     * All the plugin aliases
     *
     * @note All class variables should be private with a public getter/setter for best practices
    */
    public List<Alias> aliases;
    
    /**
     * ?
     *
     * @note All class variables should be private with a public getter/setter for best practices
     * @todo Investigate the Logger warning for being static and final and how it would
     * affect this plugin
    */
    public Logger log;

    /**
     * When the plugin becomes enabled
     * 
     * This is equivalent to a class constructor
    */
    @Override
    public void onEnable() {
        
        // Required to initialize most all the internal workings of the plugin
        Config.init();
        
    	/*// Initialize variables
        System.out.println("cmdFake: " + Config.cmdFake);
        System.out.println("cmdPlugin: " + Config.cmdPlugin);
        System.out.println("cmdReload: " + Config.cmdReload);
        
        System.out.println("configCmdName: " + Config.configCmdNamePath);
        System.out.println("configCmd: " + Config.configCmdPath);
        System.out.println("configFileName: " + Config.configFileName);
        System.out.println("configRoot: " + Config.configRootPath);
        System.out.println("configRunAs: " + Config.configRunAsPath);
        System.out.println("configRunCmd: " + Config.configRunCmdPath);
        System.out.println("configSuccMsg: " + Config.configSuccMsgPath);
        
        System.out.println("errAliasSkip: " + Config.errAliasSkip);
        System.out.println("errCmdWaitArg: " + Config.errCmdWaitArg);
        System.out.println("errPerm: " + Config.errPerm);
        
        System.out.println("msgReload: " + Config.msgReload);
        
        System.out.println("permCmdName: " + Config.permCmdNamePath);
        System.out.println("permGlobRoot: " + Config.permGlobRootPath);
        System.out.println("permReloadPath: " + Config.permReloadPath);
        System.out.println("permRootPath: " + Config.permRootPath);
        
        System.out.println("spCmdPrefix: " + Config.spCmdPrefix);
        System.out.println("spCmdSuffix: " + Config.spCmdSuffix);
        System.out.println("spCmdWait: " + Config.spCmdWait);
        
        System.out.println("spVarPlayer: " + Config.spVarPlayer);
        
        System.out.println("varArg: " + Config.varArg);
        
        System.out.println("cmdWaitArgDef: " + Config.cmdWaitArgDef);
        System.out.println("varArgPlaceholder: " + Config.varArgPlaceholder);*/
        
        //@note for best practices it's best to access a staticfield from an instance like this
        SudoAlias.instance = this;
        this.aliases = new ArrayList<Alias>();
        this.log = this.getLogger();

	// Make sure the config folder exists, if not create it
        if (!this.getDataFolder().exists()) {
            this.getDataFolder().mkdir();
        }
        
        // Load the config file, if it doesn't exist then make one from the defaults
        // @todo clarify this accuracy, I'm not too familiar with Bukkit API
        FileConfiguration config = this.getConfig();
        if (!new File(this.getDataFolder(), Config.configFileName).exists()) {
            config.options().copyDefaults(true);
            config.options().copyHeader(true);
            this.saveConfig();
        }
        
        // Load the aliases from the config
        this.aliases = load(config);

	// Setup the receiver for various events
        this.getServer().getPluginManager().registerEvents(new AliasListener(), this);
        this.getCommand(Config.cmdPlugin).setExecutor(new SudoAliasCommandExecutor());
    }

    /**
     * Loads the configuration file
     * 
     * @param config the configuration details
     * @return a list of the aliases
     * @todo This needs clarifying
    */
    private List<Alias> load(FileConfiguration config) {
    
    	// Setup the list
        List<Alias> aliasList = new ArrayList<Alias>();
        
        // Get Keys from config file
        Set<String> keys = config.getConfigurationSection(Config.configRootPath).getKeys(false);
        
        // For each key parse it then add to list and return the list
        for (String key : keys) {
            
            // Permission Root
            String perm = Config.permCmdNamePath.replace("%1", key);

            // Command from alias
            String commandOrig = config.getString(Config.configCmdPath.replace("%1", key)), command;
            
            // Calculate required arguments if any
            int argCount = 0;
            
            if (commandOrig.contains(Config.varArgPlaceholder.toString())) {
                command = commandOrig.substring(0, commandOrig.indexOf(Config.varArgPlaceholder) - 1);
                String args = commandOrig.substring(command.length() + 1);
                argCount = args.length() - args.replace(Config.varArgPlaceholder.toString(), "").length();
            } else {
                command = commandOrig;
            }

            // Get commands to run
            List<String> commandsToRun = config.getStringList(Config.configRunCmdPath.replace("%1", key));
            
            // Get success message
            String successMsg = config.getString(Config.configSuccMsgPath.replace("%1", key));
            
            // Get command to Run As
            String runAsString = config.getString(Config.configRunAsPath.replace("%1", key));
            
            // Pase runAs, if it's there format it correctly, else leave null
            AliasRunAs runAs = null;
            if (runAsString != null) {
            	// @note This means that this value does not need to be entered case sentitive
            	// and can contain whitespace after it
                runAs = AliasRunAs.valueOf(runAsString.toUpperCase().trim());
            }
            
            // Check to see if this alias is correctly inserted, if not then skip it
            // else add it
            if (runAs == null || command.isEmpty() || commandsToRun == null) {
                // @note Netbeans suggested this fix, it looks more acceptable but I'm
                // not too sure how it would affect the class/plugin as a whole
                this.log.log(Level.WARNING, Config.errAliasSkip, key);
                continue;
            }
            
            aliasList.add(new Alias(command, argCount, commandsToRun, successMsg, perm, runAs));
        }
        return aliasList;
    }

    /**
     * Reload Configuration from configuration file
    */
    public void reload() {
    	// Call the reload method, get the config, and load aliases from config
        this.reloadConfig();
        FileConfiguration config = this.getConfig();
        this.aliases = load(config);
    }

	/**
	 * Simple getter to return this plugins instance
	 * 
	 * @return the plugins instance
	*/
    public static SudoAlias getInstance() {
        return SudoAlias.instance;
    }

	//@todo add a simple private setter for setInstance for best programming practices
	// and use that in onEnabled

	/**
	 * Plugin Disabled
	*/
    @Override
    public void onDisable()
    {
    	// An empty method, just call parent
        super.onDisable();
    }

}
