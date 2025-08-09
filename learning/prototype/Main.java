package learning.prototype;

public class Main {
    public static void main(String[] args) throws InterruptedException,CloneNotSupportedException{
        NetworkConnector ob1 = NetworkConnector.getInstance("146.234.4.4", 80);
        System.out.println(ob1.toString());

        NetworkConnector ob2 = (NetworkConnector) ob1.clone();
        System.out.println(ob2.toString());
        
    }
}
