import java.util.Scanner;

import core.DayCycle;
import core.InputManager;
import core.Player;

public class Main {
    public static void main(String[] args) {
        System.out.println("\n\n------ Destiny of Daily Grind -----");
        System.out.println("## The best Java CLI game in the world ##");
        System.out.println("## Winner of the game of the year awards 2226 ##");
        System.out.println("\n\nPress ENTER to start a new game...");
    
        Scanner scanner = InputManager.getScanner();
        scanner.nextLine();
        startNewGame();
    }

    public static void startNewGame() {
        System.out.println("Starting new game...");

        Scanner scanner = InputManager.getScanner();
        System.out.println("Enter your player name: ");
        String input = scanner.nextLine();
        Player player = new Player(input);
        
        System.out.println("\nCreating player...\n");
        System.out.println("Welcome! New game has been started " + player.getName() + ", here is your character starting stats: ");
        System.out.println("\n-----------------------------\n");
        System.out.println("Player name: " + player.getName());
        System.out.println("Day: " + player.getDayCount());
        System.out.println("Health: " + player.getHealth());
        System.out.println("Money: " + player.getMoney());
        System.out.println("Traits: " + player.getTraits());
        System.out.println("trait Multiplier: " + player.getTraitMultiplier());
        System.out.println("\n-----------------------------\n");

        System.out.println("\n\nPress ENTER to start your first day...");
        scanner.nextLine();
        DayCycle dayCycle = new DayCycle(player);
        DayCycle.printWithDelay("You wake up feeling refreshed.");
        dayCycle.startDay();
    }
}