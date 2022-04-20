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
        rs.startDown();
    }
    public void stopShade(int channel){
        RollerShade rs=(RollerShade)getDomoticDeviceAtChannel(rollerShades, channel);
        rs.stop();
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
    public void turnRedUp(int channel){
        for (Lamp lamp : lamps) {
            if (lamp.getChannel()==channel) {
                lamp.RedUp();
            }
        }
    }
    public void turnGreenUp(int channel){
        for (Lamp lamp : lamps) {
            if (lamp.getChannel()==channel) {
                lamp.GrenUp();
            }
        }
    }
    public void turnBlueUp(int channel){
        for (Lamp lamp : lamps) {
            if (lamp.getChannel()==channel) {
                lamp.BlueUp();
            }
        }
    }
    public void turnRedDown(int channel){
        for (Lamp lamp : lamps) {
            if (lamp.getChannel()==channel) {
                lamp.RedDown();
            }
        }
    }
    public void turnGreenDown(int channel){
        for (Lamp lamp : lamps) {
            if (lamp.getChannel()==channel) {
                lamp.GrenDown();
            }
        }
    }
    public void turnBlueDown(int channel){
        for (Lamp lamp : lamps) {
            if (lamp.getChannel()==channel) {
                lamp.BlueDown();
            }
        }
    }
    public String getHeaders(){
        String header = "";
        for (DomoticDevice rs : rollerShades) {
            header += rs.getHeader();
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
