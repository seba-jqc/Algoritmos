/**
 * Created by SebastiánAndrés on 26-03-2017.
 */
import java.util.Scanner;


public class Arena {

    public static int[][] matrix_generator(int N){
        // se calcula la cota superior para el tamaño de la fila central
        double size = Math.ceil(Math.sqrt(N));
        if(size%2!=0) {
            // si el valor es impar, se deja como el tamaño de la matriz
            int[][] matriz = new int[(int)size][(int)size];
            return matriz;
        }
        else{
            // si el valor es par, se le suma 1 para hacerlo impar y se crea la matriz
            size+=1;
            int[][] matriz = new int[(int)size][(int)size];
            return matriz;
        }
    }


    public static int repasador(int[][] matriz) {
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
        return avalanchas;
    }

    public static void main(String[] args){
        Scanner granos = new Scanner(System.in);
        System.out.println("Numero de granos (N)?");
        int N = granos.nextInt();
        int[][] matriz = matrix_generator(N);
        int centro = (int) Math.floor(matriz.length/2);
        matriz[centro][centro] = N;
        while(true){
            int av = repasador(matriz);
            if(av==0){
                break;
            }
        }
        repasador(matriz);
        Ventana v = new Ventana(700, "resultado");
        v.mostrarMatriz(matriz);
    }
}
