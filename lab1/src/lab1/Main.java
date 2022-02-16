package lab1;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
	private static Main mimain = new Main();
	
	private Main(){	}
	
	public static Main getMain(){
		return mimain;
	}
	
	public void cargarFichero(String nomF){
		try{
			 Scanner entrada = new Scanner(new FileReader(nomF));
			 String linea;
			 Actor ultimoactor = null;
			 Pelicula aux = new Pelicula("Sin titulo");
			 while (entrada.hasNext()) {
				 linea = entrada.nextLine();
				 if(!linea.equals("\n")){
					 if(linea.substring(0,3).equals("\t\t\t")){
						 if(ultimoactor!=null){
							 String[] sintabuladores = linea.split("\t");
							 String[] titulo = sintabuladores[3].split("\\(");
							 aux.setTitulo(titulo[0]);
							 ultimoactor.anadirPelicula(aux);
						 }else{
							 System.out.println("Ha ocurrido un error");
						 }
					 }else{
						 String[] division = linea.split("\t");
						 ultimoactor = new Actor(division[0]);
						 ListaActores.getListaActores().anadirActor(ultimoactor);
						 String[] titulo = division[2].split("\\(");
						 aux.setTitulo(titulo[0]);
						 ultimoactor.anadirPelicula(aux);
					 }
				 }
			 }
			 entrada.close();
		}
		catch(IOException e) {
			e.printStackTrace();
		}	
	}
}
