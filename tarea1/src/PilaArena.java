import java.util.Scanner;

/**
 * Created by sebastian on 07-04-17.
 */
public class PilaArena {

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



    public static int avalanche_matrix(int[][] matriz) {
        // se inicializa un contador para las avlanchas
        int avalanchas = 0;
        for (int i = 0; i < matriz.length; i++) {
            // se recorren todas las filas de la matriz
            for (int j = 0; j < matriz.length; j++) {
                // se recorren todas las celdas de la fila
                if (matriz[i][j] >= 4) {
                    // se aplica el criterio de estabilidad y se suma 1 al numero de avalanchas
                    matriz[i + 1][j] += 1;
                    matriz[i - 1][j] += 1;
                    matriz[i][j + 1] += 1;
                    matriz[i][j - 1] += 1;
                    matriz[i][j] -= 4;
                    avalanchas += 1;
                }
            }
        }
        // se devuelve el numero de avalanchas
        return avalanchas;
    }

    public static void main(String[] args){
        Scanner granos = new Scanner(System.in);
        // se solicita el numero de granos al ususario
        System.out.println("Numero de granos (N)?");
        int N = granos.nextInt();
        // se genera la matriz con el tamaño necesario
        int[][] matriz = matrix_generator(N);
        // se depositan los granos de arena en el centro
        int centro = (int) Math.floor(matriz.length/2);
        matriz[centro][centro] = N;
        // se recorre la matriz hasta que ya no se produzcan mas avalanchas
        while(true){
            int av = avalanche_matrix(matriz);
            if(av==0){
                break;
            }
        }
        // finalmente, se muestra la distribucion final de los granos de arena
        Ventana v = new Ventana(800, "resultado");
        v.mostrarMatriz(matriz);
    }
}
