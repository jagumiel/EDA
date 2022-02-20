package lab1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
//import java.io.File;

public class Main {
	private static Main mimain = new Main();
	
	private Main(){	}
	
	public static Main getMain(){
		return mimain;
	}
	
	public void cargarFichero(File nomF){
		try{
			 FileReader fr = new FileReader(nomF);
			 BufferedReader br = new BufferedReader(fr);
			 String linea;
			 Actor ultimoactor = null;
			 int i=1;
			 Pelicula aux = new Pelicula("Sin titulo");
			 while ((linea=br.readLine())!=null) {
				 System.out.println("["+i+"]"+linea);
				 i++;
				 //TODO que funcione el puto .substring(0,3)
				 
				 
				 /*if(!(linea.length()==0)){
					 if(linea.substring(0,3).equals("\t\t\t")){
						 if(ultimoactor!=null){
							 String[] sintabuladores = linea.split("\t");
							 String[] titulo = sintabuladores[3].split(" *[(]+\\d+[)]");
							 titulo[0].replaceAll("[\"]","");
							 aux.setTitulo(titulo[0]);
							 if(ListaPeliculasPrincipal.getListaPeliculasPrincipal().estaPelicula(aux)){
								 ultimoactor.anadirPelicula(aux);
							 }else{
								 aux = ListaPeliculasPrincipal.getListaPeliculasPrincipal().buscarPeliculaPorTitulo(titulo[0]);
								 ListaPeliculasPrincipal.getListaPeliculasPrincipal().anadirPelicula(aux);
								 ultimoactor.anadirPelicula(aux);
							 }
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
				 }*/
			 }
		}
		catch(IOException e) {
			e.printStackTrace();
		}	
	}
}
