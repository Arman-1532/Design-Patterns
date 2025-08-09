package learning.facade;

public class CheckoutFacade {
    private InventoryService inventory = new InventoryService();
    private PaymentService payment = new PaymentService();
    private OrderService order = new OrderService();
    private ShippingService shipping = new ShippingService();

    public void checkout(String item, double price) {
        inventory.checkInventory(item);
        payment.processPayment(price);
        order.logOrder(item);
        shipping.shipItem(item);
        System.out.println("Checkout complete.");
    }
}