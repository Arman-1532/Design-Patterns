package bridge;

class SalesReport extends Report {
    public SalesReport(Formatter formatter) {
        super(formatter);
    }

    @Override
    public String generate() {
        return formatter.format("Showing Sales Report");
    }
}