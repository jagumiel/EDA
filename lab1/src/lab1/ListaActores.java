package lab1;

import java.util.ArrayList;
import java.util.Iterator;

public class ListaActores {
	//Atributos
	private static ListaActores milistadeactores = new ListaActores();
	private static int[] array;
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
			System.out.println("El actor introducido no es v�lido.");
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
	
	/*public void ordenarLista(){
		//Por hacer
	}*/
	
	public static void ordenacionPorMezcla(Actor[] array) {
	/*	if(array.length < 2) { //cambiar array por la lista de actores. Lo he hecho abajo
			// Si el array es menor que dos, ya esta ordenado.
			return;
		}*/
		if (milistadeactores.getTamano()<2){
			return;
		}
		int cont = 1;
		// inicioI - comienzo del indice del sub-array de la izquierda
		// inicioJ - comienzo del indice del sub-array de la derecha
		int inicioI, inicioJ;

		while(cont < array.length) {
			inicioI = 0;
			inicioJ = cont;
			while(inicioJ + cont <= array.length) {
				mezclarSubArrays(milistadeactores.milista, inicioI, inicioI + cont, inicioJ, inicioJ + cont);
				inicioI = inicioJ + cont;
				inicioJ = inicioI + cont;
			}
			if(inicioJ < array.length) {
				mezclarSubArrays(milistadeactores.milista, inicioI, inicioI + cont, inicioJ, array.length);
			}
			cont = cont*2;
		}
	}
	
	
	public static void mezclarSubArrays(ArrayList<Actor> milista, int inicioI, int pararI, int inicioJ, int pararJ) {
		//TODO

	}

	
	public void resetear(){
		getListaActores().getMilista().clear();
	}
	
	public void imprimir(){
		Iterator<Actor> it = getListaActores().getIterador();
		while(it.hasNext()){
			it.next().imprimirInformacion();
			System.out.println("\n\n");  //Imprime dos lineas vac�as.
		}
	}
}
