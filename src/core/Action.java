package core;

public abstract class Action {
    protected String description;

    public Action(String description) {
        this.description = description;
    }

    public abstract void execute(Player palyer);

    public void nextDay(Player player) {
        player.setDayCount(player.getDayCount() + 1);
        DayCycle dayCycle = new DayCycle(player);
        dayCycle.startDay();
    }

    public String getDescription() {
        return description;
    }
}