package Strategy;

public class Client {
    public static void main(String[] args) {
        GameCharacter player = new GameCharacter("player");

        player.setAttackStrategy(new SwordAttack());
        player.performAttack();

        player.setAttackStrategy(new MagicAttack());
        player.performAttack();

        player.setAttackStrategy(new BowAttack());
        player.performAttack();
    }
}
