package actoresApp;

import java.util.Iterator;
import listasSimples.OrderedDoubleLinkedList;


public class ListaActores {
	//Atributos
	private static ListaActores milistadeactores = new ListaActores();
	private OrderedDoubleLinkedList<Actor> milista;
	
	
	//Constructora
	public ListaActores(){
		milista = new OrderedDoubleLinkedList<Actor>();
	}
	
	
	//Getters y Setters
	public static ListaActores getListaActores(){
		return milistadeactores;
	}
	
	public OrderedDoubleLinkedList<Actor> getMilista(){
		return this.milista;
	}
	
	public Iterator<Actor> getIterador(){
		return this.getMilista().iterator();
	}
	
	public int getTamano(){
		return this.getMilista().size();
	}
	
	
	//Otros Metodos
		public boolean esta(Actor pActor){
			return this.getMilista().contains(pActor);
		}
		
		public void anadirActor(Actor pActor){
			try{
				if(esta(pActor)){
					System.out.println("El actor ya se encuentra en la lista");
				}else{
					getMilista().add(pActor);
				}
			}catch(NullPointerException e){
				System.out.println("El actor que desea eliminar no existe");
			}
		}
		
	public void eliminarActor(Actor pActor){
		try{
			if(esta(pActor)){
				getMilista().remove(pActor);
			}else{
				System.out.println("El actor no se encuentra en la lista");
			}
		}catch(NullPointerException e){
			System.out.println("El actor que desea eliminar no existe");
		}
	}
	
	public Actor buscarActor(Actor pActor){
		try{
			if(esta(pActor)){
				return this.getMilista().find(pActor);
			}else{
				return null;
			}
		}catch(NullPointerException e){
			System.out.println("El actor que intentas buscar no existe");
			return null;
		}
	}
	
	public void resetear(){
		getListaActores().getMilista().setFirst(null);
	}
	
	public void imprimir(){
		getListaActores().milista.visualizarNodos();
	}
	
	/*COMO LA LISTA YA ESTA ORDENADA NO NECESITA ESTOS MÉTODOS.
	 * 
	 * 
	 * public void ordenarLista(){
		Actor[] milistaordenada = this.convertirHashArray();
		ordenacionPorBurbuja(milistaordenada);
		JOptionPane.showMessageDialog(null, "El resultado se muestra por consola");
		for(int i = 0; i<milistaordenada.length; i++)
			System.out.println(i+": "+milistaordenada[i].getNombre());
	}
	
	public Actor[] convertirHashArray(){
		Actor[] miArrayDeActores = new Actor[this.getMilista().size()];
		int i = 0;
		Iterator<String> itr = this.getIterador();
		while (itr.hasNext()){
			miArrayDeActores[i] = this.getMilista().get(itr.next());
			i++;
		}
		return miArrayDeActores;
	}
	
	public void ordenacionPorBurbuja(Actor[] tabla) {
		int out, in;
		for (out = tabla.length - 1; out > 0; out--) 
			for (in = 0; in < out; in++) 
				if ( tabla[in].compareTo(tabla[in + 1]) > 0 ) 
					swap(tabla, in, in + 1); 
	} 

	private void swap(Actor[] tabla, int a, int b) {
		Actor aux = tabla[a];
		tabla[a] = tabla[b];
		tabla[b] = aux;
	}*/
}
