package lab1;

import java.util.ArrayList;
import java.util.Iterator;

public class ListaActores {
	//Atributos
	private static ListaActores milistadeactores;
	private ArrayList<Actor> milista;
	
	
	//Constructora
	public ListaActores(){
		milistadeactores= new ListaActores();
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
	
	
	//Otros Metodos
	public boolean esta(Actor pActor){
		return this.getMilista().contains(pActor);
	}
	
	public void anadirActor(Actor pActor){
		if(esta(pActor)){
			System.out.println("El actor ya se ncuentra en la lista");
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
}
