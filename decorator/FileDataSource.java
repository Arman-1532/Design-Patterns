package decorator;

class FileDataSource implements DataSource {
    private String filename;
    private String storedData;

    public FileDataSource(String filename) {
        this.filename = filename;
    }

    public void writeData(String data) {
        storedData = data;
        System.out.println("Writing to " + filename + ": " + data);
    }

    public String readData() {
        System.out.println("Reading from " + filename);
        return storedData;
    }
}