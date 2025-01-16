package npc;

import core.Player;

public abstract class Npc extends Player {
    private double statMultiplier;

    public Npc(String npcName, double statMultiplier) {
        super(npcName);
        this.statMultiplier = statMultiplier;
    }

    @Override
    public void gameOver() {
        throw new UnsupportedOperationException("NPCs cannot trigger game over.");
    }

    public abstract void conversation();

    public void fight() {
        // Fight simulation
    }

    public void die() {
        // NPC dying
    }
}