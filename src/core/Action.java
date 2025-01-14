package core;

public abstract class Action {
    protected String description;

    public Action(String description) {
        this.description = description;
    }

    public abstract void execute(Player palyer);

    public String getDescription() {
        return description;
    }
}