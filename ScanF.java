import java.io.File;
import java.util.Scanner;

/**
 * Created by alex-acerpc on 2016-10-29.
 */
public class ScanF{
    public ScanF(){
        try {
            String curDir = System.getProperty("user.dir");
            System.out.println(curDir);
            Scanner scanner = new Scanner(System.in);
            System.out.println("Input filename");
            File file = new File(scanner.nextLine());
            scanner = new Scanner(file);
            for(int i = 0 ; i < 3 ; i++ ) {
                String firstLine = scanner.nextLine();
                System.out.println(firstLine);
            }
            int j=0;
            while(scanner.hasNext()){
                String line = scanner.nextLine();
                //System.out.println(line);
                j++;
            }
            //System.out.printf()
            System.out.println(j);
            scanner.close();
        }

        catch(Exception e){
            e.printStackTrace();
        }
    }
}
