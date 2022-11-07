public class SumaSelecciónOptima {

    /**
        En este caso, la solución óptima es un subconjunto con el menos número de elementos
     */

    public static boolean[] subconjuntoSuma(int[] v, int valor) {
        boolean[] mejorResultado = new boolean[v.length];
        //el resultado que vamos a mandar
        boolean[] posibleResultado = new boolean[v.length];
        //uno de los posibles resultados que se van a ir generando durante la ejecución(PUEDE SER O NO PUEDE SER LA MEJOR SOLUCIÓN)
        Entero numElementosMejor = new Entero(Integer.MAX_VALUE);
        //Si queremos maximizar el número de elementos inicializamos a 0 en caso de minimizar el número de elementos utilizaremos Integer.MAX_VALUE
        int numElementosPosible = 0, suma = 0, sumaTotal = 0;
        //NumElementos posible controla el número de elementos que tenemos en posibleResultado

        for(int i = 0; i < v.length; i++) {
            sumaTotal += v[i];
        }

        if(sumaTotal >= valor){
            subConjuntoSumaOpt(v, valor, mejorResultado,numElementosMejor,posibleResultado,numElementosPosible,suma,0);
        }
        return mejorResultado;
    }

    public static void subConjuntoSumaOpt(int[] v, int valor, boolean[] mejorResultado, Entero numElemMejor, boolean[] posibleResultado, int numElemPosible, int suma, int nivel){
        if(nivel == v.length) {
            if(numElemPosible <  numElemMejor.getValor() && suma == valor) {
                numElemMejor.setValor(numElemPosible);
                for(int i = 0; i < posibleResultado.length; i++) {
                    mejorResultado[i] = posibleResultado[i];
                }
            }
        }else {
            for(int i = 0; i < 2; i++) {
                posibleResultado[nivel] = i == 1;
                suma += v[nivel] * i;
                numElemPosible += i;
                nivel++;
                if(numElemPosible < numElemMejor.getValor()) {
                   subConjuntoSumaOpt(v,valor,mejorResultado,numElemMejor,posibleResultado,numElemPosible,suma,nivel);
                }
                nivel--;
                numElemPosible -= i;
                suma -= v[nivel] * i;
                posibleResultado[nivel] = false;
            }
        }
    }
}
