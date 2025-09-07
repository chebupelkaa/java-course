package ChainOfResponsibility;

public abstract class BaseHandler implements Handler {
    protected Handler next;

    @Override
    public void setNext(final Handler next) {
        this.next = next;
    }

    @Override
    public void handle(final String attackType, final int damage) {
        if (canHandle(attackType)) {
            process(damage);
        } else if (next != null) {
            next.handle(attackType, damage);
        }
    }

    protected abstract boolean canHandle(final String attackType);

    protected abstract void process(final int damage);
}
