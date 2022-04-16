package lab4;

import java.util.HashMap;
import java.util.Iterator;

public class ListaActores {

	private HashMap<String, Actor> lista;
	
	public ListaActores(){
		this.lista = new HashMap<String, Actor>();
	}
	
	//Getters y Setters
	public HashMap<String,Actor> getMiListaActores(){
		return lista;
	}
	
	public Iterator<String> getIterador(){
		return this.getMiListaActores().keySet().iterator();
	}
	
	public int getTamano(){
		return this.lista.size();
	}
	
	
	//Otros Métodos
	public boolean estaActor(Actor pActor){
		try{
			return this.getMiListaActores().containsKey(pActor.getNombre());
		}catch(NullPointerException e){
			System.out.println("El Actor que estás buscando no se encuntra en la lista");
			return false;
		}
	}
	
	public void anadirActor(Actor pActor){
		 if(pActor!=null){
			if(!this.estaActor(pActor)){
				 if(!ListaActoresPrincipal.getListaActoresPrincipal().esta(pActor)){
					 ListaActoresPrincipal.getListaActoresPrincipal().anadirActor(pActor);
					 this.getMiListaActores().put(pActor.getNombre(),pActor); 
				 }else{
					 this.getMiListaActores().put(pActor.getNombre(),pActor);
				 } 
			}
		}
	}
	
	public void eliminarActor(Actor pActor){
		if(pActor!=null){
			if(estaActor(pActor)){
				this.getMiListaActores().remove(pActor.getNombre());
			}else{
				System.out.println("La película no se encuentra en la lista");
			}
		}	
	}	
	
	public Actor buscarActorNombre(String pActor){
		//Devuelve el Actor si está y sino devuelve null
		return this.getMiListaActores().get(pActor);
	}
	
	public void imprimirActores(){
		Iterator<String> it = this.getIterador();
		while(it.hasNext()){
			System.out.println("->"+it.next());
		}
	}
}


