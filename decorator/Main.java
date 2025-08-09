package decorator;

public class Main {
    public static void main(String[] args) {
        DataSource file = new FileDataSource("test.txt");
        DataSource encrypted = new EncryptionDecorator(file);
        DataSource compressed = new CompressionDecorator(encrypted);

        compressed.writeData("I Love my country");
        String output = compressed.readData();
        System.out.println("Final Output: " + output);
    }
}