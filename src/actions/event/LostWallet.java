package actions.event;

import actions.Action;
import core.InputManager;
import core.Player;
import java.util.Random;

public class LostWallet extends Action {
    private final Random random = new Random();

    public LostWallet() {
        super("You partied too hard and might have lost something...");
    }

    @Override
    public void execute(Player player) {
        System.out.println(description);
        System.out.println("What do you want to do?");
        System.out.println("1. Search for your wallet.");
        System.out.println("2. Just go home and sleep.");

        int choice = InputManager.getScanner().nextInt();

        if (choice == 1) {
            if (random.nextDouble() < 0.4) {
                System.out.println("Lucky you! You found your wallet with all the money inside!");
            } else {
                System.out.println("No luck! Your wallet is gone...");
                player.setMoney(player.getMoney() - 50);
                System.out.println(player.getName() + " lost 50 coins!");
            }
        } else if (choice == 2) {
            System.out.println("You chose to let it go and sleep it off. At least you feel rested.");
            player.setHealth(player.getHealth() + 10);
            player.setMoney(player.getMoney() - 50);
            System.out.println(player.getName() + " gained 10 health.");
            System.out.println(player.getName() + " lost 50 coins!");
        } else {
            System.out.println("Invalid choice. You wandered aimlessly and lost track of time.");
            player.setHealth(player.getHealth() - 5);
        }
    }
}
