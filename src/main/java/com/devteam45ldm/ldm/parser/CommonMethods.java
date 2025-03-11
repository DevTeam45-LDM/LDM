package com.devteam45ldm.ldm.parser;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Contains common methods used within the parser package.
 */
public abstract class CommonMethods {
    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

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

    /**
     * Gets the current user from Spring Security context
     *
     * @return the current authenticated user's name, or "anonymous" if not authenticated
     */
    public static String getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            return authentication.getName();
        }
        return "anonymous";
    }

    /**
     * Gets the current timestamp in the required format
     *
     * @return the current timestamp
     */
    public static String getCurrentTimestamp() {
        return LocalDateTime.now().format(DATE_FORMATTER);
    }
}