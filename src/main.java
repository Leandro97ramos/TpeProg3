import java.util.Iterator;
import java.util.List;

public class main {

	public static void main(String[] args) {
		/*
		  
	
		GrafoDirigido<Integer> grafo = new GrafoDirigido<Integer>();
		grafo.agregarVertice(1);
		grafo.agregarVertice(38);
		grafo.agregarVertice(2);
		grafo.agregarVertice(3);
		grafo.agregarVertice(14);
		grafo.agregarVertice(37);
		grafo.agregarVertice(35);
		grafo.agregarVertice(33);
		grafo.agregarVertice(30);

		grafo.agregarArco(3, 1, null);
		grafo.agregarArco(1, 30, null);
		grafo.agregarArco(33, 14, null);
		grafo.agregarArco(3, 33, null);
		grafo.agregarArco(30, 3, null);
		
	    ServicioCaminos<Integer> servicioCaminos = new ServicioCaminos<>(grafo, 3, 33, 4);
	    List<List<Integer>> caminos = servicioCaminos.caminos();
	    for (List<Integer> camino : caminos) {
	        System.out.println(camino);
	    }
	    
		Iterator<Integer> iteradorVertices = grafo.obtenerVertices();
		while (iteradorVertices.hasNext()) {
		    Integer vertice = iteradorVertices.next();
		    System.out.println("Vértice: " + vertice);
		}
	 */
		String path = "data/dataSet.csv";
        CSVReader reader = new CSVReader(path);
        reader.read();



		
        // Obtener resultados del algoritmo Backtracking
        

        // Verificar solución Backtracking
     

	}

}
