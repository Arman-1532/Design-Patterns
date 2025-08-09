package prototype;

public class Main {
    public static void main(String[] args) {
        Document invoice = new InvoiceTemplate();
        Document clonedInvoice = invoice.clone();
        clonedInvoice.display();

        Document report = new ReportTemplate();
        Document clonedReport = report.clone();
        clonedReport.display();
    }
}
