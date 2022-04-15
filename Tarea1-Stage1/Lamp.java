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
        if (state==LampState.OFF) {
            state=LampState.ON;
        }
        else{
            state=LampState.OFF;
        }   
    }
    public String getHeader(){
       return ""+id;
    }
    public String toString(){
        if (state==LampState.ON)
            return ""+r+"\t"+g+"\t"+b;
        else
            return "0\t0\t0";
    }
    private int channel;
    private short r,g,b;
    private LampState state;
    private final int id;  // to conform lamp's header
    private static int nextId=0;
}
