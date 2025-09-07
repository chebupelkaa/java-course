package Decorator;

public class FireDecorator extends WeaponDecorator {
    public FireDecorator(final Weapon weapon) {
        super(weapon);
    }

    @Override
    public String getDescription() {
        return decoratedWeapon.getDescription() + " + fire";
    }

    @Override
    public int getDamage() {
        return decoratedWeapon.getDamage() + 5;
    }
}
