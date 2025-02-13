
package edu.canisius.csc213.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/**
 * SysDebugger - A utility class with static methods to gather
 * system diagnostics (e.g., process list) after errors.
 */

public class SysDebugger {

    // The new method to log the current date and time
    public static void logCurrentDateTime() {
        // Get the current date and time with nanosecond precision
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSSS");
        // Print the formatted date and time as required
        System.out.println("=== Current Date & Time ===");
        System.out.println(currentDateTime.format(formatter));  // Prints the ISO 8601 format (e.g., 2025-02-05T10:44:01.809074)
        System.out.println("===========================");
	}
    /**
     * Logs the currently running processes (Linux/macOS example).
     * On Windows, adjust to "tasklist" or similar.
     */
    public static void logRunningProcesses() {
        System.out.println("=== Process List Dump ===");
        try {
            // Using "ps -e" for demonstration (Linux/macOS).
            // On Windows, you might do: ProcessBuilder pb = new ProcessBuilder("tasklist");
            ProcessBuilder pb = new ProcessBuilder("ps", "-e");
            Process process = pb.start();
                        try (BufferedReader br = new BufferedReader(
                     new InputStreamReader(process.getInputStream()))) {
                String line;
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                }
            }
            System.out.println("=== End of Process List ===");
        } catch (IOException e) {
            System.err.println("[SysDebugger] Could not retrieve process list: " + e.getMessage());



        }
 

   }

}

