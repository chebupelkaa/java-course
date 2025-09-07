package Decorator;

public class BasicSword implements Weapon {
    @Override
    public String getDescription() {
        return "Sword";
    }

    @Override
    public int getDamage() {
        return 10;
    }
}