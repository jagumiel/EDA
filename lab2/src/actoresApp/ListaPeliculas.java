package actoresApp;

import java.util.HashMap;
import java.util.Iterator;

public class ListaPeliculas {
	//Atributos
	private HashMap<String, Pelicula> milista;
	
	//Constructora
	public ListaPeliculas(){
		this.milista = new HashMap<String, Pelicula>();
	}
	
	
	//Getter y Setters
	public HashMap<String, Pelicula> getMiListaPeliculas(){
		return this.milista;
	}
	
	public Iterator<String> getIterador(){
		return this.getMiListaPeliculas().keySet().iterator();  //Esto crea un iterador de keys o llaves
													   //en nuestro caso titulos de peliculas.
	}
	
	
	//Otros Metodos
	public boolean estaPelicula(String pTitulo){
		try{
			return this.getMiListaPeliculas().containsKey(pTitulo);
		}catch(NullPointerException e){
			System.out.println("Estás tratando de añadir o eliminar una película no válida");
			return false;
		}
	}
	
	public void anadirPelicula(String pTitulo){
		Pelicula aux;
		 if(pTitulo!=null){
			if(!this.estaPelicula(pTitulo)){
				 if(!ListaPeliculasPrincipal.getListaPeliculasPrincipal().estaPelicula(pTitulo)){
					 aux = new Pelicula(pTitulo);
					 ListaPeliculasPrincipal.getListaPeliculasPrincipal().anadirPelicula(aux);
					 this.getMiListaPeliculas().put(pTitulo,aux); 
				 }else{
					 aux = ListaPeliculasPrincipal.getListaPeliculasPrincipal().buscarPeliculaPorTitulo(pTitulo);
					 this.getMiListaPeliculas().put(pTitulo,aux);
				 } 
			}
		}
	}
	
	public void eliminarPelicula(Pelicula pPelicula){
		if(pPelicula!=null){
			if(estaPelicula(pPelicula.getTitulo())){
				this.getMiListaPeliculas().remove(pPelicula.getTitulo());
			}else{
				System.out.println("La película no se encuentra en la lista");
			}
		}	
	}	
	
	public void imprimirPeliculas(){
		Iterator<String> it = this.getIterador();
		while(it.hasNext()){
			System.out.println("->"+it.next());
		}
	}
	
}
