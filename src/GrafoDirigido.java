import java.util.ArrayList;
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
	
	
	/*
		Costo computacional: O(1). 
	 
	 */
	public void agregarVertice(int verticeId) {
		//sino esta mapeado
		if (!graf.containsKey(verticeId)) {
			//TENGO QUE CREAR (id,valor) 
			graf.put(verticeId, new ArrayList<>());
		}
	}
	
	/*
	 	Costo computacional: O(1).
	  
	 */
	
	public void borrarVertice(int verticeId) {
		
		if (graf.containsKey(verticeId)) {
			graf.remove(verticeId);
		}
		
	}
	
	/*
		
		Costo computacional: O(n).
		
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
	 
		Costo computacional: O(n).
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
	


	/*
		Costo computacional: O(n).
	 */

	public void borrarArco(int verticeId1 , int verticeId2) {
		if (existeArco(verticeId1, verticeId2)) {
			List<Arco<T>> listaArcos = graf.get(verticeId1);
			Iterator<Arco<T>> it = listaArcos.iterator();
			while (it.hasNext()) {
				Arco<T> arco = it.next();
				if (arco.getVerticeDestino() == verticeId2) {
					it.remove();
				}
			}
		}
	}

	/*
		Costo computacional: O(1).
	*/
	
	public boolean contieneVertice(int verticeId) {
		return graf.containsKey(verticeId);
	}


	/*
		Costo computacional: O(n).
	 
	 */
	public Arco<T> obtenerArco(int verticeId1, int verticeId2){
		List<Arco<T>> listaArcos = graf.get(verticeId1);
		for (Arco<T> arco : listaArcos) {
			if (arco.getVerticeDestino() == verticeId2) {
				return arco;
			}
		}
		return null;
	}
	
	/*
		Costo computacional: O(1).
	
	 
	 */

	public int cantidadVertices() {
		return graf.size();

	}
	 /*
	 	Costo computacional: O(n).	
 
	 */
	public int cantidadArcos() {
		int cantidad = 0;
		for (List<Arco<T>> listaArcos : graf.values()) {
			cantidad += listaArcos.size();
		}
		return cantidad;
	}
	/*
		Costo computacional: O(1). 
	 
	 */
	public  Iterator<Integer>  obtenerVertices(){
		Set<Integer> verticesSet = graf.keySet();
		return verticesSet.iterator();
	}

	/*
		Costo computacional: O(m). donde m es la cantidad de arcos asosiados
		al vertice. si la lista de arcos no esta llena , es menor a m.  

	 */
	public Iterator<Integer> obtenerAdyacentes(int verticeId){
		List<Integer> listaAdyacentes = new ArrayList<>();
	    List<Arco<T>> listaArcos = graf.get(verticeId);
	    if (listaArcos != null) {
	        for (Arco<T> arco : listaArcos) {
	            listaAdyacentes.add(arco.getVerticeDestino());
	        }
	    }
	    return listaAdyacentes.iterator();

		
	}

	/*
		Costo computacional: O(m). donde m es la cantidad de arcos asosiados

	 */
	public Iterator<Arco<T>> obtenerArcos() {
		List<Arco<T>> listaArcos = new ArrayList<>();
	    for (List<Arco<T>> arcs : graf.values()) {
	        listaArcos.addAll(arcs);
	    }
	    return listaArcos.iterator();
	}

	/*
		Costo computacional: O(m). 

	 */
	public List<Arco<T>> obtenerListArcos() {
		List<Arco<T>> listaArcos = new ArrayList<>();
	    for (List<Arco<T>> arcs : graf.values()) {
	        listaArcos.addAll(arcs);
	    }
	    return listaArcos;

	}

	/*
		Costo computacional: O(m) 
	 
	 */
	public Iterator<Arco<T>> obtenerArcos(int verticeId) {
	    List<Arco<T>> listaArcos = graf.get(verticeId);
	    if (listaArcos != null) {
	        return listaArcos.iterator();
	    } else {
	    	return null;
	    }
	}


}

