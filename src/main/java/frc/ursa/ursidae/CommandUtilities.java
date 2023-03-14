package frc.ursa.ursidae;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

import java.util.HashMap;

/**
 * Utilities used by commands and to deal with commands
 */
public class CommandUtilities {
    private static HashMap<Command, String> commandStates = new HashMap<>();

    static {
        CommandScheduler cs = CommandScheduler.getInstance();
        cs.onCommandInitialize((c) -> {
            commandStates.put(c, "Initialize");
        });
        cs.onCommandExecute((c) -> {
            commandStates.put(c, "Execute");
        });
        cs.onCommandFinish((c) -> {
            commandStates.put(c, "Finish");
        });
    }

    /**
     * Get current state of command lifecycle
     * @param c Command to check
     * @return Current state as String (Unscheduled, Initialize, Execute, Finish)
     */
    public static String getState(Command c) {
        if (!commandStates.containsKey(c)) {
            commandStates.put(c, "Unscheduled");
        }
        return commandStates.get(c);
    }
}
