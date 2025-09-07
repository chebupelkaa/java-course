package Decorator;

public class SharpenedDecorator extends WeaponDecorator {
    public SharpenedDecorator(final Weapon weapon) {
        super(weapon);
    }

    @Override
    public String getDescription() {
        return decoratedWeapon.getDescription() + " + sharpness";
    }

    @Override
    public int getDamage() {
        return decoratedWeapon.getDamage() + 5;
    }
}
