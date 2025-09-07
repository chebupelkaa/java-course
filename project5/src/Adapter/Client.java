package Adapter;

public class Client {
    public static void main(String[] args) {
        final GameCharacter oldCharacter = new GameCharacter("Warrior", 20);
        final Player player = new CharacterAdapter(oldCharacter);
        System.out.println("Player: " + player.getStatus());
        player.move();
        player.attack();
    }
}
