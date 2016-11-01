/**
 * Created by alex-acerpc on 2016-10-27.
 */

import java.io.File;
import java.util.Scanner;

public class Main extends ScanF {

    public static void main(String args[]){
        double deviation ;
        double bisect1 ;
        double bisect2 ;
        int counter = 0;
        // Comparing userA w/  file userA.txt
        int falseReject = 0;
        // Comparing userA w/ file !(userA.txt)
        System.out.println("Enter input threshold:\t");
        Scanner scanner = new Scanner(System.in);
        int threshold = Integer.parseInt(scanner.nextLine());
        System.out.println("Threshold set to:\t" + threshold);


        ScanF scanf = new ScanF();
        System.out.println("Enter user filename");
        scanner = new Scanner(System.in);
        String filename = scanner.nextLine();
        File file = new File(filename);


        int[] dwellArray = createFirstDwellArray(file);
        int[] flyArray = createFlyArray(file);
        int[] user1Fly = getTref(flyArray);
        int[] user1Dwell = getTref(dwellArray);


        System.out.println("Deviations:");
        for(int i = 0 ; i <5 ; i++){
            counter++;
            bisect1 = getDeviationD(getTref(flyArray),getMon(flyArray,i));
            bisect2 = getDeviationM(getTref(dwellArray) ,getMon(dwellArray, i));
            deviation = getDeviation(bisect1 ,bisect2);
            System.out.println(i+":\t" + deviation);
            if(threshold < deviation){
                falseReject+= 1;
            }
        }
        System.out.println("False reject is " + falseReject/(double)counter);

        //CHECK FOR FALSE ACCEPT
        int falseAccept = 0;
        int falseAcceptCounter = 0;
        for(int j = 0; j <4 ; j++){
            System.out.println("Enter new user filename");
            scanner = new Scanner(System.in);
            filename = scanner.nextLine();
            File newFile = new File(filename);

            dwellArray = createFirstDwellArray(newFile);
            flyArray = createFlyArray(newFile);
            System.out.println("Deviations:");
            for(int k = 0 ; k <5 ; k++){
                counter++;
                bisect1 = getDeviationD(user1Fly,getMon(flyArray,k));
                bisect2 = getDeviationM(user1Dwell ,getMon(dwellArray, k));
                deviation = getDeviation(bisect1 ,bisect2);
                System.out.println(k+":\t" + deviation);
                if(threshold < deviation){
                    falseAccept+= 1;
                }
                falseAcceptCounter++;
            }
        }
        System.out.println("False accept is " + falseAccept/(double)falseAcceptCounter);
    }
}
