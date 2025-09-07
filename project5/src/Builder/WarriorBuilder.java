package Builder;

import java.util.ArrayList;
import java.util.List;

public class WarriorBuilder implements PlayerBuilder {
    private String name;
    private int level = 1;

    @Override
    public PlayerBuilder setName(final String name) {
        this.name = name;
        return this;
    }

    @Override
    public PlayerBuilder setLevel(final int level) {
        this.level = level;
        return this;
    }

    @Override
    public Player build() {
        if (name == null) name = "Unknown Warrior";

        int health = 150 + (level - 1) * 20;
        int strength = 80 + (level - 1) * 10;
        int mana = 50;
        int intelligence = 30;

        List<String> skills = new ArrayList<>();
        skills.add("hit");
        skills.add("shield block");
        if (level >= 3) skills.add("power Strike");
        if (level >= 5) skills.add("whirlwind");

        return new Player(name, "Warrior", level, health, mana, strength, intelligence, skills);
    }
}