import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

import core.Action;
import core.Player;
import core.Traits;

import actions.GoToWork;
import actions.Rest;

public class DayCycle {
    private Player player;
    private int dayCount;
    private List<Action> actions;

    public DayCycle(Player player, int dayCount) {
        this.player = player;
        this.dayCount = dayCount;
        this.actions = new ArrayList<>();
        actions.add(new GoToWork());  // Lisää toiminto "Mene töihin"
        actions.add(new Rest());      // Lisää toiminto "Lepää"
    }

    public void startDay(int dayCount, double traitMultiplier) {
        printWithDelay("A new day begins! - " + dayCount);
        printWithDelay("You wake up feeling refreshed.");
        runTraits(traitMultiplier);
        printWithDelay(randomAction());
        printWithDelay(randomAction());

        printWithDelay("It's 9 am. What do you want to do today?");
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Go to work");
        System.out.println("2. Rest");
        int choice = scanner.nextInt() - 1;

        if (choice >= 0 && choice < actions.size()) {
            actions.get(choice).execute(player);
        } else {
            System.out.println("Invalid coice. Try again!");
        }
    }

    private void printWithDelay(String text) {
        try {
            System.out.println("\n" + text + "\n");
            Random random = new Random();
            int delay = 500 + random.nextInt(1500);
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            System.err.println("Error: " + e.getMessage());
            Thread.currentThread().interrupt();
        }
    }

        private String randomAction() {
        List<String> actions = Arrays.asList(
            "Chilling...",
            "Opening fridge...",
            "Searching internet...",
            "Watching TV...",
            "Stretching...."
        );

        Random random = new Random();
        String randomMessage = actions.get(random.nextInt(actions.size()));
        return randomMessage;  // Palautetaan satunnainen viesti
    }

    private void runTraits(double traitMultiplier) {
        try {
            List<String> traits = player.getTraits();
            Map<String, Integer> results = Traits.runTraits(traits, traitMultiplier);
            player.setMoney(player.getMoney() + results.get("money"));
            player.setHealth(player.getHealth() + results.get("health"));
            System.out.println("Money: " + player.getMoney());
            System.out.println("Health: " + player.getHealth());
    
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.err.println("Error: " + e.getMessage());
            Thread.currentThread().interrupt();
        }
    }

}
