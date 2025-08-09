package bridge;

abstract class Report {
    protected Formatter formatter;

    public Report(Formatter formatter) {
        this.formatter = formatter;
    }

    public abstract String generate();
}