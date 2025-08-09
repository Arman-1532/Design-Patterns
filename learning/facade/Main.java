package learning.facade;

public class Main {
    public static void main(String[] args) {
        CheckoutFacade facade = new CheckoutFacade();
        facade.checkout("Book", 19.99);
    }
}
