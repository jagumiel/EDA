package lab3;

import java.util.HashMap;
import java.util.Iterator;

public class ListaActores {

	private ListaActores milistaprincipaldeactores = new ListaActores();
	private HashMap<String, Actor> lista;
	
	public ListaActores(){
		this.lista = new HashMap<String, Actor>();
	}
	
	//Getters y Setters
	public HashMap<String, Actor> getLista(){
		return this.lista;
	}
	
	public HashMap<String,Actor> getMiListaActores(){
		return lista;
	}
	
	public Iterator<String> getIterador(){
		return this.getMiListaActores().keySet().iterator();
	}
	
	
	//Otros M�todos
	public boolean estaActor(Actor pActor){
		try{
			return this.getMiListaActores().containsKey(pActor.getNombre());
		}catch(NullPointerException e){
			System.out.println("El Actor que est�s buscando no se encuntra en la lista");
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
				System.out.println("La pel�cula no se encuentra en la lista");
			}
		}	
	}	
	
	public void imprimirActores(){
		Iterator<String> it = this.getIterador();
		while(it.hasNext()){
			System.out.println("->"+it.next());
		}
	}
	
}
