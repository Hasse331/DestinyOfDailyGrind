package actions;

import core.Action;
import core.Player;

public class Party extends Action {
    public Party() {
        super("Go to party");
    };

    @Override
    public void execute(Player player) {
        player.setMoney(player.getMoney() - 50);
        player.setHealth(player.getHealth() - 25);
        System.out.println(player.getName() + " went to party for whole night.  -50 money., -25 health.");
        System.out.println("Money now: " + player.getMoney());
        System.out.println("Health now: " + player.getHealth());
        nextDay(player);
    }
}

    
