package frc.ursa.ursidae.command;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

import java.util.HashMap;

public class CommandUtilities {
    private static HashMap<Command, HashMap<String, Boolean>> commandStates = new HashMap<>();

    static {
        CommandScheduler cs = CommandScheduler.getInstance();
        cs.onCommandInitialize((c) -> {
            if (!commandStates.containsKey(c)) {
                createEntry(c);
            }
            HashMap<String, Boolean> states = commandStates.get(c);
            states.put("Initialize", true);
            states.put("Execute", false);
            states.put("End", false);
        });
        cs.onCommandExecute((c) -> {
            if (!commandStates.containsKey(c)) {
                createEntry(c);
            }
            HashMap<String, Boolean> states = commandStates.get(c);
            states.put("Initialize", false);
            states.put("Execute", true);
            states.put("End", false);
        });
        cs.onCommandFinish((c) -> {
            if (!commandStates.containsKey(c)) {
                createEntry(c);
            }
            HashMap<String, Boolean> states = commandStates.get(c);
            states.put("Initialize", false);
            states.put("Execute", false);
            states.put("End", true);
        });
    }

    private static void createEntry(Command c) {
        commandStates.put(c, new HashMap<String, Boolean>() {{
            put("Initialize", false);
            put("Execute", false);
            put("End", false);
        }});
    }

    public static boolean isInitializing(Command c) {
        if (!commandStates.containsKey(c)) {
            createEntry(c);
        }
        return commandStates.get(c).get("Initialize");
    }
    
    public static boolean isExecuting(Command c) {
        if (!commandStates.containsKey(c)) {
            createEntry(c);
        }
        return commandStates.get(c).get("Execute");
    }

    public static boolean isEnding(Command c) {
        if (!commandStates.containsKey(c)) {
            createEntry(c);
        }
        return commandStates.get(c).get("End");
    }
}
