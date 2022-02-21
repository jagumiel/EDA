package lab1;

import java.util.ArrayList;
import java.util.Iterator;

public class ListaPeliculasPrincipal {
	//Atributos
	private static ListaPeliculasPrincipal milistaprincipaldepeliculas = new ListaPeliculasPrincipal();
	private ArrayList<Pelicula> lista;
	
	
	//Constructora
	private ListaPeliculasPrincipal(){
		this.lista = new ArrayList<Pelicula>();
	}
	
	
	//Getters y Setters
	public static ListaPeliculasPrincipal getListaPeliculasPrincipal(){
		return milistaprincipaldepeliculas;
	}
	
	
	private ArrayList<Pelicula> getLista(){
		return this.lista;
	}
	
	private Iterator<Pelicula> getIterador(){
		return this.getLista().iterator();
	}
	
	
	//Otros Metodos
	public boolean estaPelicula(Pelicula pPelicula){
		return this.getLista().contains(pPelicula);
	}
	
	public void anadirPelicula(Pelicula pPelicula){
		if((pPelicula!=null)&&(!estaPelicula(pPelicula))){
			this.getLista().add(pPelicula);
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
	
	public void desplazarDerecha(int i, int longitud)
	{
		Pelicula aux;
		Pelicula aux2;
		while (i!=longitud+1)
		{
			aux=this.getLista().get(i);
			aux2=this.getLista().get(i+1);
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
