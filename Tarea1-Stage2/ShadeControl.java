public class ShadeControl extends DomoticDeviceControl{
    public ShadeControl(int channel, Cloud c){
        super(channel,c);
    }
    public void startUp(){
        cloud.startShadeUp(channel);
    }
    public void startDown(){
        cloud.startShadeDown(channel);
    }
    public void stop(){
        cloud.stopShade(channel);
    }
}
