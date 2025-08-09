package learning.singleton;

public class Main {
    public static void main(String[] args) {
        SingletonObject object = SingletonObject.getInstance();
        object.printMessage();
    }
}
