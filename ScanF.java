import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by alex-acerpc on 2016-10-29.
 */
public class ScanF {
    public ScanF() {

        String filename;

    }

    /**
     * Extracts dwell value from the user file
     * @param f file being read
     * @return an array contain all 1st Dwell values
     */
    public static int[] createFirstDwellArray(File f) {
        int[] holder = new int[3000];
        int counter = 0;

        try {
            Scanner scanner = new Scanner(f);
            String line2 = scanner.nextLine();
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                String[] array = line.split("\t");
                // parses the Dwell time as an integer into an array
                holder[counter] = Integer.parseInt(array[9]);
                counter++;
            }
            //     System.out.println(Arrays.toString(holder));
            scanner.close();
            return holder;
        } catch (Exception e) {
            e.getCause();
            return holder;
        }
    }

    /**
     * Similar to createFirstDwellArray but for fly time
     * @param f
     * @return
     */
    public static int[] createFlyArray(File f) {
        int[] holder = new int[3000];
        int counter = 0;
        try {
            Scanner scanner = new Scanner(f);
            String lineHeader = scanner.nextLine();
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                String[] array = line.split("\t");
                // parses fly time into int and then into an array
                holder[counter] = Integer.parseInt(array[5]);
                counter++;
            }
            scanner.close();
            return holder;
        } catch (Exception e) {
            e.getCause();
            return holder;
        }
    }


    /**
     * Similar to createFirstDwellArray but for second dwell time
     * @param f
     * @return
     */
    public static int[] createSecondDwellArray(File f) {
        int[] holder = new int[3000];
        int counter = 0;

        try {
            Scanner scanner = new Scanner(f);
            String line2 = scanner.nextLine();
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                String[] array = line.split("\t");
                // parses the Dwell time as an integer into an array
                holder[counter] = Integer.parseInt(array[13]);
                counter++;
            }
            scanner.close();
            return holder;
        } catch (Exception e) {
            e.getCause();
            return holder;
        }
    }

    /**
     * Creates an array size 500
     * @param a Array to split from originally
     * @return new array
     */
    public static int[] getTref(int[] a) {
        int[] array = new int[500];
        for (int i = 0; i < 500; i++) {
            array[i] = a[i];
        }
        return array;
    }


    /**
     * Returns the tMon array
     *
     * @param a array being broken appart
     * @param b switch for the case
     * @return a new array size 500
     */
    public static int[] getMon(int[] a, int b) {
        int[] array = new int[500];
        int counter;

        if (b == 0) {
          //  System.out.println("0");
            counter = 0;
            for (int i = 500; i < 1000; i++) {
                array[counter] = a[i];
                //        System.out.println("counter: "+counter+"\ti: "+i+"\tarray[c]: " +array[counter]);
                counter++;
            }
        }
        if (b == 1) {
         //   System.out.println("1");
            counter = 0;
            for (int i = 1000; i < 1500; i++) {
                array[counter] = a[i];
                //      System.out.println("counter: "+counter+"\ti: "+i+"\tarray[c]: " +array[counter]);
                counter++;
            }
        }
        if (b == 2) {
          //  System.out.println("2");
            counter = 0;
            for (int i = 1500; i < 2000; i++) {
                array[counter] = a[i];
                //    System.out.println("counter: "+counter+"\ti: "+i+"\tarray[c]: " +array[counter]);
                counter++;
            }
        }

        if (b == 3) {
          //  System.out.println("3");
            counter = 0;
            for (int i = 2000; i < 2500; i++) {
                array[counter] = a[i];
                //  System.out.println("counter: "+counter+"\ti: "+i+"\tarray[c]: " +array[counter]);
                counter++;
            }
        }
        if (b == 4) {
       //     System.out.println("4");
            counter = 0;
            for (int i = 2500; i < 3000; i++) {
                array[counter] = a[i];
                //System.out.println("counter: "+counter+"\ti: "+i+"\tarray[c]: " +array[counter]);
                counter++;
            }
        }
        return array;
    }

    /**
     * Calculates 1st half of the D function
     * @param a ref array
     * @param b comparison array
     * @return half of the value to be completed in getDeviation()
     */
    public static double getDeviationD(int[] a, int[] b) {
        int instructions = 500;
        double bisect = 0;
        double temp = 0;
        for (int i : a) {
            temp += Math.abs((a[i] - b[i]) / (double) b[i]);
        }
        bisect = temp / (instructions - 1);
        return bisect;
    }

    /**
     * Calculates 2nd half of D function
     * @param a ref array
     * @param b comparison array
     * @return half of the value to be completed in getDeviation()
     */
    public static double getDeviationM(int[] a, int[] b) {
        int instructions = 500;
        double bisect = 0;
        double temp = 0;
        for (int i : a) {
            temp += Math.abs((a[i] - b[i]) / (double) b[i]);
        }
        bisect = temp / instructions;
        return bisect;
    }

    /**
     * Assembles the deviation value
     * @param a bisect1 where n = n -1
     * @param b bisect1 where n = n
     * @return the final value
     */
    public static double getDeviation(double a, double b) {
        double finalD;
        finalD = (a + b) * 50;
        return finalD;
    }

}
