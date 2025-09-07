package ChainOfResponsibility;

public class PhysicalHandler extends BaseHandler {
    protected boolean canHandle(final String type) {
        return "physical".equals(type);
    }

    protected void process(final int damage) {
        System.out.println("Physical damage: " + damage);
    }
}