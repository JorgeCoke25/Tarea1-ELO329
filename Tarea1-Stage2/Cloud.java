import java.util.ArrayList;

public class Cloud {
    public Cloud() {
        lamps = new ArrayList<Lamp>();
        rollerShades = new ArrayList<DomoticDevice>();
    }
    public void addLamp(Lamp l){
        lamps.add(l);
    }
    public void addRollerShade(RollerShade rs){
        rollerShades.add(rs);
    }
    public void advanceTime(double delta){
        for (DomoticDevice dd: rollerShades) {
            RollerShade rs =(RollerShade)dd;
            rs.advanceTime(delta);
        }
    }
    private DomoticDevice getDomoticDeviceAtChannel( ArrayList<DomoticDevice> devices, int channel){
        // ???
    }
    public void startShadeUp(int channel){
        // ???
    }
    public void startShadeDown(int channel){
        // ???
    }
    public void stopShade(int channel){
        // ???
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
    private ArrayList<DomoticDevice> rollerShades;
}