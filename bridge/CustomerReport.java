package bridge;

class CustomerReport extends Report {
    public CustomerReport(Formatter formatter) {
        super(formatter);
    }

    @Override
    public String generate() {
        return formatter.format("Showing Customer Report");
    }
}