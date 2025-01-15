package actions.event;

import java.util.Random;

import actions.Action;
import core.InputManager;
import core.Player;

public class Promotion extends Action {
    public Promotion() {
        super("Something exciting happened at work!");
    }

    @Override
    public void execute(Player player) {
        System.out.println(description);
        System.out.println("Your manager calls you to their office. What do you do?");
        System.out.println("1. Go confidently and ask for a raise.");
        System.out.println("2. Stay cautious and let your manager speak.");

        int choice = InputManager.getScanner().nextInt();

        if (choice == 1) {
            System.out.println(player.getName() + " boldly asked for a raise!");
            if (new Random().nextDouble() < 0.5) {
                System.out.println("Your manager is impressed and gives you a promotion! +300 coins!");
                player.setMoney(player.getMoney() + 300);
            } else {
                System.out.println("Your manager says it's not the right time. You gained respect but no money.");
            }
        } else if (choice == 2) {
            System.out.println("You played it safe and listened carefully...");
            System.out.println("Your manager was about to give you a raise anyway! You earned +200 coins!");
            player.setMoney(player.getMoney() + 200);
        } else {
            System.out.println("Invalid choice. You panicked and said something awkward. -20 health.");
            player.setHealth(player.getHealth() - 20);
        }
    }
}
