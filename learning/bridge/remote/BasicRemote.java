package learning.bridge.remote;

import learning.bridge.device.Device;;

public class BasicRemote implements Remote{
    Device device;

    public BasicRemote(Device device){
        this.device = device;
    }

    public void power(){
        if(device.isEnabled() == true){
            device.disable();
        }
        else device.enable();
    }

    public void volumeDown(){
        device.setVolume(device.getVolume() - 10);
    }

    public void volumeUp(){
        device.setVolume(device.getVolume() + 10);
    }

    public void channelDown(){
        device.setChannel(device.getChannel() - 1);
    }

    public void channelUp(){
        device.setChannel(device.getChannel() + 1);
    }
}
