package lab3;

public class Pelicula {
	//Atributos
	private String titulo;
	private ListaPeliculas milistapeliculas;
	
	//Constructora
	public Pelicula(String pTitulo){
		this.titulo=pTitulo;
		this.milistapeliculas = new ListaPeliculas();
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
		 this.getMiListaPeliculas().anadirPelicula(pPelicula);
		}catch(Exception e){
			System.out.println("La pelicula introducida no es válida");
		}
	}
	
	public void eliminarPelicula(Pelicula pPelicula){
		this.getMiListaPeliculas().eliminarPelicula(pPelicula);
	}
} 


