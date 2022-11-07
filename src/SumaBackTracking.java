public class SumaBackTracking {
    public static boolean subconjuntoSuma(int[] v, int valor) {
        Booleano resultado = new Booleano(false);
        int suma = 0;
        subConjuntoSumaBack(v,valor,suma,0,resultado);
        return resultado.getValor();
    }

    //Solo nodos hoja como solución
    public static void subConjuntoSumaBack(int[] v, int valor, int suma, int nivel, Booleano resultado) {
        if(nivel == v.length) {
            if(suma == valor) {
                resultado.setValor(true);
            }
        }else {
            int i = 0;
            while(i < 2 && !resultado.getValor()) {
                suma += v[nivel] * i;
                nivel++;
                subConjuntoSumaBack(v,valor,suma,nivel,resultado);
                if(!resultado.getValor()) {
                    suma -= v[nivel] * i;
                }
                i++;
            }
        }
    }

    //Cualquier nodo puede ser solución
    public static void subConjuntoSumaBack2(int[] v, int valor, int suma, int nivel, Booleano resultado) {
        if(valor == suma) {
            resultado.setValor(true);
        }else if (nivel < v.length) {
            int i = 0;
            while(i < 2 && !resultado.getValor()) {
                suma += v[nivel] * i;
                nivel++;
                subConjuntoSumaBack(v, valor, suma, nivel, resultado);
                if (!resultado.getValor()) {
                    suma -= v[nivel] * i;
                }
                i++;
            }
        }
    }

}
