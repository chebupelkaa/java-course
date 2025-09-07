package Strategy;

public class SwordAttack implements AttackStrategy {
    @Override
    public int attack() {
        return 15 + (int) (Math.random() * 10);
    }

    @Override
    public String getDescription() {
        return "sword strike";
    }
}
