package factory;

public class Main {
    public static void main(String[] args) {
        NotificationFactory factory = new NotificationFactory();

        Notification notification = factory.createNotification("email");
        notification.notifyUser();
    }
}
