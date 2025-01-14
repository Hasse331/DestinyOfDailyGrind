package core;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

import actions.GoToWork;
import actions.Rest;
import actions.Party;
import actions.Sleep;


public class DayCycle {
    private Player player;
    private List<Action> actions;

    public DayCycle(Player player) {
        this.player = player;
        this.actions = new ArrayList<>();
        actions.add(new GoToWork());
        actions.add(new Rest());
        actions.add(new Party());
        actions.add(new Sleep());
    }

    public void startDay() {
        printWithDelay("A new day begins! - Day: " + player.getDayCount());
        printWithDelay("You wake up feeling refreshed.");
        runTraits();
        printWithDelay(randomAction());
        printWithDelay(randomAction());

        printWithDelay("It's 9 am. What do you want to do today?");
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Go to work");
        System.out.println("2. Rest");
        int choice = scanner.nextInt() - 1;
        if (choice >= 0 && choice <= 1) {
            actions.get(choice).execute(player);
        } else {
            System.out.println("Invalid coice. Be careful!");
        }

        printWithDelay(randomAction());
        printWithDelay(randomAction());
        printWithDelay(randomAction());

        printWithDelay("It's 9 pm now. What do you want to do?");
        System.out.println("3. Go party");
        System.out.println("4. Go to sleep");
        choice = scanner.nextInt() - 1;
        if (choice >= 2 && choice < actions.size()) {
            actions.get(choice).execute(player);
        } else {
            System.out.println("Invalid coice. Game over!");
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

    private void runTraits() {
        try {
            List<String> traits = player.getTraits();
            Map<String, Integer> results = Traits.runTraits(traits, player.getTraitMultiplier());
            player.setMoney(player.getMoney() + results.get("money"));
            player.setHealth(player.getHealth() + results.get("health"));
            System.out.println("Health now: " + player.getHealth());
            System.out.println("Money now: " + player.getMoney());
    
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.err.println("Error: " + e.getMessage());
            Thread.currentThread().interrupt();
        }
    }

}
