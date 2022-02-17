package lab1;

public class PruebaSplit {
	
	public static void main(String args[]){
		String linea = "			Mondo (1995)  [The Magician's Friend]  <5>";
		Actor ultimoactor = new Actor("olete,Man");
		Pelicula aux = new Pelicula("Sin titulo");
		 if(!linea.equals("\n")){
			 if((linea.substring(0,3).equals("\t\t\t"))&&(ultimoactor!=null)){
				 String[] sintabuladores = linea.split("\t");
				 String[] titulo = sintabuladores[3].split("\\(");
				 aux.setTitulo(titulo[0]);
				 ultimoactor.anadirPelicula(aux);
				 System.out.println("Actor: "+ultimoactor.getNombre());
				 System.out.println("Titulo: "+aux.getTitulo());
			 }else{
				 String[] division = linea.split("\t");
				 ultimoactor = new Actor(division[0]);
				 ListaActores.getListaActores().anadirActor(ultimoactor);
				 System.out.println("Actor: "+ultimoactor.getNombre());
				 String[] titulo = division[2].split("\\(");
				 aux.setTitulo(titulo[0]);
				 ultimoactor.anadirPelicula(aux);
				 System.out.println("Titulo: "+aux.getTitulo());
			 }
		 }
	}

}
