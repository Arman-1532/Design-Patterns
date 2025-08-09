package prototype;

class ReportTemplate implements Document {
    private String header = "Report Header";
    private String body = "Report body content";

    @Override
    public Document clone() {
        try {
            return (ReportTemplate) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    @Override
    public void display() {
        System.out.println(header + "\n" + body);
    }
}
