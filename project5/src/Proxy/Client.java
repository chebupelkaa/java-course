package Proxy;

public class Client {
    public static void main(String[] args) {
        final GameCharacter character1 = new Proxy("Warrior", true);
        final GameCharacter character2 = new Proxy("Mage", false);

        character1.attack();

        try {
            character2.attack();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
