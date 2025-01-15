package core;
import java.util.List;
import java.util.Random;

import actions.Action;
import actions.event.Burglar;
import actions.event.LostWallet;
import actions.event.Promotion;

// Utility calss for running random events
// Instence can not be made
public class EventManager {
    private static Random random;

    static {
        random = new Random();
    }

    private EventManager() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated.");
    }

    public static void triggerRestEvent(Player player) {
        double eventPropability = random.nextDouble();
        
        if (eventPropability < 0.20) {
            List<Action> events = List.of(new Burglar());

            int eventIndex = random.nextInt(events.size());
            events.get(eventIndex).execute(player);
            InputManager.continueInputDouble();
        }
    }
    public static void triggerWorkEvent(Player player) {
        double eventPropability = random.nextDouble();
        
        if (eventPropability < 0.20) {
            List<Action> events = List.of(new Promotion());

            int eventIndex = random.nextInt(events.size());
            events.get(eventIndex).execute(player);
            InputManager.continueInputDouble();
        }
    }
    public static void triggerPartyEvent(Player player) {
        double eventPropability = random.nextDouble();
        
        if (eventPropability < 0.20) {
            List<Action> events = List.of(new LostWallet());

            int eventIndex = random.nextInt(events.size());
            events.get(eventIndex).execute(player);
            InputManager.continueInputDouble();
        }
    }
    public static void triggerSleepEvent(Player player) {
        double eventPropability = random.nextDouble();
        
        if (eventPropability < 0.20) {
            List<Action> events = List.of(new Burglar());

            int eventIndex = random.nextInt(events.size());
            events.get(eventIndex).execute(player);
            InputManager.continueInputDouble();
        }
    }
}
