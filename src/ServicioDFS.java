import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ServicioDFS {
	private Grafo<Integer> grafo;

	public ServicioDFS(Grafo<Integer> grafo) {
		this.grafo = grafo;
	
	}
	
	public List<Integer> dfsForest() {
		// Resolver DFS
		
		 Iterator<Integer> vertices = grafo.obtenerVertices();
		 List<Integer> visitados = new ArrayList<>();
		 while (vertices.hasNext()) {
			 Integer vertice = vertices.next();
			 //si no fue visitado
			 if (!visitados.contains(vertice)) {
					dfs(vertice, visitados);
			}
			 
		}
		return visitados;
	}

	private void dfs(Integer vertice, List<Integer> visitados) {
		visitados.add(vertice);
		Iterator<Integer> adyacentes = grafo.obtenerAdyacentes(vertice);
		while (adyacentes.hasNext()) {
			Integer ady = adyacentes.next();
			if (!visitados.contains(ady)) {
				dfs(vertice, visitados);
			}
			
		}
		
	}
}
