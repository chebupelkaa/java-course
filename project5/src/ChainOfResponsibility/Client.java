package ChainOfResponsibility;

public class Client {
    public static void main(String[] args) {
        final BaseHandler physical = new PhysicalHandler();
        final BaseHandler magic = new MagicHandler();
        final BaseHandler poison = new PoisonHandler();

        physical.setNext(magic);
        magic.setNext(poison);

        physical.handle("physical", 20);
        physical.handle("magic", 15);
        physical.handle("poison", 5);
    }
}
