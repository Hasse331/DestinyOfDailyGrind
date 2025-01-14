package actions;
import core.Action;
import core.Player;


public class Rest extends Action {
    public Rest() {
        super("Rest");
    }

    @Override
    public void execute(Player player) {
        player.setHealth(player.getHealth() + 20);
        System.out.println(player.getName() + " rested and regained 20 health.");
    }
}
