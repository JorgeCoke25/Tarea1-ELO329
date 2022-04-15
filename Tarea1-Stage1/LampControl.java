public class LampControl {
    public LampControl(int channel, Cloud c){
        this.channel=channel;
        this.cloud=c;
    }
    public void pressPower(){
        cloud.changeLampPowerState(channel);
    }
    public int getChannel(){
        return this.channel;
    }
    private Cloud cloud;
    private int channel;
}
