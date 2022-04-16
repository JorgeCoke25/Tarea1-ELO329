import java.io.PrintStream;
import java.util.Scanner;

public class Operator {
    public Operator(LampControl lc, Cloud c){
        this.lampControl=lc;
        this.cloud=c;    
    }
    public void executeCommands(Scanner in, PrintStream out){
        out.println("Time\t" + cloud.getHeaders());
        while(in.hasNextInt()){
            time=in.nextInt();
            String string=in.next();
            if (!string.equals("L")) {
                out.println("Unexpected device:" + string);
                System.exit(-1);
            }
            int channel = in.nextInt();
            String op = in.next();
            if(!op.equals("P")){
                out.println("Unexpected operation:" + op);
                System.exit(-1);
            }
            cloud.changeLampPowerState(channel);
            out.println(time+"\t"+cloud.getState());
            in.nextLine();
        }
    }
    private double time=0;
    private LampControl lampControl;
    private Cloud cloud;
}
