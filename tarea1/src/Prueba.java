/**
 * Created by SebastiánAndrés on 01-04-2017.
 */
import java.util.Arrays;
import java.util.Scanner;
public class Prueba {

    public static double dimension(int N) {
        double size = Math.ceil(Math.sqrt(2 * N - 0.5));
        if (size % 2 != 0)
            return size;
        else
            return (size + 1);
    }


    public static void main(String[] args){
        System.out.println((int)dimension(4));
    }
}