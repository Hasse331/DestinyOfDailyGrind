package core;
import java.util.List;

import actions.Action;
import actions.event.Burglar;
import actions.event.LostWallet;
import actions.event.Promotion;

// Utility calss for running random events
// Instence can not be made
public class EventManager {

    private EventManager() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated.");
    }

    public static void triggerRestEvent(Player player) {
        if (InputManager.getRandomDouble() < 0.10) {
            List<Action> events = List.of(new Burglar());

            events.get(InputManager.getRandomInt(events.size())).execute(player);
            InputManager.continueInputDouble();
        }
    }

    public static void triggerWorkEvent(Player player) {
        
        if (InputManager.getRandomDouble() < 0.10) {
            List<Action> events = List.of(new Promotion());

            events.get(InputManager.getRandomInt(events.size())).execute(player);
            InputManager.continueInputDouble();
        }
    }

    public static void triggerPartyEvent(Player player) {
        
        if (InputManager.getRandomDouble() < 0.1) {
            List<Action> events = List.of(new LostWallet());

            events.get(InputManager.getRandomInt(events.size())).execute(player);
            InputManager.continueInputDouble();
        }
    }

    public static void triggerSleepEvent(Player player) {
        
        if (InputManager.getRandomDouble()  < 0.1) {
            List<Action> events = List.of(new Burglar());

            events.get(InputManager.getRandomInt(events.size())).execute(player);
           InputManager.continueInputDouble();
        }
    }

    public static void triggerDebtEvent() {
        // TODO: make triggerDebtEvent()
    }
}
