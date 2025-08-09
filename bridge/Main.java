package bridge;

public class Main {
    public static void main(String[] args) {
        Formatter pdf = new PDFFormatter();
        Formatter csv = new CSVFormatter();

        Report sales = new SalesReport(pdf);
        Report customer = new CustomerReport(csv);

        System.out.println(sales.generate());   
        System.out.println(customer.generate()); 
    }
}
