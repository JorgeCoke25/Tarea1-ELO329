import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Operator {
    public Operator(Cloud c){
        this.cloud=c;
        rsControl=new ArrayList<ShadeControl>();
        lControl=new ArrayList<LampControl>();
    }
    public void addShadeControl(ShadeControl sc){
        rsControl.add(sc);
    }
    public void addLampControl(LampControl lc){
        lControl.add(lc);
    }
    public void executeCommands(Scanner in, PrintStream out) throws FileNotFoundException{
        File salida = new File("salida.csv");
        PrintWriter printWriter = new PrintWriter(salida);
        printWriter.println("Time\t" + cloud.getHeaders());
        out.println("Time\t" + cloud.getHeaders());
        while(in.hasNextInt()){
            double time_b=time;
            int commandTime=in.nextInt();
            String device=in.next();
            switch (device) {
                case "C":
                    int channel = in.nextInt();
                    String command=in.next();
                    for (ShadeControl  rs: rsControl) {
                        if (channel == rs.getChannel()) {
                            switch (command.charAt(0)) {
                                case 'D': 
                                    rs.startDown(); 
                                    break;
                                case 'U': 
                                    rs.startUp();
                                    break;
                                case 'S': 
                                    rs.stop();
                                    break;
                                default: out.println("Unexpected command:" + command);
                                    System.exit(-1);
                            }
                        }
                    }
                    break;
                case "L":
                    int ch = in.nextInt();
                    String com=in.next();
                    for (LampControl lampControl : lControl) {
                        if (ch == lampControl.getChannel()) {
                            switch (com.charAt(0)) {
                                case 'P':
                                    cloud.changeLampPowerState(ch);
                                    break;
                                case 'R':
                                    String R=in.next();
                                    switch (R.charAt(0)) {
                                        case 'U':
                                            cloud.turnRedUp(ch);
                                            break;
                                        case 'D':
                                            cloud.turnRedDown(ch);
                                            break;
                                        default:
                                            out.println("Unexpected command:" + R);
                                            System.exit(-1);
                                            break;
                                    }
                                    break;
                                case 'G':
                                    String G=in.next();
                                    switch (G.charAt(0)) {
                                        case 'U':
                                            cloud.turnGreenUp(ch);
                                            break;
                                        case 'D':
                                            cloud.turnGreenDown(ch);
                                            break;
                                        default:
                                            out.println("Unexpected command:" + G);
                                            System.exit(-1);
                                            break;
                                    }
                                    break;
                                case 'B':
                                    String B=in.next();
                                    switch (B.charAt(0)) {
                                        case 'U':
                                            cloud.turnBlueUp(ch);
                                            break;
                                        case 'D':
                                            cloud.turnBlueDown(ch);
                                            break;
                                        default:
                                            out.println("Unexpected command:" + B);
                                            System.exit(-1);
                                            break;
                                    }
                                    break;
                                default:
                                    out.println("Unexpected command:" + com);
                                    System.exit(-1);
                                    break;
                            }
                        }
                    }
                    break;
                default:
                    out.println("Unexpected device:" + device);
                    System.exit(-1);
                    break;
            }
            while (time <= commandTime) {
                cloud.advanceTime(delta);
                if (time==commandTime) {
                    try {
                        Thread.sleep((int)(time*1000-time_b*1000));
                    } catch (InterruptedException e) {}
                    printWriter.println(Math.round(time)+"\t"+cloud.getState());
                    out.println(Math.round(time)+"\t"+cloud.getState());   
                }
                time+= delta;
                time= Math.round(time*10.0)/10.0;
            } 
        }
        printWriter.close();
    }
    private double time=0;
    private ArrayList<ShadeControl> rsControl;
    private ArrayList<LampControl> lControl;
    private Cloud cloud;
    private final double delta=0.1;
}
