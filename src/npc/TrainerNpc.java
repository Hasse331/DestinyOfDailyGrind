package npc;

import java.util.Scanner;

import core.DayCycle;
import core.InputManager;
import core.Player;

public class TrainerNpc extends Npc {
    private static TrainerNpc instance;

    public TrainerNpc(String npcName, double statMultiplier) {
        super(npcName, statMultiplier, "companion");
    }

    // Singleton object -> so it can be costructed only once
    public static TrainerNpc getInstance() {
        if (instance == null) {
            instance = new TrainerNpc("John the Trainer", 1.2);
        }
        return instance;
    }

    public void train(Player player) {
        DayCycle.printWithDelay("Running...");
        DayCycle.printWithDelay("Running...");
        DayCycle.printWithDelay("Lifting weights...");
        DayCycle.printWithDelay("Lifting weights...");
        DayCycle.printWithDelay("Doing pushups...");
        System.out.println("---- WORKOUT COMPLETED ----");
        int increase = (int) (10 * getStatMultiplier());
        player.setStrength(player.getStrength() + increase);
        System.out.println(getName() + ": Your strength has increased by " + increase + " points!");
    }

    @Override
    public void conversation(Player player) {
        // TODO move to event maybe? and something more general here?
        System.out.println(getName() + ": Hello " + player.getName() + " it's your workout time! Did you forget?");
        

        System.out.println("1. I'm ready, let's workout!");
        System.out.println("2. Ohh, I'm sorry, not today");

        Scanner scanner = InputManager.getScanner();
        int choice = scanner.nextInt() - 1;
        if (choice == 0) {
            System.out.println("Okay, let's begin!");
            train(player);
        } else {
            System.out.println("[" + getName() + " is very dissapointed" + "]");
            System.out.println(getName() + ": Okay then " + player.getName() + ", you lazy bitch. See you next time!");
            System.out.println("[slamming the door]");
        }
        
        InputManager.continueInputDouble();
    }
}
