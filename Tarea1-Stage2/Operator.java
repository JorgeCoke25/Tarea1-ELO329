import java.io.PrintStream;
import java.util.Scanner;

public class Operator {
    public Operator(Cloud c){
        this.cloud=c;
    }
    public void addShadeControl(ShadeControl sc){
        rsControl=sc;
    }
    public void executeCommands(Scanner in, PrintStream out){
        out.println("Time\t" + cloud.getHeaders());
        while(in.hasNextInt()){
            double time_b = time;
            int commandTime=in.nextInt();
            while (time <= commandTime) {
                cloud.advanceTime(delta);
                if (time==commandTime) {
                    out.println(Math.round(time)+"\t"+cloud.getState());  
                    try {
                        Thread.sleep((int)(time*1000-time_b*1000));
                    } catch (InterruptedException e) {}
                }
                time+= delta;
                time= Math.round(time*10.0)/10.0;
            } 
            String device=in.next();
            if (!device.equals("C")) {
                out.println("Unexpected device:" + device);
                System.exit(-1);
            }
            int channel = in.nextInt();
            String command=in.next();
            if (channel == rsControl.getChannel()) {
                switch (command.charAt(0)) {
                    case 'D': 
                        rsControl.startDown(); 
                        break;
                    case 'U': 
                        rsControl.startUp();
                        break;
                    case 'S': 
                        rsControl.stop();
                        break;
                    default: out.println("Unexpected command:" + command);
                        System.exit(-1);
                }
            }
        }
    }
    private double time=0;
    private ShadeControl rsControl;
    private Cloud cloud;
    private final double delta=0.1;
}
