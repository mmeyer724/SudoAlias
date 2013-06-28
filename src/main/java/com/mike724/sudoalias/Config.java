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
    
    /***************************************
     * GLOBAL VARIABLES
     ***************************************/
    
    /**
     * The special command/variable prefix
     * 
     * The prefix that comes before all special commands and variables
     */
    public static String spCmdPrefix = "$";
    
    /**
     * The command suffix
     * 
     * The suffix that follows all special commands and variables
     */
    public static String spCmdSuffix = "";
    
    /***************************************
     * ERRORS
     ***************************************/
    
    /**
     * The permission denied error response
     */
    public static String errPerm = "Sorry, you don't have permission to do that.";
    
    /**
     * Invalid Number Argument to Wait Command response
     * 
     * @param _1 The invalid number that was provided as the argument. (Provided Externally)
     * @param _2 The number that is being fallen back to (Provided Internally)
     */
    public static String errCmdWaitArg = "Invalid long time value %1 defaulting to %2.";
            
    
    /**
     * Alias skipped error message
     * 
     * @param _1 The CommandName that is being skipped (Provided Externally)
     */
    public static String errAliasSkip = "Alias %1 skipped due to missing/incorrect information.";
    
    /**
     * Wrong argument to defines
     * 
     * @param _0 The raw argument provided wrong (Provided Externally)
     */
    public static String defineWrongArg = "Wrong argument to define: %0";
    
    /***************************************
     * MESSAGES
     ***************************************/
    
    /**
     * Reload Success Message
     */
    public static String msgReload = "SudoAlias configuration reloaded!";
    
    /***************************************
     * SPECIAL COMMANDS
     ***************************************/
    
    /**
     * The wait special command
     */
    public static String spCmdWait = "wait";
    
    /***************************************
     * SPECIAL VARIABLES
     ***************************************/
    
    /**
     * The player variable
     */
    public static String spVarPlayer = "player";
    
    /**
     * Insert Argument variable
     * 
     * @param _1 The argument number (Provided Externally)
     */
    public static String varArg = "%1";
    
    /**
     * Insert Define variable
     * 
     * @param _1 The define key (Provided Externally)
     */
    public static String spVarDef = "%1";
    
    /**
     * The argument placeholder
     * 
     * The argument placeholder for command alias
     */
    public static Character varArgPlaceholder = '?';
    
    /***************************************
     * COMMANDS
     ***************************************/
    
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
    
    /***************************************
     * DEFAULT VALUES
     ***************************************/
    
    /**
     * The default length of time to wait for the wait command
     * 
     * Only used in case of error
     */
    public static long cmdWaitArgDef = 1000l;
    
    /***************************************
     * CONFIGURATION FILE
     ***************************************/
    
    /**
     * The config file name
     * 
     * Where to load the config file
     */
    public static String configFileName = "config.yml";
    
    /**
     * The config root path
     * 
     * What path should all the other paths fall under in the file
     * 
     * @param _0 The path to the config root (Provided Internally)
     */
    public static String configRootPath = "%0";
    
    /**
     * The command name path
     * 
     * The path to the CommandName section in the file
     * 
     * @param _0 The command root (Provided Internally)
     * @param _1 The command name (Provided Externally)
     */
    public static String configCmdNamePath = "%0.%1";
    
    /**
     * The command path
     * 
     * The path to the command in the CommandName section in the file
     * 
     * @param _0 The path to CommandName (Provided In/Externally)
     * @param _1 (Inherited from _0) The CommandName (Provided Externally)
     * @param _2 The path from CommandName to command (Provided Internally)
     */
    public static String configCmdPath = "%0.%2";
    
    /**
     * The run command path
     * 
     * The path to the run command list in the CommandName section in the file
     * 
     * @param _0 The path to command name (Provided In/Externally)
     * @param _1 (Inherited from _0) The CommandName (Provided Externally)
     * @param _2 The path from CommandName to run command (Provided Internally)
     */
    public static String configRunCmdPath = "%0.%2";
    
    /**
     * The define command path
     * 
     * The path to the define command list in the file
     * 
     * @param _0 The path to the define root (Provided Internally)
     */
    public static String configDefinePath = "%0";
    
    /**
     * The success message path
     * 
     * The path to the success message in the CommandName section in the file
     * 
     * @param _0 The path to command name (Provided In/Externally)
     * @param _1 (Inherited from _0) The CommandName (Provided Externally)
     * @param _2 The path from CommandName to success message (Provided Internally)
     */
    public static String configSuccMsgPath = "%0.%2";
    
    /**
     * The run as path
     * 
     * The path to the run as in the CommandName section in the file
     * 
     * @param _0 The path to command name (Provided In/Externally)
     * @param _1 (Inherited from _0) The CommandName (Provided Externally)
     * @param _2 The path from CommandName to run as (Provided Internally)
     */
    public static String configRunAsPath = "%0.%2";
    
    /**
     * The strict args path
     * 
     * The path to the strict args in the CommandName section in the file
     * 
     * @param _0 The path to command name (Provided In/Externally)
     * @param _1 (Inherited from _0) The CommandName (Provided Externally)
     * @param _2 The path from CommandName to strict args as (Provided Internally)
     */
    public static String configStrictArgsPath = "%0.%2";
    
    /**
     * The local defines path
     * 
     * The path to the local define in the CommandName section in the file
     * 
     * @param _0 The path to command name (Provided In/Externally)
     * @param _1 (Inherited from _0) The CommandName (Provided Externally)
     * @param _2 The path from CommandName to local defines as (Provided Internally)
     */
    public static String configLocalDefinesPath = "%0.%2";
    
    /***************************************
     * PERMISSIONS
     ***************************************/
    
    /**
     * The global permission root path
     * 
     * The origin of all permission nodes
     * 
     * @param _0 The global permission root path (Provided Internally)
     */
    public static String permGlobRootPath = "%0";
    
    /**
     * The permission root path
     * 
     * The path that is host to all CommandName permissions
     * 
     * @param _0 Global Permission Root Path (Provided Internally)
     * @param _1 Global Config Root Path (Provided Internally)
     */
    public static String permRootPath = "%0.%1";
    
    /**
     * The reload permission path
     * 
     * The path for the reload permission
     * 
     * @param _0 Global Permission Root (Provided Internally)
     * @param _1 Reload Command Name (Provided Internally)
     */
    public static String permReloadPath = "%0.%1";
    
    /**
     * The CommandName Permission Path
     * 
     * The permission path to CommandName
     * 
     * @param _0 The permission root (Provided Internally)
     * @param _1 The CommandName, will be replaced later (Provided Externally)
     */
    public static String permCmdNamePath = "%0.%1";
    
    /**
     * Initializes all the internally provided values
     * 
     * This method initializes all the internally provided values and leaves
     * untouched all the externally provided values. Not calling this method
     * means you must provide all internal and external values yourself.
     */
    public static void init()
    {   
        // These must be provided in a certain order
        
        // Begin loading simple msotly non-dependent values
        Config.spCmdWait = 
                Config.spCmdPrefix +
                Config.spCmdWait +
                Config.spCmdSuffix;
        
        Config.spVarPlayer = 
                Config.spCmdPrefix +
                Config.spVarPlayer +
                Config.spCmdSuffix;
        
        Config.varArg = 
                Config.spCmdPrefix +
                Config.varArg +
                Config.spCmdSuffix;
        
        Config.spVarDef = 
                Config.spCmdPrefix +
                Config.spVarDef +
                Config.spCmdSuffix;
        
        Config.errCmdWaitArg = 
                Config.errCmdWaitArg
                    .replace("%2", Long.toString(Config.cmdWaitArgDef));
        
        Config.permGlobRootPath =
                Config.permGlobRootPath
                    .replace("%0", "SudoAlias");
        
        Config.configRootPath =
                Config.configRootPath
                    .replace("%0", "aliases");
        
        // Depends on config root path which is setup by this point
        Config.configCmdNamePath =
                Config.configCmdNamePath
                    .replace("%0", Config.configRootPath);
        
        // Depends on config cmd name path which is setup by this point
        Config.configCmdPath = 
                Config.configCmdPath
                    .replace("%0", Config.configCmdNamePath)
                    .replace("%2", "command");
        
        Config.configRunCmdPath = 
                Config.configRunCmdPath
                    .replace("%0", Config.configCmdNamePath)
                    .replace("%2", "runCommand");
        
        Config.configDefinePath = 
                Config.configDefinePath
                    .replace("%0", "define");
        
        Config.configSuccMsgPath =
                Config.configSuccMsgPath
                    .replace("%0", Config.configCmdNamePath)
                    .replace("%2", "successMessage");
        
        Config.configRunAsPath =
                Config.configRunAsPath
                    .replace("%0", Config.configCmdNamePath)
                    .replace("%2", "runAs");
        
        Config.configStrictArgsPath =
                Config.configStrictArgsPath
                    .replace("%0", Config.configCmdNamePath)
                    .replace("%2", "strictArgs");
        
        Config.configLocalDefinesPath =
                Config.configLocalDefinesPath
                    .replace("%0", Config.configCmdNamePath)
                    .replace("%2", "define");
        
        // Depends on permGlobRootPath and configRootPath which is setup by this point
        Config.permRootPath =
                Config.permRootPath
                    .replace("%0", Config.permGlobRootPath)
                    .replace("%1", Config.configRootPath);
        
        // Depends on permGlobRootPath and cmdReload which is setup by this point
        Config.permReloadPath =
                Config.permReloadPath
                    .replace("%0", Config.permGlobRootPath)
                    .replace("%1", Config.cmdReload);
        
        // Depends on permGlobRootPath which is setup by this point
        Config.permCmdNamePath =
                Config.permCmdNamePath
                    .replace("%0", Config.permRootPath);
    }
}
