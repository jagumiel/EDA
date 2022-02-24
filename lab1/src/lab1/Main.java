package lab1;

import java.io.*;  //Importo el Paquete Entero
import java.util.Iterator;

public class Main {
	//Atributos
	private static Main mimain = new Main();
	
	
	//Constructora
	private Main(){	}
	
	
	//Getters y Setters
	public static Main getMain(){
		return mimain;
	}
	
	
	//Otros Métodos
	public void cargarFichero(File nomF){
		try{
			 FileReader fr = new FileReader(nomF);
			 BufferedReader br = new BufferedReader(fr);
			 String linea;
			 Actor ultimoactor = null;
			 boolean todobien = true;
			 int ayuda = 0;
			 while ((linea=br.readLine())!=null) {
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
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void guardarFichero(){
		FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter("c:/actrices.txt");
            pw = new PrintWriter(fichero);
            String auxAct, auxPel;
            
            Iterator<String> itrAct = ListaActores.getListaActores().getIterador();
            Iterator<String> itrPel; 
            
            while(itrAct.hasNext()){
            	auxAct = itrAct.next();
            	pw.println(auxAct);
            	itrPel = ListaActores.getListaActores().getMilista().get(itrAct).getMiListaPeliculas().getIterador();
            	while(itrPel.hasNext()){
            		auxPel=itrPel.next();
            		pw.println("--> "+auxPel);
            	}
            }
 
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           // Nuevamente aprovechamos el finally para 
           // asegurarnos que se cierra el fichero.
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
	}
	
}
