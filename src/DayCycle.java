import java.util.List;
import java.util.Map;

public class DayCycle {
    private Player player;
    private int dayCount;

    public DayCycle(Player player, int dayCount) {
        this.player = player;
        this.dayCount = dayCount;
    }


    public void startDay(int dayCount, double traitMultiplier) {
        System.out.println("Day: " + dayCount);
        System.out.println("A new day begins!");
        System.out.println("You wake up feeling refreshed.");
        List<String> traits = player.getTraits();
        Map<String, Integer> results = Traits.runTraits(traits, traitMultiplier);
        player.setMoney(player.getMoney() + results.get("money"));
        player.setMoney(player.getHealth() + results.get("Health"));
        System.out.println("What do you want to do today?");
        System.out.println("1. Go to work");
        System.out.println("2. Train");
        System.out.println("3. Rest");
    }
}
