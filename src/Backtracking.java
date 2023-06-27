import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class Backtracking {

    public List<Integer> backtr(GrafoDirigido<Integer> grafo) {
        List<Integer> rutaActual = new ArrayList<>();
        List<Integer> mejorRuta = new ArrayList<>();
        int distanciaActual = Integer.MAX_VALUE;
        int mejorDistancia = Integer.MAX_VALUE;

        // Obtener los vértices del grafo
        Iterator<Integer> verticesIterator = grafo.obtenerVertices();
        while (verticesIterator.hasNext()) {
            Integer verticeAdy = verticesIterator.next();
            backtra(grafo, verticeAdy, rutaActual, mejorRuta, distanciaActual, mejorDistancia);
        }


        return mejorRuta;
    }

    private void backtra(GrafoDirigido<Integer> grafo, int verticeActual, List<Integer> rutaActual,
            List<Integer> mejorRuta, int distanciaActual, int mejorDistancia) {

        // Agregar el vértice actual a la ruta actual
        rutaActual.add(verticeActual);

        // Verificar si se ha alcanzado el destino (última estación)
        if (rutaActual.size() == grafo.cantidadVertices()) {
            // Calcular la distancia total de la ruta actual
            distanciaActual += calcularDistanciaRuta(grafo, rutaActual);

            // Actualizar la mejor ruta y distancia si es mejor que la anterior
            if (distanciaActual < mejorDistancia) {
                mejorRuta.clear();
                mejorRuta.addAll(rutaActual);
                mejorDistancia = distanciaActual;
            }
        } else {
            Iterator<Integer> adyacentesIterator = grafo.obtenerAdyacentes(verticeActual);
            while (adyacentesIterator.hasNext()) {
                Integer adyacente = adyacentesIterator.next();
                if (!rutaActual.contains(adyacente)) {
                    int distancia = obtenerDistancia(grafo, verticeActual, adyacente);

                    distanciaActual += distancia;

                    backtra(grafo, adyacente, rutaActual, mejorRuta, distanciaActual, mejorDistancia);

                    distanciaActual -= distancia;
                    rutaActual.remove(rutaActual.size() - 1);
                }
            }
        }
    }

    private int obtenerDistancia(GrafoDirigido<Integer> grafo, int verticeActual, int verticeAdy) {
        // Obtener los arcos del grafo
        Arco<Integer> arco = grafo.obtenerArco(verticeActual, verticeAdy);
        // Obtener la distancia del arco
        int distancia = arco.getEtiqueta();

        return distancia;

    }

    private int calcularDistanciaRuta(GrafoDirigido<Integer> grafo, List<Integer> ruta) {
        int distanciaTotal = 0;
        for (int i = 0; i < ruta.size() - 1; i++) {
            int origen = ruta.get(i);
            int destino;
            if (i == ruta.size() - 1) {
                destino = ruta.get(0);
            } else {
                destino = ruta.get(i + 1);
            }

            Arco<Integer> arco = grafo.obtenerArco(origen, destino);
            distanciaTotal += arco.getEtiqueta();
        }

        return distanciaTotal;
    }

}

/*
 
    public class Backtracking {

    public List<Integer> backtr(GrafoDirigido<Integer> grafo) {
        List<Integer> rutaActual = new ArrayList<>();
        List<Integer> mejorRuta = new ArrayList<>();
        int distanciaActual = Integer.MAX_VALUE;
        int mejorDistancia = Integer.MAX_VALUE;

        Iterator<Integer> verticesIterator = grafo.obtenerVertices();
        List<Integer> vertices = new ArrayList<>();
        while (verticesIterator.hasNext()) {
            vertices.add(verticesIterator.next());
        }

        for (Integer vertice : vertices) {
            backtra(grafo, vertice, rutaActual, mejorRuta, distanciaActual, mejorDistancia);
        }

        return mejorRuta;
    }

    private void backtra(GrafoDirigido<Integer> grafo, int verticeActual, List<Integer> rutaActual,
            List<Integer> mejorRuta, int distanciaActual, int mejorDistancia) {
        rutaActual.add(verticeActual);

        if (rutaActual.size() == grafo.cantidadVertices()) {
            distanciaActual += calcularDistanciaRuta(grafo, rutaActual);

            if (distanciaActual < mejorDistancia) {
                mejorRuta.clear();
                mejorRuta.addAll(rutaActual);
                mejorDistancia = distanciaActual;
            }
        } else {
            Iterator<Integer> adyacentesIterator = grafo.obtenerAdyacentes(verticeActual);
            while (adyacentesIterator.hasNext()) {
                Integer adyacente = adyacentesIterator.next();
                if (!rutaActual.contains(adyacente)) {
                    int distancia = obtenerDistancia(grafo, verticeActual, adyacente);

                    distanciaActual += distancia;

                    backtra(grafo, adyacente, rutaActual, mejorRuta, distanciaActual, mejorDistancia);

                    distanciaActual -= distancia;
                    rutaActual.remove(rutaActual.size() - 1);
                }
            }
        }
    }

    private int obtenerDistancia(GrafoDirigido<Integer> grafo, int verticeActual, int verticeAdy) {
        Arco<Integer> arco = grafo.obtenerArco(verticeActual, verticeAdy);
        int distancia = arco.getEtiqueta();
        
        return distancia;
    }

    private int calcularDistanciaRuta(GrafoDirigido<Integer> grafo, List<Integer> ruta) {
        int distanciaTotal = 0;
        for (int i = 0; i < ruta.size() - 1; i++) {
            int origen = ruta.get(i);
            int destino;
            if (i == ruta.size() - 1) {
                destino = ruta.get(0);
            } else {
                destino = ruta.get(i + 1);
            }

            Arco<Integer> arco = grafo.obtenerArco(origen, destino);
            distanciaTotal += arco.getEtiqueta();
        }
        
        return distanciaTotal;
    }

}


 */