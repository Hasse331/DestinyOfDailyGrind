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
        System.out.println(player.getName() + " went to work and earned 100 money.");
    }
}
