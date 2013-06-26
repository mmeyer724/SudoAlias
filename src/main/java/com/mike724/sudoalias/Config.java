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
    public static String permErrorStr = "Sorry, you don't have permission to do that.";
    
    /**
     * Invalid Wait Command Numeric Argument
     * 
     * @param _0 The Second argument that was provided which is incorrect
     */
    public static String cmdWaitArgErrStr = "Invalid long time value {0} defaulting to " + Long.toString(Config.cmdWaitArgDef) + ".";
    
    /**
     * Alias skipped error message
     * 
     * @param _0 The CommandName
     */
    public static String aliasSkipErrStr = "Alias {0} skipped due to missing/incorrect information.";
    
    // Messages
    
    public static String reloadMsg = "SudoAlias configuration reloaded!";
    
    // Commands
    
    /**
     * The wait command
     */
    public static String cmdWaitStr = Config.commandWrap("wait");
    
    // Variables
    
    /**
     * The player variable
     */
    public static String varPlayer = Config.commandWrap("player");
    
    /**
     * The Arguments Variable Prefix
     * 
     * @param _0 The argument number
     */
    public static String varArg = Config.commandWrap("{0}");
    
    // Defaults
    
    /**
     * Plugin Command
     */
    public static String pluginCmd = "sudoalias";
    
    /**
     * The fake command name
     * 
     * The command that this plugin accepts but does nothing about
     */
    public static String fakeCommand = "nothing";
    
    /**
     * The reload command
     */
    public static String reloadCommand = "reload";
    
    /**
     * The default length of time to wait
     */
    public static long cmdWaitArgDef = 1000l;
    
    /**
     * The command prefix
     * 
     * The prefix that follows all special commands and variables
     */
    public static String cmdPrefix = "$";
    
    /**
     * The command suffix
     * 
     * The suffix that follows all special commands and variables
     */
    public static String cmdSuffix = "";
    
    /**
     * The config file name
     */
    public static String configFileName = "config.yml";
    
    /**
     * The config root branch
     */
    public static String configRoot = "aliases";
    
    /**
     * The permission global root
     */
    public static String permGlobRoot = "SudoAlias";
    
    /**
     * The permission root branch
     */
    public static String permRoot = Config.permGlobRoot + "." + Config.configRoot;
    
    /**
     * The reload permission
     */
    public static String permReload = Config.permGlobRoot + "." + Config.reloadCommand;
    
    /**
     * The command name layout
     * 
     * For example, this might come out to be aliases.CommandName
     * 
     * @param _0 The command name
     */
    public static String configCmdNameLayout = Config.configRoot + ".{0}";
    
    /**
     * The perm layout
     * 
     * For example, this might come out to be SudoAlias.aliases.CommandName
     * 
     * @param _0 The command name
     */
    public static String permLayout = Config.permRoot + ".{0}";
    
    /**
     * The command sub branch name
     */
    public static String configCmdBranchName = ".command";
    
    /**
     * The run command sub branch name
     */
    public static String configRunCmdBranchName = ".runCommand";
    
    /**
     * The success message sub branch name
     */
    public static String configSuccMsgBranchName = ".successMessage";
    
    /**
     * The run as sub branch name
     */
    public static String configRunAsBranchName = ".runAs";
    
    /**
     * The argument placeholder
     */
    public static Character argPlaceholder = '?';
    
    /**
     * Wraps a special command or variable with a global prefix and suffix
     * 
     * @param input the unwrapped command
     * @return the command wrapped with a prefix and suffix
     */
    public static String commandWrap(String input)
    {
        return Config.cmdPrefix + input + Config.cmdSuffix;
    }
}
