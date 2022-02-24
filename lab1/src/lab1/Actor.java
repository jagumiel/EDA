package lab1;


public class Actor {
	//Atributos
	private String nombre;
	private ListaPeliculas miListaPeliculas;
	
	
	//Constructora
	public Actor(String pNombre){
		this.nombre=pNombre;
		this.miListaPeliculas = new ListaPeliculas();
	}
	
	
	//Getters y Setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String pNombre) {
		this.nombre = pNombre;
	}
	
	public ListaPeliculas getMiListaPeliculas(){
		return this.miListaPeliculas;
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
	
	public void anadirPelicula(String pTitulo){
		this.getMiListaPeliculas().anadirPelicula(pTitulo);
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
}
