package npc;

import java.util.ArrayList;
import java.util.List;

import core.Player;

public abstract class Npc extends Player {
    private static final List<Npc> CompanionNpcList = new ArrayList<>();
    private static final List<Npc> npcList = new ArrayList<>();
    private double statMultiplier;
    private String npcType;

    public Npc(String npcName, double statMultiplier, String npcType) {
        super(npcName);
        this.npcType = npcType;
        this.statMultiplier = statMultiplier;

        setHealth((int) (getHealth() * statMultiplier));
        setMoney((int) (getMoney() * statMultiplier));
        setStrength((int) (getStrength() * statMultiplier));

        if (npcType.equals("companion")) {
            CompanionNpcList.add(this);
        } else if (npcType.equals("neutral") || npcType.equals("hostile")) {
            npcList.add(this);
        } else {
            throw new IllegalArgumentException("npcType must be 'companion', 'neutral' or 'hostile'");
        }
    }

    @Override
    public void setHealth(int health) {
        this.health = health;
        if (health <= 0) {
            System.out.println(this.name + " died!");
            npcDeath();
        }
    }

    public abstract void conversation(Player player);

    public void fight() {
        // Fight simulation
    }

    private void npcDeath() {
        if (npcType.equals("companion")) {
            System.out.println("Your companion: " + getName() + " died!!");
            CompanionNpcList.remove(this);
        } else {
            System.out.println(getName() + " died!");
            npcList.remove(this);
        }
    }

    public void getNpcStats() {
        System.out.println(this.npcType + " NPC: ");
        super.getAllStats();
    }

    public double getStatMultiplier() {
        return statMultiplier;
    }

    public static List<Npc> getCompanionNpcs() {
        return new ArrayList<>(CompanionNpcList);
    }
    
    public static List<Npc> getNeutralOrHostileNpcs() {
        return new ArrayList<>(npcList);
    }
}