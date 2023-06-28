import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Iterator;



public class Greedy {
    private int combinaciones;
    public List<Arco<Integer>> encontrarRutaOptima(GrafoDirigido<Integer> grafo) {
        List<Arco<Integer>> tunelesGreedy = new ArrayList<>();
    
        List<Integer> estacionesConectadas = new ArrayList<>();
        Iterator<Integer> verticesIterator = grafo.obtenerVertices();
    
        while (verticesIterator.hasNext()) {
            int estacionActual = verticesIterator.next();
            int estacionMasCercana = encontrarEstacionMasCercana(grafo, estacionActual, estacionesConectadas);
            combinaciones++;
            if (estacionMasCercana != -1) {
                int distancia = obtenerDistancia(grafo, estacionActual, estacionMasCercana);
    
                Arco<Integer> tunel = new Arco<>(estacionActual, estacionMasCercana, distancia);
                tunelesGreedy.add(tunel);
    
                estacionesConectadas.add(estacionMasCercana);
            }
        }
    
        // Retornar los resultados
        return tunelesGreedy;
    }
    
    private int encontrarEstacionMasCercana(GrafoDirigido<Integer> grafo, int estacionActual,
            List<Integer> estacionesConectadas) {
        int estacionMasCercana = -1;
        int distanciaMinima = Integer.MAX_VALUE;
    
        Iterator<Integer> adyacentesIterator = grafo.obtenerAdyacentes(estacionActual);
    
        while (adyacentesIterator.hasNext()) {
            int estacion = adyacentesIterator.next();
    
            if (!estacionesConectadas.contains(estacion)) {
                int distancia = obtenerDistancia(grafo, estacionActual, estacion);
    
                if (distancia <= distanciaMinima) {
                    distanciaMinima = distancia;
                    estacionMasCercana = estacion;
                }
            }
        }
    
        return estacionMasCercana;
    }
    
    private int obtenerDistancia(GrafoDirigido<Integer> grafo, int verticeActual, int verticeAdy) {
        // Obtener los arcos del grafo
        Arco<Integer> arco = grafo.obtenerArco(verticeActual, verticeAdy);
    
        if (arco != null) {
            // Obtener la distancia del arco
            int distancia = arco.getEtiqueta();
            return distancia;
        } else {
            return 0; 
        }
    }
    public int getCombinaciones() {
        return combinaciones;
    }
}    
 














/*



 
 */