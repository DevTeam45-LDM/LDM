package com.devteam45ldm.ldm;

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