import java.io.File;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class Stage3 {
    public static void main(String [] args) throws IOException {
        if (args.length != 1) {
            System.out.println("Usage: java Stage3 <configurationFile.txt>");
            System.exit(-1);
        }
        Scanner in = new Scanner(new File(args[0]));
        in.useLocale(Locale.US);
        //System.out.println("File: " + args[0]);
        Cloud cloud = new Cloud();
        Operator operator = new Operator(cloud);
        // reading <#_de_cortinas> <#_de_lámparas> <#_controles_cortinas> <#_controles_lámparas>
        int numRollerShades = in.nextInt();
        int numLamps = in.nextInt();  
        int numShadeControls = in.nextInt();
        int numLampsControl =in.nextInt();
        int contador_rs =0;
        // read <alfa0> <length0> <canal0> … <alfaN_1> <lengthN_1> <canalN_1>
        while (contador_rs<numRollerShades) {
            double alpha = in.nextDouble();
            double maxLength = in.nextDouble();
            int channel = in.nextInt();
            RollerShade rollerShade = new RollerShade(channel, alpha, maxLength);
            cloud.addRollerShade(rollerShade);
            contador_rs+=1;
        }
        int contador_l=0;
        while (contador_l<numLamps) {
            int channel = in.nextInt();
            Lamp lamp = new Lamp(channel);
            cloud.addLamp(lamp);
        }
        int contador_crs=0;
        while (contador_crs<numShadeControls) {
            int channel = in.nextInt();
            ShadeControl shadeControl = new ShadeControl(channel, cloud);
            operator.addShadeControl(shadeControl);
        }
        int contador_cl=0;
        while (contador_cl<numLampsControl) {
            int channel = in.nextInt();
            LampControl lampControl = new LampControl(channel, cloud);
            operator.addLampControl(lampControl);
        }
        operator.executeCommands(in, System.out);
    }
}

