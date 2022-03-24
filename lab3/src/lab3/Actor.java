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
		 this.getMiListaPeliculas().anadirPelicula(pPelicula);
		}catch(Exception e){
			System.out.println("La pelicula introducida no es válida");
		}
	}
	
	public void eliminarPelicula(Pelicula pPelicula){
		this.getMiListaPeliculas().eliminarPelicula(pPelicula);
	}
	
	public void imprimirInformacion(){
		System.out.println("Nombre: "+this.getNombre());
		this.getMiListaPeliculas().imprimirPeliculas();
	}
	
	public boolean equals(Actor pActor){
		return this.tieneElMismoNombre(pActor);
	}


	public int compareTo(Actor o) {
		return this.getNombre().compareTo(o.getNombre());
	}
	
	public void rellenarColegas(){
		Iterator <String> it=this.getMiListaPeliculas().getIterador();
		while(it.hasNext()){
			String aux;
			Pelicula peliAux;
			aux=it.next();
			if (aux!=null){
				peliAux=ListaPeliculasPrincipal.getListaPeliculasPrincipal().buscarPeliNombre(aux);
				//meter el if, puede devolver null buscarPeliNombre()
				Iterator<String> itActor=peliAux.getListaActores.getIterador();
				while (itActor.hasNext()){
					String actorAux=itActor.next();
					Actor actorAux2=ListaActoresPrincipal.getListaActoresPrincipal().buscarActorNombre(actorAux);
					if (actorAux2!=null){
						this.getColegas().anadirActor(actorAux2);
					}
				}
			}
		}
	}
}
