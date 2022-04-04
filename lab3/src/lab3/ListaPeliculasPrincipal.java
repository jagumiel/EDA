package lab3;

import java.util.HashMap;
import java.util.Iterator;

public class ListaPeliculasPrincipal {
	//Atributos
	private static ListaPeliculasPrincipal milistaprincipaldepeliculas = new ListaPeliculasPrincipal();
	private HashMap<String, Pelicula> lista;
	
	
	//Constructora
	public ListaPeliculasPrincipal(){
		this.lista = new HashMap<String, Pelicula>();
	}
	
	
	//Getters y Setters
	public static ListaPeliculasPrincipal getListaPeliculasPrincipal(){
		return milistaprincipaldepeliculas;
	}
	
	
	private HashMap<String, Pelicula> getLista(){
		return this.lista;
	}
	
	public Iterator<String> getIterador(){
		return this.getLista().keySet().iterator();  //Esto crea un iterador de keys o llaves
													   //en nuestro caso titulos de peliculas.
	}
	
	
	//Otros Metodos
	public boolean estaPelicula(Pelicula pPelicula){
		return this.getLista().containsKey(pPelicula.getTitulo());
	}
	
	public void anadirPelicula(Pelicula pPelicula){
		if((pPelicula!=null)&&(!estaPelicula(pPelicula))){
			this.getLista().put(pPelicula.getTitulo(), pPelicula);
		}else{
			System.out.println("la pelicula introducida no es valida.");
		}
	}
		
	public void eliminarPelicula(Pelicula pPelicula){
		if((pPelicula!=null)&&(estaPelicula(pPelicula))){
			this.getLista().remove(pPelicula);
		}else{
			System.out.println("La pelicula no se encuentra en la lista.");
		}
	}
	
	public void resetearLista(){
		this.getLista().clear();
	}

	public Pelicula buscarPeliNombre(String pTitulo){
		//Devuelve la Película si está y sino devuelve null
		return this.getLista().get(pTitulo);
	}	
}
