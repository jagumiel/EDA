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
			 Pelicula aux = null;
			 boolean todobien = true;
			 int ayuda = 0;
			 while ((linea=br.readLine())!=null) {
				 System.out.println("["+i+"]"+linea);
				 i++;
				 ayuda=0;
				 
				 do{
					 try{
						 todobien=true;
						 if(!(linea.length()==0)){
							 if(linea.substring(0,3).equals("\t\t\t")){
								 if(ultimoactor!=null){
									 String[] sintabuladores = linea.split("\t");
									 String[] titulo = sintabuladores[3].split(" *[(]+\\d+[)]");
									 titulo[0].replaceAll("[\"]","");
									 ultimoactor.anadirPelicula(titulo[0]);
								 }else{
									 System.out.println("Ha ocurrido un error");
								 }
							 }else{
								 String[] division = linea.split("\t");
								 ultimoactor = new Actor(division[0]);
								 ListaActores.getListaActores().anadirActor(ultimoactor);
								 String[] titulo = division[2-ayuda].split("\\(");
								 ultimoactor.anadirPelicula(titulo[0]);
							 }
						 }
					 }catch(ArrayIndexOutOfBoundsException ae){
							//A veces en vez de salir actriz\t\tpelicula solo hay un \t. Lo solucionamos aqui:
							todobien=false;
							ayuda=1;
							ListaActores.getListaActores().eliminarActor(ultimoactor); //Para evitar duplicados
					 }
				 }while(!todobien);
			 }
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
}
