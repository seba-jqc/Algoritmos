public class Main {
    public static int repasador(int[][] matriz) {
        int avalanchas = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                if (matriz[i][j] >= 4) {
                    matriz[i + 1][j] += 1;
                    matriz[i - 1][j] += 1;
                    matriz[i][j - 1] += 1;
                    matriz[i][j - 1] += 1;
                    avalanchas += 1;
                }
            }
        }
        return avalanchas;
    }

    public static void main(String[] args) {

            int[][] mat = new int[5][5];
            int[][] alemania = {
                    {3,3,3},
                    {2,2,2},
                    {0,0,0}
            };
            Ventana v = new Ventana(500,"Matriz de ejemplo");
            v.mostrarMatriz(mat);

        }

    }

