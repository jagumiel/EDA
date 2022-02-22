package lab1;

public class Pelicula {
	//Atributos
	private String titulo;

	
	//Constructora
	public Pelicula(String pTitulo){
		this.titulo=pTitulo;
	}
	
	
	//Getters y Setters
	public String getTitulo(){
		return this.titulo;
	}
	
	public void setTitulo(String pTitulo){
		this.titulo=pTitulo;
	}
	
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
} 

