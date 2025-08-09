package learning.prototype;

public class NetworkConnector implements Cloneable{
    String ip;
    int port;
    static NetworkConnector nc = new NetworkConnector();

    public static NetworkConnector getInstance(String ip, int port) throws InterruptedException{
        nc.ip = ip;
        nc.port = port;
        Thread.sleep(5000);
        return nc;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    @Override
    public String toString() {
        return "NetworkConnector [ip=" + ip + ", port=" + port + "]";
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
