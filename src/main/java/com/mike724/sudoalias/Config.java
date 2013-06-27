/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mike724.sudoalias;

/**
 * This class holds the global plugin-wide configuration
 * 
 * @author wiseguy12851
 */
public class Config {
    
    // Errors
    
    /**
     * The permission error response
     */
    public static String errPerm = "Sorry, you don't have permission to do that.";
    
    /**
     * Invalid Wait Command Numeric Argument
     * 
     * @param _1 The Second argument that was provided which is incorrect
     * @param _2 The default fallback value
     */
    public static String errCmdWaitArg = "Invalid long time value %1 defaulting to %2."
            .replace("%2", Long.toString(Config.cmdWaitArgDef));
    
    /**
     * Alias skipped error message
     * 
     * @param _1 The CommandName
     */
    public static String errAliasSkip = "Alias %1 skipped due to missing/incorrect information.";
    
    // Messages
    
    /**
     * Reload Success Message
     */
    public static String msgReload = "SudoAlias configuration reloaded!";
    
    // Special Commands
    
    /**
     * The wait special command
     */
    public static String spCmdWait = 
            Config.spCmdPrefix +
            "wait" +
            Config.spCmdSuffix;
    
    // Special Variables
    
    /**
     * The player variable
     */
    public static String spVarPlayer = 
            Config.spCmdPrefix +
            "player" +
            Config.spCmdSuffix;
    
    /**
     * The Arguments Variable Prefix
     * 
     * @param _1 The argument number
     */
    public static String varArg = 
            Config.spCmdPrefix +
            "%1" +
            Config.spCmdSuffix;
    
    /**
     * The argument placeholder
     * 
     * The argument placeholder for command alias
     */
    public static Character varArgPlaceholder = '?';
    
    // Commands
    
    /**
     * Plugin Command
     */
    public static String cmdPlugin = "sudoalias";
    
    /**
     * The fake command name
     * 
     * The command that this plugin accepts but does nothing about
     */
    public static String cmdFake = "nothing";
    
    /**
     * The reload command
     */
    public static String cmdReload = "reload";
    
    // Default values
    
    /**
     * The default length of time to wait
     */
    public static long cmdWaitArgDef = 1000l;
    
    // Global Settings
    
    /**
     * The command prefix
     * 
     * The prefix that follows all special commands and variables
     */
    public static String spCmdPrefix = "$";
    
    /**
     * The command suffix
     * 
     * The suffix that follows all special commands and variables
     */
    public static String spCmdSuffix = "";
    
    // Configuration File
    
    /**
     * The config file name
     */
    public static String configFileName = "config.yml";
    
    /**
     * The config root path
     * 
     * @param _0 The path to the config root
     */
    public static String configRootPath = "%0"
            .replace("%0", "aliases");
    
    /**
     * The command name path
     * 
     * For example, this might come out to be aliases.CommandName
     * 
     * @param _0 The command root
     * @param _1 The command name, this will be replaced later by the method
     */
    public static String configCmdNamePath = "%0.%1"
            .replace("%0", Config.configRootPath);
    
    /**
     * The command path
     * 
     * @param _0 The path to command name
     * @param _1 (Inherited from _0) The CommandName
     * @param _2 The command text
     */
    public static String configCmdPath = "%0.%2"
            .replace("%0", Config.configCmdNamePath)
            .replace("%2", "command");
    
    /**
     * The run command path
     * 
     * @param _0 The path to command name
     * @param _1 (Inherited from _0) The CommandName
     * @param _2 The run command text
     */
    public static String configRunCmdPath = "%0.%2"
            .replace("%0", Config.configCmdNamePath)
            .replace("%2", "runCommand");
    
    /**
     * The success message path
     * 
     * @param _0 The path to command name
     * @param _1 (Inherited from _0) The CommandName
     * @param _2 The success message text
     */
    public static String configSuccMsgPath = "%0.%2"
            .replace("%0", Config.configCmdNamePath)
            .replace("%2", "successMessage");
    
    /**
     * The run as path
     * 
     * @param _0 The path to command name
     * @param _1 (Inherited from _0) The CommandName
     * @param _2 The run as text
     */
    public static String configRunAsPath = "%0.%2"
            .replace("%0", Config.configCmdNamePath)
            .replace("%2", "runAs");
    
    // Permissions
    
    /**
     * The global permission root path
     * 
     * @param _0 The gloabl permission root path
     */
    public static String permGlobRootPath = "%0"
            .replace("%0", "SudoAlias");
    
    /**
     * The permission root path
     * 
     * @param _0 Global Permission Root Path
     * @param _1 Global Config Root Path
     */
    public static String permRootPath = "%0.%1"
            .replace("%0", Config.permGlobRootPath)
            .replace("%1", Config.configRootPath);
    
    /**
     * The reload permission path
     * 
     * @param _0 Global Permission Root
     * @param _1 Reload Command Name
     */
    public static String permReloadPath = "%0.%1"
            .replace("%0", Config.permGlobRootPath)
            .replace("%1", Config.cmdReload);
    
    /**
     * The CommandName Permission Path
     * 
     * For example, this might come out to be SudoAlias.aliases.CommandName
     * 
     * @param _0 The permission root
     * @param _1 The CommandName, will be replaced later
     */
    public static String permCmdNamePath = "%0.%1"
            .replace("%0", Config.permRootPath);
}
