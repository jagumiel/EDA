package lab3;

import java.util.Iterator;

public class Actor{
	//Atributos
	private String nombre;
	private ListaPeliculas milistapeliculas;
	private ListaActores colegas;
	
	
	//Constructora
	public Actor(String pNombre){
		this.nombre=pNombre;
		this.milistapeliculas = new ListaPeliculas();
		this.colegas=new ListaActores();
	}
	
	
	//Getters y Setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String pNombre) {
		this.nombre = pNombre;
	}
	
	public ListaPeliculas getMiListaPeliculas(){
		return this.milistapeliculas;
	}
		
	public ListaActores getColegas(){
		return this.colegas;
	}
	
	
	//Otros Metodos
	public boolean tieneElMismoNombre(Actor pActor){
		try{
			if(pActor.getNombre().equals(this.getNombre())){
				return true;
			}else
				return false;
		}
		catch (Exception e){
			return false;
		}
	} 
	
	public void anadirPelicula(Pelicula pPelicula){
		try{
			 if(pPelicula.getListaActores().getTamano()==0){
				 this.getMiListaPeliculas().anadirPelicula(pPelicula);
				 pPelicula.getListaActores().anadirActor(this);
			 }else{
				 pPelicula.anadirAColegasDelReparto(this);
				 this.anadirColegasDePelicula(pPelicula);
				 pPelicula.getListaActores().anadirActor(this);
				 this.getMiListaPeliculas().anadirPelicula(pPelicula);
			 }
		}catch(Exception e){
			System.out.println("La pelicula introducida no es válida");
		}
	}
	
	public void eliminarPelicula(Pelicula pPelicula){
		this.getMiListaPeliculas().eliminarPelicula(pPelicula);
	}
	
	public void imprimirInformacion(){
		System.out.println("Nombre: "+this.getNombre());
		System.out.println("Peliculas:");
		this.getMiListaPeliculas().imprimirPeliculas();
		System.out.println("Colegas:");
		this.colegas.imprimirActores();
	}
	
	public boolean equals(Actor pActor){
		return this.tieneElMismoNombre(pActor);
	}


	public int compareTo(Actor o) {
		return this.getNombre().compareTo(o.getNombre());
	}
	
	public void anadirColegasDePelicula(Pelicula pPelicula){
		Iterator <String> it=pPelicula.getListaActores().getIterador();
		while(it.hasNext()){
			String aux;
			Actor aaux;
			aux=it.next();
			if (aux!=null){
				aaux=pPelicula.getListaActores().buscarActorNombre(aux);
				if (aaux!=null){
					this.getColegas().anadirActor(aaux);
				}
			}
		}
	}
}
