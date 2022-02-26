package probandohashmaps;

import java.util.HashMap;
import java.util.Iterator;


public class ListaActores {
	//Atributos
	private static ListaActores milistadeactores = new ListaActores();
	private HashMap<String, Actor> milista;
	
	
	//Constructora
	public ListaActores(){
		milista = new HashMap<String, Actor>();
	}
	
	
	//Getters y Setters
	public static ListaActores getListaActores(){
		return milistadeactores;
	}
	
	public HashMap<String,Actor> getMilista(){
		return this.milista;
	}
	
	public Iterator<String> getIterador(){
		return this.getMilista().keySet().iterator();
	}
	
	
	//Otros Metodos
		public boolean esta(String pNombre){
			return this.getMilista().containsKey(pNombre);
		}
		
		public void anadirActor(Actor pActor){
			try{
				if(esta(pActor.getNombre())){
					System.out.println("El actor ya se encuentra en la lista");
				}else{
					getMilista().put(pActor.getNombre(), pActor);
				}
			}catch(NullPointerException e){
				System.out.println("El actor que desea eliminar no existe");
			}
		}
		
	public void eliminarActor(Actor pActor){
		try{
			if(esta(pActor.getNombre())){
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
			if(esta(pActor.getNombre())){
				return this.getMilista().get(pActor);
			}else{
				return null;
			}
		}catch(NullPointerException e){
			System.out.println("El actor que intentas buscar no existe");
			return null;
		}
	}
	
	public void resetear(){
		getListaActores().getMilista().clear();
	}
	
	public void imprimir(){
		Iterator<String> it = getListaActores().getIterador();
		while(it.hasNext()){
			getListaActores().getMilista().get(it.next()).imprimirInformacion();
			System.out.println("\n\n");  //Imprime dos lineas vacías.
		}
	}
}
