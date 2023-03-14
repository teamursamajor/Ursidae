package frc.ursa.ursidae;

import edu.wpi.first.wpilibj2.command.Command;
import frc.ursa.ursidae.command.CommandUtilities;
/**
 * Logging utilities
 */
public class Logger {
    /**
     * Shortcut for System.err.println(message)
     * @param message Message to print
     */
    public static void log(String message) {
        System.err.println(message);
    }

    /**
     * Logs data with given label
     * @param label Label for data
     * @param info Object to be attatched
     */
    public static void log(String label, Object info) {
        System.err.printf("%s: %s\n", label, info.toString());
    }

    /**
     * Prints the command lifecycle state as such:
     * ExampleCommand: State
     * @param c Command to print
     */
    public static void log(Command c) {
        System.err.printf("%s: %s\n", c.getName(), CommandUtilities.getState(c));
    }
}