package npc;

import core.Player;

public abstract class Npc extends Player {
    private double statMultiplier;

    public Npc(String npcName, double statMultiplier) {
        super(npcName);
        this.statMultiplier = statMultiplier;

    }

    public abstract void conversation();

    public void fight() {
        // Fight simulation
    }

}
