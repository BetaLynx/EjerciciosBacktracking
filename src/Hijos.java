public class Hijos {
    //El 10 de agosto del año 1843, Lotario I, Luis el Germánico
    //y Carlos el Calvo (hijos de Ludovico Pio y nietos de Carlomagno) plantean en
    //Verdún la posibilidad de llegar a un pacto (el conocido como tratado de Verdún)
    //para repartir la vasta herencia de Carlomagno y poner así fin a la larga guerra
    //civil carolingia. Con el fin de facilitar el acuerdo, se nos pide implementar un
    //algoritmo de backtracking que permita determinar si es posible realizar un
    //reparto equitativo:

    public boolean hayRepartoEquitativo(int[] bienes) {
        boolean solución = false;
        int suma = 0, repartido;
        for(int i = 0; i < bienes.length; i++) {
            suma += bienes[i];
        }

        repartido = suma /3;

        if(suma % 3 == 0) { //Puede repartirse
            Booleano haySolucion = new Booleano(false);
            int[] sumaBienesHijos = new int[3];
            for(int i = 0; i < 3; i++) {
                sumaBienesHijos[i] = 0;
            }
            hayRepartoEquitativoAux(bienes, repartido, haySolucion,sumaBienesHijos, 0);
            solución = haySolucion.getValor();
        }
        return solución;
    }

    public void hayRepartoEquitativoAux(int[] bienes, int repartido, Booleano pollaAsquerosa, int[] sumaBienesHijos, int nivel) {
        if(nivel == bienes.length) { //Nodo hoja
            if(repartido == sumaBienesHijos[0] && repartido == sumaBienesHijos[1] && repartido == sumaBienesHijos[2]) {
                pollaAsquerosa.setValor(true);
            }
        }else{ //Nodo intermedio
            int c = 0;
            while(c < 3 && !pollaAsquerosa.getValor()) {
                sumaBienesHijos[c] += bienes[nivel];
                nivel++;
                hayRepartoEquitativoAux(bienes,repartido,pollaAsquerosa,sumaBienesHijos,nivel);
                if(!pollaAsquerosa.getValor()){ //no se encontró la solución
                    nivel--;
                    sumaBienesHijos[c] -= bienes[nivel];
                }
                c++;
            }
        }
    }
}
