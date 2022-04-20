import java.io.PrintStream;
import java.util.Scanner;

public class Operator {
    public Operator(Cloud c){
        this.cloud=c;
    }
    public void addShadeControl(ShadeControl sc){
        this.rsControl=sc;
    }
    public void addLampControl(LampControl lc){
        this.lControl=lc;
    }
    public void executeCommands(Scanner in, PrintStream out){
        out.println("Time\t" + cloud.getHeaders());
        while(in.hasNextLine()){
            int commandTime=in.nextInt();
            while (time <= commandTime) {
                cloud.advanceTime(delta);
                if (time==commandTime) {
                    out.println(Math.round(time)+"\t"+cloud.getState()+"%");   
                }
                time+= delta;
                time= Math.round(time*10.0)/10.0;
            } 
            String device=in.next();
            switch (device) {
                case "C":
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
                    break;
                case "L":
                    int ch = in.nextInt();
                    String com=in.next();
                    if (ch == lControl.getChannel()) {
                        switch (com.charAt(0)) {
                            case 'P':
                                cloud.changeLampPowerState(ch);
                                break;
                            case 'R':
                                String R=in.next();
                                switch (R.charAt(0)) {
                                    case 'U':
                                        
                                        break;
                                    case 'D':

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
                                        
                                        break;
                                    case 'D':
                                    
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
                                        
                                        break;
                                    case 'D':
                                    
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
                    break;
                default:
                    out.println("Unexpected device:" + device);
                    System.exit(-1);
                    break;
            }

        }
    }
    private double time=0;
    private ShadeControl rsControl;
    private LampControl lControl;
    private Cloud cloud;
    private final double delta=0.1;
}
