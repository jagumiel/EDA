package lab3;

public class Actor{
	//Atributos
	private String nombre;
	private ListaPeliculas milistapeliculas;
	
	
	//Constructora
	public Actor(String pNombre){
		this.nombre=pNombre;
		this.milistapeliculas = new ListaPeliculas();
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
}
