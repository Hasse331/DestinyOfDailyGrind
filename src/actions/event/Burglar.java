package actions.event;

import actions.Action;
import core.InputManager;
import core.Player;
import java.util.Random;

public class Burglar extends Action {
    private final Random random = new Random();

    public Burglar() {
        super("A burglar sneaks into your house!");
    }

    @Override
    public void execute(Player player) {
        System.out.println(description);
        System.out.println("What do you want to do?");
        System.out.println("1. Confront the burglar.");
        System.out.println("2. Hide and call the police.");

        int choice = InputManager.getScanner().nextInt();

        if (choice == 1) {
            System.out.println(player.getName() + " bravely confronts the burglar!");
            if (random.nextDouble() < 0.5) {
                System.out.println("You managed to scare the burglar away!");
            } else {
                System.out.println("The burglar fought back and you lost some health!");
                player.setHealth(player.getHealth() - 30);
                System.out.println("You lost 30 health!");
            }
        } else if (choice == 2) {
            System.out.println("You hide and call the police...");
            System.out.println("The police arrived just in time and caught the burglar.");
            System.out.println("You feel safe, but the adrenaline made you lose some energy.");
            player.setHealth(player.getHealth() - 10);
        } else {
            System.out.println("Invalid choice. The burglar took everything while you hesitated!");
            player.setMoney(player.getMoney() - 200);
            System.out.println("You lost 200 coins!");
        }
    }
}
