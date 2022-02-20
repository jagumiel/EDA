package lab1;

import java.util.ArrayList;
import java.util.Iterator;

public class ListaPeliculasPrincipal {
	//Atributos
	private static ListaPeliculasPrincipal milistaprincipaldepeliculas = new ListaPeliculasPrincipal();
	private ArrayList<Pelicula> lista;
	
	
	//Constructora
	private ListaPeliculasPrincipal(){
		this.lista = new ArrayList<Pelicula>();
	}
	
	
	//Getters y Setters
	public static ListaPeliculasPrincipal getListaPeliculasPrincipal(){
		return milistaprincipaldepeliculas;
	}
	
	
	private ArrayList<Pelicula> getLista(){
		return this.lista;
	}
	
	private Iterator<Pelicula> getIterador(){
		return this.getLista().iterator();
	}
	
	
	//Otros Metodos
	public boolean estaPelicula(Pelicula pPelicula){
		return this.getLista().contains(pPelicula);
	}
	
	public void anadirPelicula(Pelicula pPelicula){
		if((pPelicula!=null)&&(!estaPelicula(pPelicula))){
			this.getLista().add(pPelicula);
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

	public Pelicula buscarPeliculaPorTitulo(String pTitulo){
		Pelicula rdo = new Pelicula(pTitulo);
		if(estaPelicula(rdo)){
			try{
				Iterator<Pelicula> itr = this.getIterador();
				while (itr.hasNext()){
					if(itr.next().getTitulo().equals(pTitulo)){
						rdo = itr.next();
						break;
					}
				}
			}catch(Exception e){
				System.out.println("Se ha producido un error");
			}
		}else{
			System.out.println("La pelicula no se encuentra en la lista");
			rdo=null;
		}
		
		return rdo;
	}
	
}
