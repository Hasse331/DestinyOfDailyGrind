package core;
import java.util.Random;
import java.util.Scanner;

// Utility calss for running random events
// Instence can not be made
public class EventManager {
    private static Random random;

    static {
        random = new Random();
        Scanner scanner = InputManager.getScanner();
    }

    private EventManager() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated.");
    }

    public static void triggerRestEvent(Player player) {
        double eventPropability = random.nextDouble(1);
        if (eventPropability < 0.2) {
            // Run event
        }
    }
    public static void triggerWorkEvent(Player player) {

    }
    public static void triggerPartyEvent(Player player) {

    }
    public static void triggerSleepEvent(Player player) {

    }
}
