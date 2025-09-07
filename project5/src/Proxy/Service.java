package Proxy;

public class Service implements GameCharacter {
    private final String name;

    public Service(final String name) {
        this.name = name;
        System.out.println("Creating character: " + name);
    }

    @Override
    public void attack() {
        System.out.println(name + " attacks with full power");
    }
}