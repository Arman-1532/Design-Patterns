package learning.bridge.device;

public class Radio implements Device{
    boolean on = false;
    int volume = 25;
    int channel = 1;

    public boolean isEnabled(){
        return on;
    }

    public void enable(){
        on = true;
    }

    public void disable(){
        on = false;
    }

    public int getVolume(){
        return volume;
    }

    public void setVolume(int percent){
        if(volume < 0) volume = 0;
        else if(volume > 100) volume = 100;
        else volume = percent;
    }

    public int getChannel(){
        return channel;
    }

    public void setChannel(int channel){
        this.channel = channel;
    }

    public void printStatus(){
        System.out.println("------------------------------------");
        System.out.println("Radio is " + (on ? "on" : "off"));
        if(on == false) return;
        System.out.println("i am set on channel " + channel);
        System.out.println("i am set on volume " + volume);
        System.out.println("------------------------------------");
    }
}
