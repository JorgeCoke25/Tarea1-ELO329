public class Lamp {
    public Lamp (int channel){
        //??
    }
    {
        id=nextId++;
    }
    public int getChannel(){
        return channel;
    }
    public void changePowerState(){
       //???
    }
    public String getHeader(){
       //??
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
