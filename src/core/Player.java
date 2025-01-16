package core;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Player {
    private String name;
    private int health;
    private int money;
    private int strength;
    private List<String> traits;
    private int dayCount;
    double traitMultiplier;

    public Player(String name) {
        this.name = name;
        this.health = 100;
        this.money = 100;
        this.strength = 20;
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

    public int getStrength() {
        return strength;
    }

    public List<String> getTraits() {
        return traits;
    }

    public void getAllStats() {
        System.out.println("------ " + name + " stats ------");
        System.out.println("Health: " + health);
        System.out.println("Money: " + money);
        System.out.println("Strength: " + strength);
        System.out.println("Traits: " + traits);
        System.out.println("------------------------------");
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
        if (health <= 0) {
            System.out.println(name + "Has died");
            gameOver();
        }
    }

    public void setMoney(int money) {
        this.money = money;
        if (money <= -100 && money < 0) {
            System.out.println(name + "'s credit card debt keeps growing...");
        }
        else if (money <= -200) {
            System.out.println(name + "'s bills are not paid. Let's hope there will be no trouble");
            
            if (InputManager.getRandomDouble() < 0.2) {
                EventManager.triggerDebtEvent();
            }
            
        }
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

    public void gameOver() {
        DayCycle.printWithDelay("---- GAME OVER ----");
        DayCycle.printWithDelay("Congratulatins! You succesfully survived" + dayCount + " Days!");
        System.exit(0);
    }
}
