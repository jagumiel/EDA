package lab1;

import java.util.ArrayList;
import java.util.Iterator;

public class ListaPeliculas {
	//Atributos
	private ArrayList<Pelicula> milistapeliculas;
	
	
	//Constructora
	public ListaPeliculas(){
		milistapeliculas = new ArrayList<Pelicula>();
	}
	
	
	//Getters y Setters
	public ArrayList<Pelicula> getMiListaPeliculas(){
		return milistapeliculas;
	}
	
	private Iterator<Pelicula> getIterador(){
		return this.milistapeliculas.iterator();
	}
	
	//Otros Metodos
	public boolean estaPelicula(Pelicula pPelicula){
		return this.getMiListaPeliculas().contains(pPelicula);
	}
	
	public void anadirPelicula(Pelicula pPelicula){
		if(pPelicula!=null){
			this.getMiListaPeliculas().add(pPelicula);
		}else{
			System.out.println("No se puede añadir la pelicula");
		}
	}
	
	public void eliminarPelicula(Pelicula pPelicula){
		if(estaPelicula(pPelicula)){
			this.getMiListaPeliculas().remove(pPelicula);
		}else{
			System.out.println("La película no se encuentra en la lista");
		}
	}
	
	public void imprimirPeliculas(){
		Iterator<Pelicula> it = this.getIterador();
		while(it.hasNext()){
			System.out.println("->"+it.next().getTitulo());
		}
	}
}