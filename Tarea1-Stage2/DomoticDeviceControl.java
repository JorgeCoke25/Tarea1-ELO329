public class DomoticDeviceControl {
    public DomoticDeviceControl(int ch, Cloud c){
        this.channel=ch;
        this.cloud=c;
    }
    public int getChannel() {
        return channel;
    }
    protected Cloud cloud;
    protected int channel;
}
