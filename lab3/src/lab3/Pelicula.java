package lab3;

import java.util.Iterator;

public class Pelicula {
	//Atributos
	private String titulo;
	private ListaPeliculas milistapeliculas;
	private ListaActores reparto;
	
	//Constructora
	public Pelicula(String pTitulo){
		this.titulo=pTitulo;
		this.milistapeliculas = new ListaPeliculas();
		this.reparto=new ListaActores();
	}
	
	
	//Getters y Setters
	public String getTitulo(){
		return this.titulo;
	}
	
	public void setTitulo(String pTitulo){
		this.titulo=pTitulo;
	}
	
	public ListaPeliculas getMiListaPeliculas(){
		return this.milistapeliculas;
	}
	
	public ListaActores getListaActores(){
		return this.reparto;
	}
	
	
	//Otros Metodos
	public boolean tieneElMismoTitulo(Pelicula pPelicula){
		try{
			if(pPelicula.getTitulo().equals(this.getTitulo())){
				return true;
			}else
				return false;
		}
		catch (Exception e){
			return false;
		}
	}	
	
	public boolean equals(Pelicula pPelicula){
		return this.tieneElMismoTitulo(pPelicula);
	}
	
	public void anadirPelicula(Pelicula pPelicula){
		try{
		 this.getMiListaPeliculas().anadirPelicula(pPelicula);//Esto es mal?
		}catch(Exception e){
			System.out.println("La pelicula introducida no es válida");
		}
	}
	
	public void anadirEnReparto(Actor pActor){
		try{
			Iterator<String> it = reparto.getIterador();
			while(it.hasNext()){
				String saux = it.next();
				Actor aaux = ListaActoresPrincipal.getListaActoresPrincipal().buscarActorNombre(saux);
			}
			this.getListaActores().anadirActor(pActor);
		}catch(Exception e){
			System.out.println("El actor introducido no es válido");
		}
	}
	
	public void eliminarPelicula(Pelicula pPelicula){
		this.getMiListaPeliculas().eliminarPelicula(pPelicula);
	}
} 


