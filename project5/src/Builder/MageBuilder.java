package Builder;

import java.util.ArrayList;
import java.util.List;

public class MageBuilder implements PlayerBuilder {
    private String name;
    private int level = 1;

    @Override
    public PlayerBuilder setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public PlayerBuilder setLevel(int level) {
        this.level = level;
        return this;
    }

    @Override
    public Player build() {
        if (name == null) name = "Unknown Mage";

        int health = 80 + (level - 1) * 5;
        int mana = 200 + (level - 1) * 30;
        int strength = 20;
        int intelligence = 90 + (level - 1) * 15;

        List<String> skills = new ArrayList<>();
        skills.add("fireball");
        skills.add("teleport");
        if (level >= 3) skills.add("control");
        if (level >= 5) skills.add("lightning Strike");

        return new Player(name, "Mage", level, health, mana, strength, intelligence, skills);
    }
}
