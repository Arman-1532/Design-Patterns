package prototype;
class InvoiceTemplate implements Document {
    private String header = "Invoice Header";
    private String footer = "Invoice Footer";
    private String body = "Invoice body content";

    @Override
    public Document clone() {
        try {
            return (InvoiceTemplate) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    @Override
    public void display() {
        System.out.println(header + "\n" + body + "\n" + footer);
    }
}