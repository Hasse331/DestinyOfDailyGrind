package actions;

import java.util.Random;

import core.DayCycle;
import core.InputManager;
import core.Player;

public abstract class Action {
    protected String description;

    public Action(String description) {
        this.description = description;
    }

    public abstract void execute(Player palyer);

    public void nextDay(Player player) {
        player.setDayCount(player.getDayCount() + 1);

            Random random = new Random();
            if (random.nextDouble(1) < 0.5) {
                player.addNewTrait();
                System.out.println(player.getName() + " got new trait:");
                System.out.println("TRAITS: " + player.getTraits());
                InputManager.continueInput();
            }

        player.setTraitMultiplier(1.5);
        System.out.println("New trait multiplier: " + player.getTraitMultiplier());
        DayCycle dayCycle = new DayCycle(player);
        dayCycle.startDay();
    }

    public String getDescription() {
        return description;
    }
}