/**
 * Created by SebastiánAndrés on 26-03-2017.
 */
import java.util.Scanner;


public class Arena {

    public static double dimension(int N){
        double size = Math.ceil(Math.sqrt(2*(N-0.5)));
        if(size%2!=0)
            return size;
        else
            return size+1;
    }


    public static int[][] repasador(int[][] matriz) {
        int avalanchas = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                if (matriz[i][j] >= 4) {
                    matriz[i + 1][j] += 1;
                    matriz[i - 1][j] += 1;
                    matriz[i][j + 1] += 1;
                    matriz[i][j - 1] += 1;
                    matriz[i][j] -= 4;
                    avalanchas += 1;
                }
            }
        }
        if (avalanchas==0)
            return matriz;
        else
            return repasador(matriz);
    }

    public static void main(String[] args){
        Scanner granos = new Scanner(System.in);
        System.out.println("Numero de granos (N)?");
        int N = granos.nextInt();
        double dimen = dimension(N);
        int dim = (int) dimen;
        int[][] matriz = new int[dim][dim];
        int centro = (int) Math.floor(dimen/2);
        matriz[centro][centro] = N;
        repasador(matriz);
        Ventana v = new Ventana(800, "resultado");
        v.mostrarMatriz(matriz);
    }
}
