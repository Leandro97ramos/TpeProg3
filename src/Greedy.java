import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class Greedy {

   public List<Integer> solve(GrafoDirigido<Integer> grafo) {
    List<Integer> tunelesGreedy = new ArrayList<>();
    int metrosTotales = 0;

    List<Integer> estacionesConectadas = new ArrayList<>();
    Iterator<Integer> verticesIterator = grafo.obtenerVertices();

    while (verticesIterator.hasNext()) {
        int estacionActual = verticesIterator.next();
        int estacionMasCercana = encontrarEstacionMasCercana(grafo, estacionActual, estacionesConectadas);
        
        if (estacionMasCercana != -1) {
            int distancia = obtenerDistancia(grafo, estacionActual, estacionMasCercana);
            metrosTotales += distancia;

            tunelesGreedy.add(estacionActual);
            tunelesGreedy.add(estacionMasCercana);

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
            // Manejar el caso en el que no existe un arco entre los vértices
            // Puedes devolver un valor predeterminado o lanzar una excepción según tu
            // necesidad
            return 0; // Por ejemplo, devolver 0 si no hay arco
        }
    }
    
}
