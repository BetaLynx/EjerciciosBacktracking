public class Ejercicio24 {
    public static boolean[]subcSuma0MaxElem (int[] v) {
        boolean[] mejorSolucion = new boolean[v.length];
        Entero numElemMejor = new Entero(0);
        boolean[] posibleSolucion = new boolean[v.length];
        int numElemPosible = 0;

        for(int i = 0; i < v.length; i++) {
            mejorSolucion[i] = false;
            posibleSolucion[i] = false;
        }

        subcSuma0MaxElemAux(v,mejorSolucion,numElemMejor,posibleSolucion,numElemPosible,0,0);

        return mejorSolucion;
    }

    private static void subcSuma0MaxElemAux(int[] v, boolean[] mejorSolucion, Entero numElemMejor, boolean[] posibleSolucion, int numElemPosible, int suma, int nivel) {
        if(nivel == v.length) { //Nodo hojawa
            if(numElemMejor.getValor() < numElemPosible && suma == 0) { //En caso de ser posible solución la mejor solución actualizamos mejor solución
                numElemMejor.setValor(numElemPosible);
                for(int i = 0; i < v.length; i++) {
                    mejorSolucion[i] = posibleSolucion[i];
                }
            }
        } else { //Nodo intermedio
            for(int i = 0; i < 2; i++) {
                posibleSolucion[nivel] = i == 1;
                numElemPosible = numElemPosible + i * 1;
                suma = suma + i * v[nivel];
                nivel++;
                subcSuma0MaxElemAux(v,mejorSolucion,numElemMejor,posibleSolucion,numElemPosible,suma,nivel);
                //En solución óptima siempre se desanota
                nivel--;
                suma = suma - i * v[nivel];
                numElemPosible = numElemPosible - i * 1;
                posibleSolucion[nivel] = false;
            }
        }
    }
}
