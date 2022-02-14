package lab1;

public class Actor {
	//Atributos
	private String nombre;
	
	
	//Constructora
	public Actor(String pNombre){
		this.nombre=pNombre;
	}
	
	
	//Getters y Setters
	private String getNombre() {
		return nombre;
	}

	public void setNombre(String pNombre) {
		this.nombre = pNombre;
	}
	
	
	//Otros Metodos
	public boolean tieneElMismoNombre(Actor pActor){
		try{
			if(pActor.getNombre()==this.getNombre()){
				return true;
			}else
				return false;
		}
		catch (Exception e){
			return false;
		}
	} 
}
