package actions;

import core.Action;
import core.Player;

public class GoToWork extends Action {
    public GoToWork() {
        super("Go to work");
    }

    @Override
    public void execute(Player player) {
        player.setMoney(player.getMoney() + 100);
        player.setHealth(player.getHealth() - 20);
        System.out.println(player.getName() + " went to work and earned 100 money. 20 health lost.");
        System.out.println("Money now: " + player.getMoney());
        System.out.println("Health now: " + player.getHealth());
    }
}
