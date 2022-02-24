package lab1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


public class ListaActores {
	//Atributos
	private static ListaActores miListaDeActores = new ListaActores();
	private HashMap<String, Actor> miLista;
	
	
	//Constructora
	public ListaActores(){
		miLista = new HashMap<String, Actor>();
	}
	
	
	//Getters y Setters
	public static ListaActores getListaActores(){
		return miListaDeActores;
	}
	
	public HashMap<String,Actor> getMilista(){
		return this.miLista;
	}
	
	public Iterator<String> getIterador(){
		return this.getMilista().keySet().iterator();
	}
	
	
	//Otros Metodos	
	
	
	public LinkedHashMap sortHashMapByValuesD(HashMap passedMap) {
	    List mapKeys = new ArrayList(passedMap.keySet());
	    List mapValues = new ArrayList(passedMap.values());
	    Collections.sort(mapValues);
	    Collections.sort(mapKeys);
	        
	    LinkedHashMap sortedMap = 
	        new LinkedHashMap();
	    
	    Iterator valueIt = mapValues.iterator();
	    while (valueIt.hasNext()) {
	        Object val = valueIt.next();
	        Iterator keyIt = mapKeys.iterator();
	        
	        while (keyIt.hasNext()) {
	            Object key = keyIt.next();
	            String comp1 = passedMap.get(key).toString();
	            String comp2 = val.toString();
	            
	            if (comp1.equals(comp2)){
	                passedMap.remove(key);
	                mapKeys.remove(key);
	                sortedMap.put((String)key, (Double)val);
	                break;
	            }

	        }

	    }
	    return sortedMap;
	}
	
	/*private static HashMap ordenarPorComparador(HashMap unsortMap) {
		 
		List list = new LinkedList(unsortMap.entrySet());
 
		// sort list based on comparator
		Collections.sort(list, new Comparator() {
			public int compare(Pelicula p1, Pelicula p2) {
				return ((Comparable) ((Map.Entry) (p1)).getValue())
                                       .compareTo(((Map.Entry) (p2)).getValue());
			}
		});
 
		// put sorted list into map again
                //LinkedHashMap make sure order in which keys were inserted
		HashMap sortedMap = new LinkedHashMap();
		for (Iterator it = list.iterator(); it.hasNext();) {
			HashMap.Entry entry = (HashMap.Entry) it.next();
			sortedMap.put(entry.getKey(), entry.getValue());
		}
		return sortedMap;
	}
	 
		public static void printMap(Map<String, String> map) {
			for (Map.Entry entry : map.entrySet()) {
				System.out.println("Key : " + entry.getKey() + " Value : "
					+ entry.getValue());
			}
		}*/
	
		public boolean esta(Actor pActor){
			return this.getMilista().containsKey(pActor.getNombre());
		}
		
		/*public void anadirActor(Actor pActor){
			try{
				if(esta(pActor)){
					System.out.println("El actor ya se encuentra en la lista");
				}else if(pActor==null){
					System.out.println("El actor introducido no es válido.");
				}else{
					getMilista().put(pActor.getNombre(), pActor);
				}
			}catch(NullPointerException e){
				System.out.println("El actor que desea eliminar no existe");
			}
		}*/
		
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
