package Builder;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private final String name;
    private final String playerClass;
    private final int level;
    private final int health;
    private final int mana;
    private final int strength;
    private final int intelligence;
    private final List<String> skills;

    public Player(final String name, final String playerClass, final int level, final int health,
                  final int mana, final int strength, final int intelligence, final List<String> skills) {
        this.name = name;
        this.playerClass = playerClass;
        this.level = level;
        this.health = health;
        this.mana = mana;
        this.strength = strength;
        this.intelligence = intelligence;
        this.skills = new ArrayList<>(skills);
    }

    public void displayInfo() {
        System.out.println(name);
        System.out.println("Class: " + playerClass);
        System.out.println("Level: " + level);
        System.out.println("Health: " + health);

        if (playerClass.equals("Warrior")) {
            System.out.println("Strength: " + strength);
        } else {
            System.out.println("Mana: " + mana);
            System.out.println("Intelligence: " + intelligence);
        }

        System.out.println("Skills: " + String.join(", ", skills) + "\n");
    }
}
