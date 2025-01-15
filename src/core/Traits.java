package core;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.HashMap;
import java.util.Map;

// Utility calss for player traits and running those
// Instence can not be made
public class Traits {
    private static final List<String> ALL_TRAITS = Arrays.asList("Alcoholist", "Drug addict", "Psycopath", "Sick", "Nerd", "Body builder");
    private static List<String> ALL_ALCOHOL = Arrays.asList("Beer", "Vodka", "Gin", "Homemade brew", "Whisky", "Vodka mixer");
    private static int health;
    private static int money;

    private Traits() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated.");
    }

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
                case "Alcoholist": {
                    String alcohol = getTraitItem(ALL_ALCOHOL);
                    System.out.println("TRAIT: Alcoholist - drinking " + alcohol + "...");
                    final double hChange = 20 * multiplier;
                    final double mChange = 30 * multiplier;
                    health -= hChange;
                    money -= mChange;
                    System.out.println("health -" + hChange + ", money -" + mChange);
                    break;
                }
                case "Drug addict": {
                    System.out.println("TRAIT: Drug addict - you go to streets buying drugs and use them");
                    final double hChange = 30 * multiplier;
                    final double mChange = 50 * multiplier;
                    health -= hChange;
                    money -= mChange;
                    System.out.println("health -" + hChange + ", money -" + mChange);
                    break;
                }
                case "Psycopath": {
                    System.out.println("TRAIT: Psycopath - manipulating others to make money");
                    final double mChange = 20 * multiplier;
                    money += mChange;
                    System.out.println("money +" + mChange);
                    break;
                }
                case "Sick": {
                    System.out.println("TRAIT: Sick - *cough* *cough*... feeling sick");
                    final double hChange = 40 * multiplier;
                    health -= hChange;
                    System.out.println("health -" + hChange);
                    break; 
                }
                case "Nerd": {
                    System.out.println("TRAIT: Nerd - reading books");
                    final double hChange = 10 * multiplier;
                    final double mChange = 20 * multiplier;
                    health += hChange;
                    money += mChange;
                    System.out.println("health +" + hChange + ", money: +" + mChange);
                    break;
                }
                case "Body builder": {
                    System.out.println("TRAIT: Body builder - going to gym...");
                    final double hChange = 10 * multiplier;
                    health += hChange;
                    System.out.println("health +" + hChange);
                    break;
                }
            }
        }

        Map<String, Integer> traitResult = new HashMap<>();
        traitResult.put("health", health);
        traitResult.put("money", money);

        return traitResult;
    }
}
