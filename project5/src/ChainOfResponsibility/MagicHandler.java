package ChainOfResponsibility;

public class MagicHandler extends BaseHandler {
    protected boolean canHandle(final String type) {
        return "magic".equals(type);
    }

    protected void process(final int damage) {
        System.out.println("Magic damage: " + damage);
    }

}