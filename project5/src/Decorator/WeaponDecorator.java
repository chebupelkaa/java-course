package Decorator;

public abstract class WeaponDecorator implements Weapon {
    protected final Weapon decoratedWeapon;

    public WeaponDecorator(final Weapon weapon) {
        this.decoratedWeapon = weapon;
    }

    @Override
    public String getDescription() {
        return decoratedWeapon.getDescription();
    }

    @Override
    public int getDamage() {
        return decoratedWeapon.getDamage();
    }
}