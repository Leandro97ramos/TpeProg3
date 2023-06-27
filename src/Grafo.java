import java.util.Iterator;
import java.util.List;

public interface Grafo<T> {

	public void agregarVertice(int verticeId);
	
	public void borrarVertice(int verticeId);
	
	public void agregarArco(int verticeId1, int verticeId2, T etiqueta);
	
	public void borrarArco(int verticeId1, int verticeId2);
	
	public boolean contieneVertice(int verticeId);
	
	public boolean existeArco(int verticeId1, int verticeId2);
	
	public Arco<T> obtenerArco(int verticeId1, int verticeId2);
	
	public int cantidadVertices();
	
	public int cantidadArcos();
	
	public Iterator<Integer> obtenerVertices();
	
	public Iterator<Integer> obtenerAdyacentes(int verticeId);
	
	public Iterator<Arco<T>> obtenerArcos();
	
	public Iterator<Arco<T>> obtenerArcos(int verticeId);

    public int getCantidadEstaciones();

    public int getDistancia(int estacionActual, int i);

	
	
}
