package ChainOfResponsibility;

public interface Handler {
    void setNext(final Handler next);

    void handle(final String attackType, final int damage);
}