package lab4;

public class Grafo<T> {
	
	protected final int CAPACIDAD_POR_DEFECTO = 10;
	protected int numerovertices; //Número de vértices en este grafo
	protected boolean[][] matrizdeadyacencia;
	protected T[] vertices;
	
	@SuppressWarnings("unchecked")
	public Grafo(){
		numerovertices = 0;
		this.matrizdeadyacencia = new boolean[CAPACIDAD_POR_DEFECTO][CAPACIDAD_POR_DEFECTO];
		this.vertices = (T[])(new Object[CAPACIDAD_POR_DEFECTO]);
	}
	
	public void RecorridoEnAnchura(){
		
	}

}
