package lab1;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
	
	public void cargarFichero(String nomF){
		try{
			 Scanner entrada = new Scanner(new FileReader(nomF));
			 String linea;
			 while (entrada.hasNext()) {
				 linea = entrada.nextLine();
				 String[] division = linea.split("\t");
				 Actor aaux = new Actor(division[0]);
				 ListaActores.getListaActores().anadirActor(aaux);
				 String[] division2 = division[2].split("\\(");
				 Pelicula paux = new Pelicula(division2[0]);
				 //ListaPeliculas.getListaPeliculas.anadirPelicula(paux); <<<---Falta la clase ListaPeliculas--->>>
				 }
			 entrada.close();
		}
		catch(IOException e) {
			e.printStackTrace();
		}	
	}

}
