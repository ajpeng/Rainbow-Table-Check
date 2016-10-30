/**
 * Created by alex-acerpc on 2016-10-28.
 */
public class Function {

    private int n; // this is the counter for the number of keystrokes
    private float tRef;
    private float tMon;
    private static int numberOfFunctions = 0;
    public Function(int a, float b, float c) {

        n = a;
        tRef = b;
        tMon = c;
    }

    public float getNumOfStrokes(){
        return n;
    }

    public float getRef() {
        return tRef;
    }

    public float getMon() {
        return tMon;
    }

    private void setN(int in){
         n = in;
    }

    private void setRef(float in) {
        tRef = in;
    }

    private void setMon(float in) {
        tMon = in;

    }



}
