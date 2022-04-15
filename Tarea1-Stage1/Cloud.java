import java.util.ArrayList;

public class Cloud {
    public Cloud() {
        lamps = new ArrayList<Lamp>();
    }
    public void addLamp(Lamp l){
        lamps.add(l);
    }
    public ArrayList<Lamp> getLampAtChannel(int channel){
        ArrayList<Lamp> lampsChannel;
        lampsChannel = new ArrayList<Lamp>();
        for (Lamp lamp : lamps) {
            if (lamp.getChannel()==channel) {
                lampsChannel.add(lamp);
            }
        }
        return lampsChannel;
    }
    public void changeLampPowerState(int channel){
        for (Lamp lamp : lamps) {
            if (lamp.getChannel()==channel) {
                lamp.changePowerState();
            }
        }
    }
    public String getHeaders(){
        String header = "";
        for (Lamp l: lamps)
            header += l.getHeader();
        return header;
    }
    public String getState(){
        String state = "";
        for (Lamp lamp : lamps) {
            state+= lamp.toString();
        }
        return state;
    }
    private ArrayList<Lamp> lamps; // getting ready for next stages
}
