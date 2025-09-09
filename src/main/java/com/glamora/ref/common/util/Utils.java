package com.glamora.ref.common.util;

import java.security.SecureRandom;
import java.util.UUID;

public final class Utils {

    private static final SecureRandom RANDOM = new SecureRandom();

    private Utils() {
        // Prevent instantiation
    }

    /**
     * Generate a booking code with timestamp + random 4-digit suffix.
     * Example: BK-1693748392012-4821
     */
    public static String genBookingCode() {
        return "BK-" + System.currentTimeMillis() + "-" + (1000 + RANDOM.nextInt(9000));
    }

    /**
     * Generate a standard UUID string with dashes.
     */
    public static String genUUID() {
        return UUID.randomUUID().toString();
    }

    /**
     * Generate a UUID without dashes (compact).
     */
    public static String genCompactUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    /**
     * Check if string is null or blank (whitespace only).
     */
    public static boolean isBlank(String s) {
        return s == null || s.trim().isEmpty();
    }

    /**
     * Check if string is NOT blank.
     */
    public static boolean isNotBlank(String s) {
        return !isBlank(s);
    }
}
