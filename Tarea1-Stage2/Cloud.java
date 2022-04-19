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
        for (DomoticDevice domoticDevice : devices) {
            if (domoticDevice.getChannel()==channel){
                return domoticDevice;
            }
        }
        return null;
    }
    public void startShadeUp(int channel){
        RollerShade rs=(RollerShade)getDomoticDeviceAtChannel(rollerShades, channel);
        rs.startUp();
    }
    public void startShadeDown(int channel){
        RollerShade rs=(RollerShade)getDomoticDeviceAtChannel(rollerShades, channel);
        rs.startUp();
    }
    public void stopShade(int channel){
        RollerShade rs=(RollerShade)getDomoticDeviceAtChannel(rollerShades, channel);
        rs.startUp();
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
        for (DomoticDevice rs : rollerShades) {
            header += rs.toString();
        }
        for (Lamp l: lamps)
            header += l.getHeader();
        return header;
    }
    public String getState(){
        String state = "";
        for (DomoticDevice rs : rollerShades) {
            state += rs.toString();
        }
        for (Lamp lamp : lamps) {
            state+= lamp.toString();
        }
        return state;
    }
    private ArrayList<Lamp> lamps; // getting ready for next stages
    private ArrayList<DomoticDevice> rollerShades;
}
