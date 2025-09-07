package Decorator;

public class Client {
    public static void main(String[] args) {
        final Weapon sword = new BasicSword();
        printWeaponStats(sword);

        final Weapon betterSword = new SharpenedDecorator(sword);
        printWeaponStats(betterSword);

        final Weapon betterBetterSword = new FireDecorator(betterSword);
        printWeaponStats(betterBetterSword);
    }

    private static void printWeaponStats(final Weapon weapon) {
        System.out.println("--- " + weapon.getDescription() + " ---");
        System.out.println("Damage: " + weapon.getDamage());
        System.out.println();
    }
}
