8import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.List;

public class GrafoDirigido<T> implements Grafo<T> {
	private Map<Integer, List<Arco<T>>> graf;
	
	//private ArrayList<Arco<T>> arcos = new ArrayList<Arco<T>>(); 
	public GrafoDirigido() {
		//inicializo
		graf = new HashMap<>();
	}
	
	//VERTICE -> NODO || ARCO/ARISTA = LA UNION ENTRE 2 VERRITCES
	/*

 	  Complejidad: O(1) ya que no es necesario recorrer todos los arcos para encontrar el vertice

	 */
	public void agregarVertice(int verticeId) {
		//sino esta mapeado
		if (!graf.containsKey(verticeId)) {
			//TENGO QUE CREAR (id,valor) 
			graf.put(verticeId, new ArrayList<>());
		}
	}
	
	
	/*
	  Complejidad: O(1) ya que no es necesario recorrer todos los arcos para encontrar el vertice
	 * */
	public void borrarVertice(int verticeId) {
		
		if (graf.containsKey(verticeId)) {
			graf.remove(verticeId);
		}
		
	}
	

/* Complejidad:O(1)
   No requiere recorrer todos los arcos del gráfico, solo accede directamente a la lista asociada al vértice
*/
	public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
		Arco<T> arc = new Arco<>(verticeId1, verticeId2, etiqueta);
		if (!existeArco(verticeId1, verticeId2)) {			
			 if (graf.containsKey(verticeId1)) {
		            graf.get(verticeId1).add(arc);
		        } else {
		            List<Arco<T>> arcs = new ArrayList<>();
		            arcs.add(arc);
		            graf.put(verticeId1, arcs);
		        }
		
		}
	}
/*
 	Complejidad: O(n) ya que al no conocer en que vertice existe un arco 
 	el peor caso es que sea en la ultima iteracion
 */
	public boolean existeArco(int verticeId1, int verticeId2) {
			//obtengo el array de arcos
		 List<Arco<T>> listaArcos = graf.get(verticeId1);
		 	//itero los arcos
		    for (Arco<T> arco : listaArcos) {
		        if (arco.getVerticeDestino() == verticeId2) {
		            return true;
		        }
		    }
		    return false;
	}
	
	public void borrarArco(int verticeId1 , int verticeId2) {
		

	}
	
	public boolean contieneVertice(int verticeId) {
		return false;
}

	public Arco<T> obtenerArco(int verticeId1, int verticeId2){
		return null;
	}
	
	public int cantidadVertices() {
		return 0;
	}
	
	public int cantidadArcos() {
		return 0;
	}
/*Complejidad:	O(1), El costo es constante */
	public  Iterator<Integer>  obtenerVertices(){
		Set<Integer> verticesSet = graf.keySet();
		return verticesSet.iterator();
	}
	
	public Iterator<Integer> obtenerAdyacentes(int verticeId){
		return null;
	}
	
/*Complejidad:	O(n), El costo está determinado por el número total de arcos en el gráfico. */
	public Iterator<Arco<T>> obtenerArcos() {
		List<Arco<T>> listaArcos = new ArrayList<>();
	    for (List<Arco<T>> arcs : graf.values()) {
	        listaArcos.addAll(arcs);
	    }
	    return listaArcos.iterator();
	}

/*Complejidad:	O(1),No se realiza un recorrido completo de todos los arcos del gráfico, solo se accede directamente a la lista correspondiente al vértice. El costo es constante, no depende del tamaño  */

	public Iterator<Arco<T>> obtenerArcos(int verticeId) {
	    List<Arco<T>> listaArcos = graf.get(verticeId);
	    if (listaArcos != null) {
	        return listaArcos.iterator();
	    } else {
	    	return null;
	     //   return Collections.emptyIterator();
	    }
	}
}

