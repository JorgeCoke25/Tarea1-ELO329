import java.util.ArrayList;

public class Cloud {
    public Cloud() {
        lamps = new ArrayList<Lamp>();
    }
    public void addLamp(Lamp l){
        lamps.add(l);
    }
    public Lamp getLampAtChannel( int channel){
        //???
    }
    public void changeLampPowerState(int channel){
        //??
    }
    public String getHeaders(){
        String header = "";
        for (Lamp l: lamps)
            header += l.getHeader();
        return header;
    }
    public String getState(){
        //??
    }
    private ArrayList<Lamp> lamps; // getting ready for next stages
}
