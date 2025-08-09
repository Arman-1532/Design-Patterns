package learning.bridge;

import learning.bridge.device.Device;
import learning.bridge.device.Radio;
import learning.bridge.device.TV;
import learning.bridge.remote.Remote;
import learning.bridge.remote.AdvancedRemote;
import learning.bridge.remote.BasicRemote;

public class Main {
    public static void main(String[] args) {
        Device tv = new TV();
        testDevice(tv);

        Device radio = new Radio();
        testDevice(radio);
    }
    public static void testDevice(Device device){
        Remote basicRemote = new BasicRemote(device);
        basicRemote.power();
        device.printStatus();
        basicRemote.power();

        Remote adRemote = new AdvancedRemote(device);
        adRemote.power();
        device.printStatus();
        adRemote.power();
    }
}
