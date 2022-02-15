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
}
