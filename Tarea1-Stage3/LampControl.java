public class LampControl {
    public LampControl(int channel, Cloud c){
        this.channel=channel;
        this.cloud=c;
    }
    public void pressPower(){
        cloud.changeLampPowerState(channel);
    }
    public void switchRedUp(){
        cloud.changeLampPowerState(channel);
    }
    public void switchGreenUp(){
        cloud.changeLampPowerState(channel);
    }
    public void switchBlueUp(){
        cloud.changeLampPowerState(channel);
    }
    public int getChannel(){
        return this.channel;
    }
    private Cloud cloud;
    private int channel;
}
