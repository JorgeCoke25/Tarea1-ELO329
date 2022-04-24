public class Lamp {
    public Lamp (int channel){
        this.channel = channel; 
        this.r=0;
        this.g=0;
        this.b=0;
        this.state=LampState.OFF;
    }
    {
        id=nextId++;
    }
    public int getChannel(){
        return channel;
    }
    public void changePowerState(){
        if (state==LampState.OFF && this.r==0 && this.g==0&& this.b==0) {
            state=LampState.ON;
            this.r=255;
            this.g=255;
            this.b=255;
        }
        else if (state==LampState.OFF) {
            state=LampState.ON;
        }
        else{
            state=LampState.OFF;
        }   
    }
    public void RedUp() {
        if (this.r==255 && this.g==255 && this.b==255) {
            this.r=255;
            this.g=0;
            this.b=0;
        }
        else if (state==LampState.OFF) {
            state=LampState.OFF;
        }
        else{
            this.r=255;
        }
    }
    public void GrenUp() {
        if (this.r==255 && this.g==255 && this.b==255) {
            this.r=0;
            this.g=255;
            this.b=0;
        }
        else if (state==LampState.OFF) {
            state=LampState.OFF;
        }
        else{
            this.g=255;
        }
    }
    public void BlueUp() {
        if (this.r==255 && this.g==255 && this.b==255) {
            this.r=0;
            this.g=0;
            this.b=255;
        }
        else if (state==LampState.OFF) {
            state=LampState.OFF;
        }
        else{
            this.b=255;
        }
    }
    public void RedDown() {
        if (state==LampState.OFF) {
            state=LampState.OFF;
        }
        else{
            this.r=0;
        }
    }
    public void GrenDown() {
        if (state==LampState.OFF) {
            state=LampState.OFF;
        }
        else{
            this.g=0;
        }
    }
    public void BlueDown() {
        if (state==LampState.OFF) {
            state=LampState.OFF;
        }
        else{
            this.b=0;
        }
    }
    public String getHeader(){
       return "L"+id+"R\t"+"L"+id+"G\t"+"L"+id+"B\t";
    }
    public String toString(){
        if (state==LampState.ON){
            return ""+r+"\t"+g+"\t"+b+"\t";
        }
        else{
            return "0\t0\t0\t";
        }
    }
    private int channel;
    private short r,g,b;
    private LampState state;
    private final int id;  // to conform lamp's header
    private static int nextId=0;
}
