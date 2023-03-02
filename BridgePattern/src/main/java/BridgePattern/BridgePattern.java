/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package BridgePattern;

/**
 *
 * @author sedra
 */
public class BridgePattern {

    public static void main(String[] args) {
        Tv tv = new Tv();
        System.out.println("Tv is now :" +((tv.isEnabled)?"ON":"OFF"));
        RemoteControl remote = new RemoteControl(tv);
        remote.TogglePower();
        System.out.println("Tv is now :" +((tv.isEnabled)?"ON":"OFF"));
        
        Radio radio = new Radio();
        radio.setVolume(20);
        System.out.println("Radio Volume is now :" +radio.getVolume());
        AdvancedRemoteControl remote2 = new AdvancedRemoteControl(radio);
        remote2.Mute();
        System.out.println("Radio Volume is now :" +radio.getVolume());
        
        
    }
}
class RemoteControl{
    protected Device device ;
    public RemoteControl(){
        
    }
    public RemoteControl(Device device) {
        this.device = device;
    }
    public void TogglePower(){
        if(device.isEnabled()){
            device.disable();
        }
        else{
            device.enable();
        }
    }
    public void VolumeDown(){
        device.setVolume(device.getVolume()-10);
    }
    public void VolumeUp(){
         device.setVolume(device.getVolume()+10);
    }
    public void ChannelDown(){
        device.setChannelNumber(device.getChannelNumber()-1);
    }
     public void ChannelUp(){
        device.setChannelNumber(device.getChannelNumber()+1);
    }
    
    
}


class AdvancedRemoteControl extends RemoteControl{
    Device device ;

    public AdvancedRemoteControl(Device device) {
        this.device = device;
    }
    
    
    void Mute(){
     device.setVolume(0);
    }
}


interface Device{
    boolean isEnabled();
    void enable();
    void disable();
    float getVolume();
    void setVolume(float Percent);
    int getChannelNumber();
    void setChannelNumber(int Channel);
}


class Tv implements Device{
    boolean isEnabled;
    float Volume;
    int ChannelID;

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }

    @Override
    public void enable() {
        isEnabled = true;
    }

    @Override
    public void disable() {
        isEnabled = false;
    }

    @Override
    public float getVolume() {
        return Volume;
    }

    @Override
    public void setVolume(float Percent) {
        Volume = Percent;
    }

    @Override
    public int getChannelNumber() {
        return ChannelID;
    }

    @Override
    public void setChannelNumber(int Channel) {
        ChannelID= Channel;
    }
    
    

}
class Radio implements Device{
    
     boolean isEnabled;
    float Volume;
    int ChannelID;

  @Override
    public boolean isEnabled() {
        return isEnabled;
    }

    @Override
    public void enable() {
        isEnabled = true;
    }

    @Override
    public void disable() {
        isEnabled = false;
    }

    @Override
    public float getVolume() {
        return Volume;
    }

    @Override
    public void setVolume(float Percent) {
        Volume = Percent;
    }

    @Override
    public int getChannelNumber() {
        return ChannelID;
    }

    @Override
    public void setChannelNumber(int Channel) {
        ChannelID= Channel;
    }
    
    

}
    


