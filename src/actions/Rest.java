package actions;

import core.DayCycle;
import core.EventManager;
import core.Player;


public class Rest extends Action {
    public Rest() {
        super("Rest");
    }

    @Override
    public void execute(Player player) {
        System.out.println(player.getName() + " chooses to rest today");
        DayCycle.printWithDelay("Resting: " + DayCycle.randomAction());
        DayCycle.printWithDelay("Resting: " + DayCycle.randomAction());
        DayCycle.printWithDelay("Resting: " + DayCycle.randomAction());
        EventManager.triggerRestEvent(player);
        DayCycle.printWithDelay("Resting: " + DayCycle.randomAction());
        DayCycle.printWithDelay("Resting: " + DayCycle.randomAction());
        player.setHealth(player.getHealth() + 20);
        System.out.println(player.getName() + " rested and regained 20 health.");
        System.out.println("Health now: " + player.getHealth());
    }
}
