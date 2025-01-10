import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.HashMap;
import java.util.Map;

public class Traits {
    private static final List<String> ALL_TRAITS = Arrays.asList("Alcoholist", "Drug addict", "Psycopath", "Sick");

    private static List<String> ALL_ALCOHOL = Arrays.asList("Beer, Vodka, Gin, Homemade brew, ");

    public static String getRandomTrait() {
        Random random = new Random();
        return ALL_TRAITS.get(random.nextInt(ALL_TRAITS.size()));
    }

    public static String getTraitItem(List<String> list) {
        Random random = new Random();
        return list.get(random.nextInt(list.size()));
    }

    public Map<String, String> getTraitModifiers(List<String> traits, int multiplier) {

        for (String trait : traits) {
            switch (trait) {
                case "Alcoholist":
                    String alcohol = getTraitItem(ALL_ALCOHOL);
                    System.out.println("Trait: Alcoholist - drinking" + alcohol + "...");
                    break;
                case "Drug addict":
                    System.out.println("Trait: Drug addict - buying drugs -100, using them -10 health");
                    break;
                case "Psycopath":
                    System.out.println("Trait: Psycopath - Make more money by manipulating +100");
                    break;
                case "Sick":
                    System.out.println("Trait: Sick - lose 10 health");
                    break;
            }
        }

        return modifiers;
    }
}
