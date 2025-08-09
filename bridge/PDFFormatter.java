package bridge;

class PDFFormatter implements Formatter {
    public String format(String content) {
        return "PDF: " + content;
    }
}