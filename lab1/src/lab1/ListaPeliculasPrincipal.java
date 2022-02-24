package lab1;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class ListaPeliculasPrincipal {
	//Atributos
	private static ListaPeliculasPrincipal miListaPrincipalDePeliculas = new ListaPeliculasPrincipal();
	private HashMap<String, Pelicula> lista;
	

	
	//Constructora
	private ListaPeliculasPrincipal(){
		this.lista = new HashMap<String, Pelicula>();
	}
	
	
	//Getters y Setters
	public static ListaPeliculasPrincipal getListaPeliculasPrincipal(){
		return miListaPrincipalDePeliculas;
	}
	
	
	private HashMap<String, Pelicula> getLista(){
		return this.lista;
	}
	
	private Iterator<String> getIterador(){
		return this.getLista().keySet().iterator();
	}
	
	
	
	//Otros Metodos
	public boolean estaPelicula(Pelicula pPelicula){
		if (this.getLista().containsKey(pPelicula))
		{
			return true;
		}
		else
		{
			return false;
		}
	} //TODO Revisar
	
	
	

	
	public void anadirPelicula(Pelicula pPelicula){
		if((pPelicula!=null)&&(!estaPelicula(pPelicula))){
			//this.getLista().add(pPelicula);
			String pTitulo=pPelicula.getTitulo();
			this.getLista().put(pTitulo,new Pelicula(pPelicula.getTitulo()));
		}else{
			System.out.println("la pelicula introducida no es valida.");
		}
	}
	
	
	

	/*public void anadirPeliculaOrdenada(Pelicula pPelicula) 
	{
		if((pPelicula!=null)&&(!estaPelicula(pPelicula))){
			this.getLista().push(pPelicula);
			this.getLista().sort(function(a,b) {return a-b});
			return this.getLista();
		}
		else{
			System.out.println("la pelicula introducida no es valida.");
		}
	}*/

	//En el caso de que funcione se aplica tambien al resto de listas.
	
	
	public void anadirPeliculaOrdenada(Pelicula pPelicula) 
	{
		if((pPelicula!=null)&&(!estaPelicula(pPelicula)))
		{
			String titulo=pPelicula.getTitulo();
			int longitud=this.getLista().size();
			int i=0;
			boolean ordenado=false;
			while (!ordenado) 
			{
				if(longitud>0)
				{
					i=longitud/2;
					String peliAux=this.getLista().get(i).getTitulo();
					int resul=titulo.compareTo(peliAux);
					if (resul>0)
					{
						int aux=longitud-i;
						aux=aux/2;
						i=i+aux;
					}
					else
					{
						int aux=longitud-i;
						aux=aux/2;
						i=i-aux;
					}
					if((this.getLista().get(i-1).getTitulo().compareTo(titulo)<0) &&(this.getLista().get(i).getTitulo().compareTo(titulo)>0))
					{
						desplazarDerecha(i, longitud);
						this.getLista().add(i, pPelicula);
						ordenado=true;
					}
				}
				else
				{
					this.getLista().add(pPelicula);
					ordenado=true;
				}
			}
		}
		else
		{
			System.out.println("la pelicula introducida no es valida.");
		}
	}
	
	public void ordenarHashMap(ListaPeliculas listaPeliculasPrincipal)
	{
		Collections.sort(this.getLista(),new ListaPeliculasPrincipal());
	}
	
	
	public void desplazarDerecha(int i, int longitud)
	{
		Pelicula aux;
		Pelicula aux2;
		while (i!=longitud+1)
		{
			aux=this.getLista().get(i);
			aux2=this.getLista().get(i+1);
			this.getLista().
			this.getLista().add(i+1, aux);
			i=i+1;
			aux=this.getLista().get(i);
			this.getLista().add(i+1, aux2);
		}
	}

	
	public void eliminarPelicula(Pelicula pPelicula){
		if((pPelicula!=null)&&(estaPelicula(pPelicula))){
			this.getLista().remove(pPelicula);
		}else{
			System.out.println("La pelicula no se encuentra en la lista.");
		}
	}
	
	public void resetearLista(){
		this.getLista().clear();
	}

	public Pelicula buscarPeliculaPorTitulo(String pTitulo){
		Pelicula rdo = new Pelicula(pTitulo);
		if(estaPelicula(rdo)){
			try{
				Iterator<Pelicula> itr = this.getIterador();
				while (itr.hasNext()){
					if(itr.next().getTitulo().equals(pTitulo)){
						rdo = itr.next();
						break;
					}
				}
			}catch(Exception e){
				System.out.println("Se ha producido un error");
			}
		}else{
			System.out.println("La pelicula no se encuentra en la lista");
			rdo=null;
		}
		
		return rdo;
	}
	
}
