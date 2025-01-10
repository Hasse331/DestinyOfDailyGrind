import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.HashMap;
import java.util.Map;

public class Traits {
    private static final List<String> ALL_TRAITS = Arrays.asList("Alcoholist", "Drug addict", "Psycopath", "Sick", "Nerd", "Body builder");
    private static List<String> ALL_ALCOHOL = Arrays.asList("Beer", "Vodka", "Gin", "Homemade brew", "Whisky", "Vodka mixer");
    private static int health;
    private static int money;

    public static String getRandomTrait() {
        Random random = new Random();
        return ALL_TRAITS.get(random.nextInt(ALL_TRAITS.size()));
    }

    private static String getTraitItem(List<String> list) {
        Random random = new Random();
        return list.get(random.nextInt(list.size()));
    }


    public static Map<String, Integer> runTraits(List<String> traits, double multiplier) {

        for (String trait : traits) {
            switch (trait) {
                case "Alcoholist":
                    String alcohol = getTraitItem(ALL_ALCOHOL);
                    System.out.println("Trait: Alcoholist - drinking " + alcohol + "...");
                    health -= 5 * multiplier;
                    money -= 30 * multiplier;
                    System.out.println("health: " + health + ", money: " + money);
                    break;
                case "Drug addict":
                    System.out.println("Trait: Drug addict - you go to streets buying drugs and use them");
                    health -= 10 * multiplier;
                    money -= 50 * multiplier;
                    System.out.println("health: " + health + ", money: " + money);
                    break;
                case "Psycopath":
                    System.out.println("Trait: Psycopath - manipulating others to make money");
                    money += 100 * multiplier;
                    System.out.println("money: +" + money);
                    break;
                case "Sick":
                    System.out.println("Trait: Sick - *cough* *cough*... feeling sick");
                    health -= 20 * multiplier;
                    System.out.println("health: " + health);
                    break;
                case "Nerd":
                    System.out.println("Trait: Nerd - reading books");
                    health += 5 * multiplier;
                    money += 50 * multiplier;
                    System.out.println("health: +" + health + ", money: +" + money);
                    break;
                case "Body builder":
                    System.out.println("Trait: Body builder - going to gym...");
                    health += 5 * multiplier;
                    System.out.println("health: +" + health);
                    break;
            }
        }

        Map<String, Integer> traitResult = new HashMap<>();
        traitResult.put("health", health);
        traitResult.put("money", money);

        return traitResult;
    }
}
