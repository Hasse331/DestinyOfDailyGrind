package actions;

import java.util.Scanner;

import core.DayCycle;
import core.EventManager;
import core.InputManager;
import core.Player;

public class Party extends Action {
    public Party() {
        super("Go to party");
    };

    @Override
    public void execute(Player player) {
        System.out.println(player.getName() + " goes to party hard");
        DayCycle.printWithDelay("Drinking beer...");
        DayCycle.printWithDelay("Chatting...");
        DayCycle.printWithDelay("Raving...");
        DayCycle.printWithDelay("Taking shots...");
        DayCycle.printWithDelay("Chug, chug, chug... Oops, that's someone else's drink!");
        DayCycle.printWithDelay("Partying...");
        EventManager.triggerPartyEvent(player);
        player.setMoney(player.getMoney() - 50);
        player.setHealth(player.getHealth() - 25);
        System.out.println(player.getName() + " went to party for whole night.  -50 money., -25 health.");
        System.out.println("Money now: " + player.getMoney());
        System.out.println("Health now: " + player.getHealth());
        Scanner scanner = InputManager.getScanner();
        System.out.println("Press ENTER to start new day");
        scanner.nextLine();
        DayCycle.printWithDelay("You wake up with headache and feeling exhausted.");
        nextDay(player);
    }
}

    
