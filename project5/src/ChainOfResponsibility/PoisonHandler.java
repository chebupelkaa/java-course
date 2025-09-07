package ChainOfResponsibility;

public class PoisonHandler extends BaseHandler {
    protected boolean canHandle(final String type) {
        return "poison".equals(type);
    }

    protected void process(final int damage) {
        System.out.println("Poison damage: " + damage);
    }
}
