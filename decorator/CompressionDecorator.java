package decorator;

class CompressionDecorator extends DataSourceDecorator {
    public CompressionDecorator(DataSource source) {
        super(source);
    }

    public void writeData(String data) {
        super.writeData("cmp(" + data + ")");
    }

    public String readData() {
        return super.readData().replace("cmp(", "").replace(")", "");
    }
}