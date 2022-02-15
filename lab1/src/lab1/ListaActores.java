package lab1;

import java.util.ArrayList;
import java.util.Iterator;

public class ListaActores {
	//Atributos
	private static ListaActores milistadeactores = new ListaActores();
	private ArrayList<Actor> milista;
	
	
	//Constructora
	public ListaActores(){
		milista = new ArrayList<Actor>();
	}
	
	
	//Getters y Setters
	public static ListaActores getListaActores(){
		return milistadeactores;
	}
	
	private ArrayList<Actor> getMilista(){
		return this.milista;
	}
	
	private Iterator<Actor> getIterador(){
		return this.getMilista().iterator();
	}
	
	
	public int getTamano(){
		return getMilista().size();
	}
	
	
	//Otros Metodos
	public boolean esta(Actor pActor){
		return this.getMilista().contains(pActor);
	}
	
	public void anadirActor(Actor pActor){
		if(esta(pActor)){
			System.out.println("El actor ya se encuentra en la lista");
		}else if(pActor==null){
			System.out.println("El actor introducido no es válido.");
		}else{
			getMilista().add(pActor);
		}
	}
	
	public void eliminarActor(Actor pActor){
		if(esta(pActor)){
			getMilista().remove(pActor);
		}else{
			System.out.println("El actor no se encuentra en la lista");
		}
	}
	
	public Actor buscarActor(Actor pActor){
		Actor retorno = null;
		if(esta(pActor)){
			try{
				Iterator<Actor> itr = this.getIterador();
				while(itr.hasNext()){
					if(pActor.tieneElMismoNombre(itr.next())){
						retorno=pActor;
						break;
					}
				}
				throw new Exception();
			}	
			catch(Exception e){
				System.out.println("Se ha producido una excepcion al buscar al actor");
			}
		}else{
			System.out.println("El actor no se encuentra en la lista");
		}
		return retorno;
	}
	
	public void ordenarLista(){
		//TODO
	}
	
	public void resetear(){
		getListaActores().getMilista().clear();
	}
	
	public void imprimir(){
		Iterator<Actor> it = getListaActores().getIterador();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
}
