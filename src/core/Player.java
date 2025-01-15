package core;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Player {
    private String name;
    private int health;
    private int money;
    private List<String> traits;
    private int dayCount;
    double traitMultiplier;

    public Player(String name) {
        this.name = name;
        this.health = 100;
        this.money = 100;
        this.traits = new ArrayList<>(Arrays.asList(Traits.getRandomTrait()));
        this.dayCount = 1;
        this.traitMultiplier = 0.5;
    }

    // Getter-metodit (lukemista varten)
    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getMoney() {
        return money;
    }

    public List<String> getTraits() {
        return traits;
    }

    public int getDayCount() {
        return dayCount;
    }
    public double getTraitMultiplier() {
        return traitMultiplier;
    }

    // Setter-metodit (muokkaamista varten)
    public void setHealth(int health) {
        this.health = health;
    }

    public void setMoney(int money) {
        this.money = money;
    }
    public void setDayCount(int day) {
        this.dayCount = day;
    }
    public void setTraitMultiplier(double multiplier) {
        this.traitMultiplier = this.traitMultiplier * multiplier;
    }
    public void addNewTrait() {
        traits.add(Traits.getRandomTrait());
    }
}
