package bridge;

class CSVFormatter implements Formatter {
    public String format(String content) {
        return "CSV: " + content;
    }
}