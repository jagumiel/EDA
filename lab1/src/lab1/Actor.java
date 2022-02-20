package lab1;

public class Actor {
	//Atributos
	private String nombre;
	private ListaPeliculas milistapeliculas;
	
	
	//Constructora
	public Actor(String pNombre){
		this.nombre=pNombre;
		this.milistapeliculas=new ListaPeliculas();
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
		this.getMiListaPeliculas().anadirPelicula(pPelicula);
	}
	
	public void eliminarPelicula(Pelicula pPelicula){
		this.getMiListaPeliculas().eliminarPelicula(pPelicula);
	}
	
	public void imprimirInformacion(){
		System.out.println(this.getNombre());
		this.getMiListaPeliculas().imprimirPeliculas();
	}
}
