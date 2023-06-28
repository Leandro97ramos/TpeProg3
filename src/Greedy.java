import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Iterator;



public class Greedy {

    public List<Arco<Integer>> encontrarRutaOptima(GrafoDirigido<Integer> grafo) {
        List<Arco<Integer>> rutaOptima = new ArrayList<>();
        Set<Integer> estacionesVisitadas = new HashSet<>();
        int distanciaTotal = 0;

        int estacionActual = 1; // Comenzar en la estación 1

        while (estacionesVisitadas.size() < grafo.cantidadVertices() - 1) {
            
            List<Arco<Integer>> arcosDisponibles = grafo.obtenerArcosAdyacentes(estacionActual);
            Arco<Integer> mejorArco = null;
            int mejorDistancia = Integer.MAX_VALUE;

            for (Arco<Integer> arco : arcosDisponibles) {
                int estacionDestino = arco.getVerticeDestino();
                if (!estacionesVisitadas.contains(estacionDestino)) {
                    int distanciaArco = arco.getEtiqueta();
                    if (distanciaArco < mejorDistancia) {
                        mejorArco = arco;
                        mejorDistancia = distanciaArco;
                    }
                }
            }

            if (mejorArco != null) {
                rutaOptima.add(mejorArco);
                estacionesVisitadas.add(mejorArco.getVerticeDestino());
                distanciaTotal += mejorDistancia;
                estacionActual = mejorArco.getVerticeDestino();
            } else {
                break; // No hay más arcos disponibles, terminar el algoritmo
            }
        }

        System.out.println("Distancia total de la ruta óptima (greedy): " + distanciaTotal);
        return rutaOptima;
    }
}














/*
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



 
 */