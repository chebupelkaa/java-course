package Strategy;

class BowAttack implements AttackStrategy {
    public int attack() {
        return 10 + (int) (Math.random() * 15);
    }

    public String getDescription() {
        return "bow attack";
    }
}