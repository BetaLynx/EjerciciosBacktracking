public class Caballo {

    public static void main(String[] args) {
        int[][] tablero = new int[7][7];

        for(int i = 0; i < tablero.length; i++) {
            for(int j = 0; j < tablero.length; j++) {
                tablero[i][j] = -1;
            }
        }

        caballero(tablero,2,2);

        for(int i = 0; i < tablero.length; i++) {
            for(int j = 0; j < tablero.length; j++) {
                System.out.print(tablero[i][j] + "\t");
            }
            System.out.println();
        }
    }

    /*
         -2 -1  0  1  2 (x)
        2    0     1
        1 7           2
        0       c
       -1 6           3
       -2    5     4
       (y)
     */

    public static void caballero(int[][] tablero, int xIni, int yIni) {
        int[] x = new int[] {-1,1,2,2,1,-1,-2,-2};
        int[] y = new int[] {2,2,1,-1,-2,-2,-1,1};
        tablero[xIni][yIni] = 0;
        int numMovimientos = 1;
        Booleano terminado = new Booleano(false); //Variable para indicar si hemos terminado o no la ejecución dentro del backtracking
        caballeroAux(tablero, xIni, yIni, numMovimientos, x, y, terminado);
    }

    public static void caballeroAux(int[][] tablero, int xActual, int yActual, int numMovimientos, int[] x, int[] y, Booleano terminado) {
        if(numMovimientos == tablero.length*tablero.length) {
            terminado.setValor(true);
        }else {
            int i = 0;
            while(i < x.length && !terminado.getValor()) {
                int xNueva = xActual + x[i], yNueva = yActual + y[i];
                if(candidatoCorrecto(tablero, xNueva, yNueva)) {
                    tablero[xNueva][yNueva] = numMovimientos;
                    numMovimientos++;
                    caballeroAux(tablero, xNueva, yNueva, numMovimientos, x, y, terminado);
                    if(!terminado.getValor()) {
                        numMovimientos--;
                        tablero[xNueva][yNueva] = -1;
                    }
                }
                i++;
            }
        }
    }

    public static boolean candidatoCorrecto(int[][] tablero, int x, int y) {
        boolean resultado = false;
        if(x >= 0 && x < tablero.length && y >= 0 && y < tablero.length){
            resultado = tablero[x][y] == -1;
        }
        return resultado;
    }
}
