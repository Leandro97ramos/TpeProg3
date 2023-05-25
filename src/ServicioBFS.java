import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
public class ServicioBFS {
	private Grafo<Integer> grafo;
	
	public ServicioBFS(Grafo<Integer> grafo) {
		this.grafo = grafo;
	}
	
	public List<Integer> bfsForest() {
		//visitados
		List<Integer> visitados = new ArrayList<>();
		//vertices
		Iterator<Integer> vertices = grafo.obtenerVertices();
		//cola -- primero en entrar primero en salir
		Queue<Integer> cola = new LinkedList<>();
		//recorro
		while(vertices.hasNext()) {
			Integer vertice = vertices.next();
			if (!visitados.contains(vertice)) {
				cola.add(vertice);
				visitados.add(vertice);
				while(!cola.isEmpty()) {
						//quito el primero de la cola y lo guardo
					 Integer vrt = cola.poll();
					 	//obtengo los adyacentes
					 //implemento iterador
					 Iterator<Integer> adyacentes = grafo.obtenerAdyacentes(vrt);
					 while(adyacentes.hasNext()) {
						 Integer ady= adyacentes.next();
						 if (!visitados.contains(ady)) {
							 cola.add(ady);
							 visitados.add(ady);
						}
					 }
				}
			}
			
		}	
				//si
		return visitados;
	}
}
