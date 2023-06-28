import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class Backtracking {

    private List<Arco<Integer>> mejorRuta;
    private int menorDistancia;
    private int cantidadEstaciones;
    private int combinaciones;

    public List<Arco<Integer>> backtr(GrafoDirigido<Integer> grafo) {
        List<Arco<Integer>> tuneles = grafo.obtenerListArcos();
        List<Arco<Integer>> parcial = new ArrayList<>();
        mejorRuta = new ArrayList<>();
        menorDistancia = Integer.MAX_VALUE;
        cantidadEstaciones = grafo.cantidadVertices();

        back(parcial, 0, tuneles);

        return mejorRuta;
    }

    private void back(List<Arco<Integer>> parcial, int i, List<Arco<Integer>> tuneles) {
         combinaciones++;
        if (i == tuneles.size()) {
            if (esSolucion(parcial) && calcularDistancia(parcial) < menorDistancia) {
                mejorRuta = new ArrayList<>(parcial);
                menorDistancia = calcularDistancia(parcial);
            }
        } else {
            Arco<Integer> tunel = tuneles.get(i);

            parcial.add(tunel);
            back(parcial, i + 1, tuneles);
            parcial.remove(tunel);

            back(parcial, i + 1, tuneles);
        }
    }

    private boolean esSolucion(List<Arco<Integer>> parcial) {
        UnionFind uf = new UnionFind(cantidadEstaciones);
        for (Arco<Integer> tunel : parcial) {
            uf.union(tunel.getVerticeOrigen() - 1, tunel.getVerticeDestino() - 1);
        }

        // Verificar que todas las estaciones estén conectadas directamente
        return uf.componentesConectados() == 1 && parcial.size() == cantidadEstaciones - 1;
    }

    private int calcularDistancia(List<Arco<Integer>> parcial) {
        int distancia = 0;
        for (Arco<Integer> tunel : parcial) {
            distancia += tunel.getEtiqueta();
        }
        return distancia;
    }

    public int getCombinaciones() {
        return combinaciones;
    }
}
