package Strategy;

public class GameCharacter {
    private final String name;
    private AttackStrategy attackStrategy;

    public GameCharacter(final String name) {
        this.name = name;
    }

    public void setAttackStrategy(final AttackStrategy strategy) {
        this.attackStrategy = strategy;
    }

    public void performAttack() {
        if (attackStrategy != null) {
            int damage = attackStrategy.attack();
            System.out.println(name + ": " + attackStrategy.getDescription() + " - " + damage + " damage");
        }
    }
}
