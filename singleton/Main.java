package singleton;

public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();

        logger.log("Application started.");
        System.out.println("Doing some work...");
        logger.log("Application finished.");
    }
}
