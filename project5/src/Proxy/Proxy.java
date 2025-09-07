package Proxy;

public class Proxy implements GameCharacter {
    private Service realCharacter;
    private final String name;
    private final boolean hasAccess;

    public Proxy(final String name,final boolean hasAccess) {
        this.name = name;
        this.hasAccess = hasAccess;
    }

    private void checkAccess() {
        if (!hasAccess) {
            throw new RuntimeException("Access denied for " + name);
        }
    }

    private void initRealCharacter() {
        if (realCharacter == null) {
            realCharacter = new Service(name);
        }
    }

    @Override
    public void attack() {
        checkAccess();
        initRealCharacter();
        realCharacter.attack();
    }
}