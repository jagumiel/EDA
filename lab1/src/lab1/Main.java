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
				 if(linea!="\n"){
					 
					/* String[] division = linea.split("\t");
					 Actor aaux = new Actor(division[0]);
					 ListaActores.getListaActores().anadirActor(aaux);
					 String[] division2 = division[2].split("\\(");
					 Pelicula paux = new Pelicula(division2[0]);
					 aaux.anadirPelicula(paux);*/
				 }
			 }
			 entrada.close();
		}
		catch(IOException e) {
			e.printStackTrace();
		}	
	}

}
