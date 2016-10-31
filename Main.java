/**
 * Created by alex-acerpc on 2016-10-27.
 */


import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;

public class Main extends ScanF {


    public static void main(String args[]){
        ScanF scanf = new ScanF();
        Scanner scanner = new Scanner(System.in);
        String filename = scanner.nextLine();
        File file = new File(filename);
        createFlyArray(file);
        createFirstDwellArray(file);
        createSecondDwellArray(file);
        getT(createSecondDwellArray(file));
    }
}

/**
private static int deviation(int n , float tRef, float tMon ){
    int keyStroke;



}

 **/


/**
public static void readStream(){
    FileInputStream file = new FileInputStream();


}

 **/
