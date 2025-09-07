package Adapter;

public class GameCharacter {
    private final String name;
    private final int health;

    public GameCharacter(final String name, final int health) {
        this.name = name;
        this.health = health;
    }

    public void performAction() {
        int damage = (int) (Math.random() * 20) + 5;
        System.out.println(name + " performs action with power: " + damage);
    }

    public void changePosition() {
        System.out.println(name + " is moving");
    }

    public String getCharacterInfo() {
        return name + " [" + health + " HP]";
    }
}
