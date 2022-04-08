package lab3;

import java.util.Iterator;

public class Pelicula {
	//Atributos
	private String titulo;
	private ListaActores reparto;
	
	//Constructora
	public Pelicula(String pTitulo){
		this.titulo=pTitulo;
		this.reparto=new ListaActores();
	}
	
	
	//Getters y Setters
	public String getTitulo(){
		return this.titulo;
	}
	
	public void setTitulo(String pTitulo){
		this.titulo=pTitulo;
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
	
	public void anadirAColegasDelReparto(Actor pActor){
		try{
			Iterator<String> it = reparto.getIterador();
			while(it.hasNext()){
				String saux = it.next();
				if(!saux.equals(pActor.getNombre())){
					Actor aaux = reparto.getMiListaActores().get(saux);
					aaux.getColegas().anadirActor(pActor);
				}
			}	
		}catch(Exception e){
			System.out.println("El actor introducido no es válido");
		}
	}
	
	public void anadirActorAlReparto(Actor pActor){
		if(!this.getListaActores().getMiListaActores().containsKey(pActor.getNombre())){
			this.getListaActores().anadirActor(pActor);
		}
	}
} 


