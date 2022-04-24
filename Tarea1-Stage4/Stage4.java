import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Stage4 {
    public static void main(String [] args) throws IOException {
        if (args.length != 1) {
            System.out.println("Usage: java Stage4 <configurationFile.txt>");
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
            contador_l+=1;
        }
        //
        int contador_crs=0;
        List<Integer> list_rs = new ArrayList<Integer>();
        while (contador_crs<numRollerShades) {
            int channel = in.nextInt();
            list_rs.add(channel);
            contador_crs+=1;
        }
        list_rs = list_rs.stream().distinct().collect(Collectors.toList());

        
        if (list_rs.size()>numShadeControls) {
            System.out.println("El canal de los controles es incorrecto");
            System.exit(-1);
        }
        for (Integer ch : list_rs) {
            ShadeControl sc = new ShadeControl(ch, cloud);
            operator.addShadeControl(sc);
        }
        //
        int contador_cl=0;
        List<Integer> list_lamps = new ArrayList<Integer>();
        while (contador_cl<numLamps) {
            int channel = in.nextInt();
            list_lamps.add(channel);
            contador_cl+=1;
        }
        list_lamps = list_lamps.stream().distinct().collect(Collectors.toList());

        if (list_lamps.size()>numLampsControl) {
            System.out.println("El canal de los controles es incorrecto");
            System.exit(-1);
        }
        for (Integer ch : list_lamps) {
            LampControl lc = new LampControl(ch, cloud);
            operator.addLampControl(lc);
        }
        operator.executeCommands(in, System.out);
    }
}

