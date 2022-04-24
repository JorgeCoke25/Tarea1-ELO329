public class LampControl {
    public LampControl(int channel, Cloud c){
        this.channel=channel;
        this.cloud=c;
    }
    public void pressPower(){
        cloud.changeLampPowerState(channel);
    }
    public void switchRedUp(){
        cloud.turnRedUp(channel);
    }
    public void switchGreenUp(){
        cloud.turnGreenUp(channel);
    }
    public void switchBlueUp(){
        cloud.turnBlueUp(channel);
    }
    public void switchRedDown(){
        cloud.turnRedDown(channel);
    }
    public void switchGreenDown(){
        cloud.turnGreenDown(channel);
    }
    public void switchBlueDown(){
        cloud.turnBlueDown(channel);
    }
    public int getChannel(){
        return this.channel;
    }
    private Cloud cloud;
    private int channel;
}
