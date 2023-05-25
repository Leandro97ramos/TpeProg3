import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ServicioCaminos<T> {

	private Grafo<Integer> grafo;
	private int origen;
	private int destino;
	private int lim;
	
	// Servicio caminos
	public ServicioCaminos(Grafo<Integer> grafo, int origen, int destino, int lim) {
		this.grafo = grafo;
		this.origen = origen;
		this.destino = destino;
		this.lim = lim;
	}

	public List<List<Integer>> caminos() {
		//un array de caminos
		List<List<Integer>> caminos = new ArrayList<>();
		//almaceno el camino recorrido
		List<Integer> caminoActual = new ArrayList<>();
		
		caminoActual.add(origen);
		Set<Arco<Integer>> arcosVisitados = new HashSet<>();
		dfsCam(origen,destino,lim,caminoActual,caminos,arcosVisitados);
		// Resolver Caminos
		return caminos;
	}

	private void dfsCam(int origen, int destino, int lim, List<Integer> caminoActual, List<List<Integer>> caminos,
			Set<Arco<Integer>> arcosVisitados) {
		
		if (origen == destino ) {
			caminos.add(new ArrayList<>(caminoActual));
			return;
		}
		if (lim ==0) {
			return;
		}
			//Obtengo los nd adyacentes del grafo
        	Iterator<Arco<Integer>> arcosIterator = grafo.obtenerArcos(origen);
        	while (arcosIterator.hasNext()) {
        		Arco<Integer> arco = arcosIterator.next();
        		if (!arcosVisitados.contains(arco)) {
					//agrego el arco
        			arcosVisitados.add(arco);
        			
        			//agrego al cam actual
        			caminoActual.add(arco.getVerticeDestino());
        			
        			//dfs
        			dfsCam(arco.getVerticeDestino(), destino, lim-1, caminoActual, caminos, arcosVisitados);
        			//quito el ultimo elemento de camino actual
        			caminoActual.remove(caminoActual.size() - 1);
        			//quito el ultimo arco
        			arcosVisitados.remove(arco);
				}
        		
        		
			}
		
		

		
		
	}
	

}