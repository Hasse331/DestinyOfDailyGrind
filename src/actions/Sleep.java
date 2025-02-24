package actions;

import core.DayCycle;
import core.EventManager;
import core.InputManager;
import core.Player;

public class Sleep extends Action {
        public Sleep() {
        super("Go to sleep");
    };

    @Override
    public void execute(Player player) {
        System.out.println(player.getName() + " goes to sleep.");
        DayCycle.printWithDelay("Snoring...");
        DayCycle.printWithDelay("Turning over in bed...");
        DayCycle.printWithDelay("Mumbling in sleep...");
        EventManager.triggerSleepEvent(player);  // Käynnistää satunnaisen unijakson tapahtuman
        DayCycle.printWithDelay("Dreaming...");
        DayCycle.printWithDelay("Sunlight starts to peek through the window...");
        player.setHealth(player.getHealth() + 25);
        System.out.println(player.getName() + " decided to go to sleep. Gained +20 health!");
        System.out.println("Health now: " + player.getHealth());
        InputManager.continueInputDouble();
        DayCycle.printWithDelay("You wake up feeling refreshed.");
        nextDay(player);
    }
}
