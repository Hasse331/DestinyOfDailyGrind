package actions;


import core.DayCycle;
import core.EventManager;
import core.Player;

public class GoToWork extends Action {
    public GoToWork() {
        super("Go to work");
    }

    @Override
    public void execute(Player player) {
        System.out.println(player.getName() + " goes to work");
        DayCycle.printWithDelay("Working...");
        DayCycle.printWithDelay("Brewing coffee...");
        DayCycle.printWithDelay("Drinking coffee...");
        DayCycle.printWithDelay("Working...");
        EventManager.triggerWorkEvent(player);
        DayCycle.printWithDelay("Working...");
        DayCycle.printWithDelay(DayCycle.randomAction());
        DayCycle.printWithDelay("Drinking coffee...");
        DayCycle.printWithDelay("Working...");
        DayCycle.printWithDelay("Working...");
        player.setMoney(player.getMoney() + 100);
        player.setHealth(player.getHealth() - 20);
        System.out.println(player.getName() + " went to work and earned 100 money. 20 health lost.");
        System.out.println("Money now: " + player.getMoney());
        System.out.println("Health now: " + player.getHealth());
        DayCycle.printWithDelay("Going to home...");
    }
}
