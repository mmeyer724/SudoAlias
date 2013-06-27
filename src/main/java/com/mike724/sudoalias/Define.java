package com.mike724.sudoalias;

import java.util.logging.Level;

/**
 * Holds a single define
 * 
 * @author wiseguy12851
 */
public class Define {
    
    /**
     * The define key
     */
    public String key;
    
    /**
     * The define value
     */
    public String value;
    
    /**
     * Constructor
     * 
     * @param key The key
     * @param value The value
     */
    public Define(String key, String value)
    {
        // Set key and value both trimmed
        this.key = key.trim();
        this.value = value.trim();
    }
}
