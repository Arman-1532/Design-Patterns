package learning.singleton;

public class SingletonObject {
    private static SingletonObject instance = new SingletonObject(); // private na dile onno class theke ei instance ke
                                                                     // direct call kora jeto jehetu eta static. private
                                                                     // dewar karone eta kora possible hbe na.

    private SingletonObject() {
    }

    public static SingletonObject getInstance() {
        return instance;
    }

    public void printMessage() {
        System.out.println("This object can be cretaed only once");
    }
}
