public class RollerShade extends DomoticDevice {
    public RollerShade(int channel, double alpha, double length){
        super(nextId, channel);
        motor = new Motor(alpha);
        this.length=0;
        this.MaxShadeLength=length;
    }
    public void startUp(){
        motor.turnUp();
    }
    public void startDown(){
        motor.turnDown();
    }
    public void stop(){
        motor.stop();
    }
    public void advanceTime(double delta){
        motor.advanceTime(delta);
    }
    public String getHeader(){
        String s = "RS" + getId();
        return s;
    }
    public String toString(){
        String s = motor.getState();
        return s;
    }
    private class Motor {  //nested class, Motor is only used within RollerShade.
        public Motor (double a){
            alpha = a;
            state = MotorState.STOPPED;
        }
        public enum MotorState {
            UPWARD,
            STOPPED,
            DOWNWARD
        }
        public String getState(){
            switch (state) {
                case DOWNWARD:
                    return "100";
                case UPWARD:
                    return "-100";
                case STOPPED:
                    return "0";
                default:
                    break;
            }
            return "";
        }
        public void turnUp(){
            state = MotorState.UPWARD;
        }
        public void turnDown(){
            state = MotorState.DOWNWARD;
        }
        public void stop(){
            state = MotorState.STOPPED;
        }
        public void advanceTime(double delta){
            double increment = alpha*delta*RADIUS;
            switch (state) {
                case STOPPED: break;
                case DOWNWARD:
                    if((length+increment)<=MaxShadeLength){
                        length+=increment;
                        length= Math.round(length*100.0)/100.0;
                        break;
                    }
                case UPWARD:
                    if((length-increment)>=0){
                        length-=increment;
                        length= Math.round(length*100.0)/100.0;
                        break;
                    }
            }
        }
        private double alpha;
        private MotorState state;
        private static double RADIUS=0.04;
    }

    private Motor motor;
    private double length;
    private final double MaxShadeLength;
    private static int nextId;
}
