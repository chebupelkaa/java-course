package Strategy;

public class MagicAttack implements AttackStrategy {
    @Override
    public int attack() {
        return 20 + (int) (Math.random() * 20);
    }

    @Override
    public String getDescription() {
        return "magic attack";
    }
}
