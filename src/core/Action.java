package core;

import java.util.Random;

public abstract class Action {
    protected String description;

    public Action(String description) {
        this.description = description;
    }

    public abstract void execute(Player palyer);

    public void nextDay(Player player) {
        player.setDayCount(player.getDayCount() + 1);

        Random random = new Random();
        if (random.nextDouble(1) < 1) {
            player.addNewTrait();
            System.out.println(player.getName() + " got new trait");
            System.out.println("TRAITS: " + player.getTraits());
        }
        DayCycle dayCycle = new DayCycle(player);
        dayCycle.startDay();
    }

    public String getDescription() {
        return description;
    }
}