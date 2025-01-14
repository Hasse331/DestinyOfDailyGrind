package actions;

import core.Action;
import core.Player;

public class Sleep extends Action {
        public Sleep() {
        super("Go to sleep");
    };

    @Override
    public void execute(Player player) {
        player.setHealth(player.getHealth() + 25);
        System.out.println(player.getName() + " decided to go to sleep. Gained +20 health!");
        System.out.println("Health now: " + player.getHealth());
        nextDay(player);
    }
}
