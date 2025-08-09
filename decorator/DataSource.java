package decorator;

interface DataSource {
    void writeData(String data);
    String readData();
}