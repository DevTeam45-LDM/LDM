package com.devteam45ldm.ldm.parser.types;

/**
 * Contains common methods used by the parser classes.
 */
public class CommonMethods {
    /**
     * Removes empty lines from a string.
     * @param data the string to remove empty lines from
     * @return the string with empty lines removed
     */
    public static String skipEmptyLines(String data) {
        return data.replaceAll("(?m)^\\s*$[\n\r]+", "");
    }
}
