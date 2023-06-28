import java.util.Iterator;
import java.util.List;

public class main {

	public static void main(String[] args) {
		/*
		 * 
		 * 
		 * GrafoDirigido<Integer> grafo = new GrafoDirigido<Integer>();
		 * grafo.agregarVertice(1);
		 * grafo.agregarVertice(38);
		 * grafo.agregarVertice(2);
		 * grafo.agregarVertice(3);
		 * grafo.agregarVertice(14);
		 * grafo.agregarVertice(37);
		 * grafo.agregarVertice(35);
		 * grafo.agregarVertice(33);
		 * grafo.agregarVertice(30);
		 * 
		 * grafo.agregarArco(3, 1, null);
		 * grafo.agregarArco(1, 30, null);
		 * grafo.agregarArco(33, 14, null);
		 * grafo.agregarArco(3, 33, null);
		 * grafo.agregarArco(30, 3, null);
		 * 
		 * ServicioCaminos<Integer> servicioCaminos = new ServicioCaminos<>(grafo, 3,
		 * 33, 4);
		 * List<List<Integer>> caminos = servicioCaminos.caminos();
		 * for (List<Integer> camino : caminos) {
		 * System.out.println(camino);
		 * }
		 * 
		 * Iterator<Integer> iteradorVertices = grafo.obtenerVertices();
		 * while (iteradorVertices.hasNext()) {
		 * Integer vertice = iteradorVertices.next();
		 * System.out.println("Vértice: " + vertice);
		 * }
		 */

		 /*llamo a CsvReader */
		String path = "data/dataSet.csv";
		CSVReader reader = new CSVReader(path);
		GrafoDirigido<Integer> grafo = reader.read();

		Backtracking backtracking = new Backtracking();
		List<Arco<Integer>> rutaOptimaBacktracking = backtracking.backtr(grafo);
		System.out.println("Combinaciones de backtracking: " + backtracking.getCombinaciones());
		for (Arco<Integer> tunel : rutaOptimaBacktracking) {
			System.out.println("EstacionA: " + tunel.getVerticeOrigen());
			System.out.println("EstacionB: " + tunel.getVerticeDestino());
			System.out.println("Distancia: " + tunel.getEtiqueta());
			System.out.println();
		}
		//combinaicones de backtracking

		Greedy greedy = new Greedy();
		List<Arco<Integer>> rutaOptimaGreedy = greedy.encontrarRutaOptima(grafo);
		System.out.println("Combinaciones de greedy: " + greedy.getCombinaciones());
		for (Arco<Integer> tunel : rutaOptimaGreedy) {
			System.out.println("EstacionA: " + tunel.getVerticeOrigen());
			System.out.println("EstacionB: " + tunel.getVerticeDestino());
			System.out.println("Distancia: " + tunel.getEtiqueta());
			System.out.println();
		}
		//combinaciones de greedy
		

	

	}

}
