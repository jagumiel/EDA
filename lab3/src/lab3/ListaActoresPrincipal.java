package lab3;

import java.util.HashMap;
import java.util.Iterator;

//import javax.swing.JOptionPane;


public class ListaActoresPrincipal {
	//Atributos
	private static ListaActoresPrincipal milistadeactores = new ListaActoresPrincipal();
	private HashMap<String, Actor> milista;
	
	
	//Constructora
	public ListaActoresPrincipal(){
		milista = new HashMap<String, Actor>();
	}
	
	
	//Getters y Setters
	public static ListaActoresPrincipal getListaActoresPrincipal(){
		return milistadeactores;
	}
	
	public HashMap<String,Actor> getMilista(){
		return this.milista;
	}
	
	public Iterator<String> getIterador(){
		return this.getMilista().keySet().iterator();
	}
	
	public int getTamano(){
		return this.getMilista().size();
	}
	
	
	//Otros Metodos
		public boolean esta(Actor pActor){
			return this.getMilista().containsKey(pActor.getNombre());
		}
		
		public void anadirActor(Actor pActor){
			if(esta(pActor)){
				System.out.println("El actor ya se encuentra en la lista");
			}else{
				getMilista().put(pActor.getNombre(), pActor);
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
				return this.getMilista().get(pActor.getNombre());
			}else{
				return null;
			}
		}catch(NullPointerException e){
			System.out.println("El actor que intentas buscar no existe");
			return null;
		}
	}
	
	public Actor buscarActorNombre(String pActor){
		//Devuelve el Actor si está y sino devuelve null
		return this.getMilista().get(pActor);
	}
	
	public void resetear(){
		getListaActoresPrincipal().getMilista().clear();
	}
	
	public void imprimir(){
		Iterator<String> it = getListaActoresPrincipal().getIterador();
		while(it.hasNext()){
			getListaActoresPrincipal().getMilista().get(it.next()).imprimirInformacion();
			System.out.println("\n\n");  //Imprime dos lineas vacías.
		}
	}
	
	public void ordenarLista(){
		Actor[] milistaordenada = this.convertirHashArray();
		ordenacionPorBurbuja(milistaordenada);
		//JOptionPane.showMessageDialog(null, "El resultado se muestra por consola");
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
	}
}