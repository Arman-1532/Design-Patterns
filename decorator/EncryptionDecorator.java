package decorator;

class EncryptionDecorator extends DataSourceDecorator {
    public EncryptionDecorator(DataSource source) {
        super(source);
    }

    public void writeData(String data) {
        super.writeData("enc(" + data + ")");
    }

    public String readData() {
        return super.readData().replace("enc(", "").replace(")", "");
    }
}