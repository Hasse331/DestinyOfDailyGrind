package core;
import java.util.Arrays;
import java.util.List;

public class Player {
    private String name;
    private int health;
    private int money;
    private List<String> traits;

    public Player(String name) {
        this.name = name;
        this.health = 100;
        this.money = 100;
        this.traits = Arrays.asList(Traits.getRandomTrait());
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

    // Setter-metodit (muokkaamista varten)
    public void setHealth(int health) {
        this.health = health;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
