package lab1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;


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
	
	public int getTamano(){
		return this.getMilista().size();
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
				return this.getMilista().get(pActor.getNombre());
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
	
	public void convertirHashArray(){
		List<Actor> miArrayDeActores = new ArrayList<Actor>(milista.values());
	}
	
	//Algoritmos de Ordenaci—n
	public void mergeSort(Actor[] laTabla){
		mergeSort(laTabla, 0, laTabla.length-1);
	}
	
	
	private void mergeSort (Actor[] miArrayDeActores, int inicio, int fin){
		if( inicio < fin ) {
	// hay m‡s de un elemento en la tabla
			mergeSort(miArrayDeActores, inicio, (inicio+fin)/2);
			mergeSort(miArrayDeActores, ((inicio+fin)/2)+1, fin);
			mezcla(miArrayDeActores, inicio, (inicio+fin)/2, fin);
		}
	}
	
	
	private void mezcla (Actor[] miArrayDeActores, int	i, int centro, int f){
		Actor[] laMezcla = (Actor[])(new Comparable [f-i+1]);
		int izq = i;
		int der = centro+1;
		int k = 0;
		//indice para rellenar laMezcla
		while (izq<=centro && der<=f ){
			if (miArrayDeActores[izq].compareTo(miArrayDeActores[der])<= 0){
				laMezcla[k] = miArrayDeActores[izq];
				k++;
				izq++;
				}
			else
				{
				laMezcla[k] = miArrayDeActores[der];
				k++;
				der++;
				}
		}
		if (izq > centro){
			while(der<=f ){
				laMezcla[k] = miArrayDeActores[der];
				k++;
				der++;
				}
		}
		else{
			while(izq<=centro ){
				laMezcla[k] = miArrayDeActores[izq];
				k++;
				izq++;
			}
		}
		for(int j=i; j<=f; j++)
			miArrayDeActores[j] = laMezcla[j-i];
	}
	
}

