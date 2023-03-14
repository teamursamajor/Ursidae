package frc.ursa.ursidae;

import edu.wpi.first.wpilibj2.command.Command;
import frc.ursa.ursidae.command.CommandUtilities;

public class Logger {
    public static void log(String label, Object info) {
        System.err.printf("%s: %s\n", label, info.toString());
    }

    public static void log(Command c) {
        System.err.printf(
            "%s State:\n" +
            "\tInitialize: %s\n" +
            "\tExecute: %s\n" +
            "\tEnd: %s\n",
            c.getName(),
            CommandUtilities.isInitializing(c),
            CommandUtilities.isExecuting(c),
            CommandUtilities.isEnding(c)
        );
    }
}