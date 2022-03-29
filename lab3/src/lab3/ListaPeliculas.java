package lab3;

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
	public boolean estaPelicula(Pelicula pPelicula){
		try{
			String pTitulo = pPelicula.getTitulo();
			return this.getMiListaPeliculas().containsKey(pTitulo);
		}catch(NullPointerException e){
			return false;
		}
	}
	
	public void anadirPelicula(Pelicula pPelicula){
		 if(pPelicula!=null){
			if(!this.estaPelicula(pPelicula)){
				 if(!ListaPeliculasPrincipal.getListaPeliculasPrincipal().estaPelicula(pPelicula)){
					 ListaPeliculasPrincipal.getListaPeliculasPrincipal().anadirPelicula(pPelicula);
					 this.getMiListaPeliculas().put(pPelicula.getTitulo(),pPelicula); 
				 }else{
					 this.getMiListaPeliculas().put(pPelicula.getTitulo(),pPelicula);
				 } 
			}
		}
	}
	
	public void eliminarPelicula(Pelicula pPelicula){
		if(pPelicula!=null){
			if(estaPelicula(pPelicula)){
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
