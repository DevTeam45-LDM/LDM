package com.devteam45ldm.ldm.parser.types;

/**
 * Contains common methods used by the parser classes.
 */
public abstract class CommonMethods {
    /**
     * Removes empty lines from a string.
     * @param data the string to remove empty lines from
     * @return the string with empty lines removed
     */
    public static String skipEmptyLines(String data) {
        return data.replaceAll("(?m)^\\s*$[\n\r]+", "");
    }

    /**
     * Skips a specified number of lines in a string after removing empty lines.
     * @param data the string to skip lines in
     * @param skipLines the number of lines to skip
     * @return the string with the specified number of lines skipped
     */
    public static String skipLines(String data, Integer skipLines) {
        // Remove all empty lines
        data = skipEmptyLines(data);
        //Skip Lines if needed
        if(skipLines != null && skipLines > 0) {
            for(int i = 0; i < skipLines; i++) {
                data = data.substring(data.indexOf("\n") + 1);
            }
        }
        return data;
    }
}