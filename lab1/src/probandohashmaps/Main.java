package probandohashmaps;

import java.io.*;  //Importo el Paquete Entero
import java.util.Iterator;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

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
	
	public static void main(String[] args){
		boolean repetir;
		repetir = false;
		System.out.println("Bienvenido a la base virtual de cine, ¿Qué quieres hacer?\n"
				+ "1- Cargar fichero\n"
				+ "2- Añadir un actor\n"
				+ "3- Añadir una pelicula\n"
				+ "4- Ordenar la lista de actores\n"
				+ "5- Guardar fichero");
		do{	
			String entrada = JOptionPane.showInputDialog("Elige una opción"); //Para que se vea que vamos sobrados y no usamos Scanner <-- Borrar después
			switch(entrada){
			case "1":
				JFileChooser fc = new JFileChooser();
				fc.setCurrentDirectory(new File("."));
				fc.setDialogTitle("Elige un fichero"); 
				fc.setAcceptAllFileFilterUsed(false);  
				if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) { //Comprueba que hemos seleccionado un archivo
					Main.getMain().cargarFichero(fc.getSelectedFile()); 
				} else {
					System.out.println("No seleccion ");
				}
				break;
			case "2":
				Actor anadir = new Actor(JOptionPane.showInputDialog("Introduce el nombre del actor"));
				if(ListaActores.getListaActores().esta(anadir.getNombre())){
					System.out.println("El actor ya se encuentra en la lista"); //ListaActores lo comprueba también pero poniendo esto aqui te ahorras meterle peliculas para nada.
				}else{
					boolean quedanpeliculas = true;
					String respuesta;
					do{
						respuesta = JOptionPane.showInputDialog("¿Quieres añadirle una película? (Si/No)");
						if (respuesta.equalsIgnoreCase("si")){
							anadir.anadirPelicula(JOptionPane.showInputDialog("Introduce el titulo de la película"));
						}else{
							quedanpeliculas=false;
						}
					}while (quedanpeliculas);
					ListaActores.getListaActores().anadirActor(anadir);
				}	
				break;
			case "3":
				ListaPeliculasPrincipal.getListaPeliculasPrincipal().anadirPelicula(new Pelicula(JOptionPane.showInputDialog("Introduce el titulo de la película")));
				break;
			case "4":
				//TODO
				break;
			case "5":
				Main.getMain().guardarFichero();
				break;
			default:
				System.out.println("La opción itroducida es incorrecta. Introduce un número del 1 al 5.");
				repetir=true;
			}
		}while(repetir==true);	
	}
	
	
	
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
						 if(linea.length()!=0){
							 if(linea.substring(0,3).equals("\t\t\t")){
								 if(ultimoactor!=null){
									 String[] sintabuladores = linea.split("\t");
									 String[] titulo = sintabuladores[3-ayuda].split(" *[(]+\\d+[)]");
									 titulo[0].replaceAll("[\"]","");
									 if(titulo[0].equals("")){
										 todobien=false;
										 ayuda++;
									 }else{
										 ultimoactor.anadirPelicula(titulo[0]);
									 }
								 }else{
									 System.out.println("Ha ocurrido un error");
								 }
							 }else{
								 String[] division = linea.split("\t");
								 ultimoactor = new Actor(division[0]);
								 ListaActores.getListaActores().anadirActor(ultimoactor);
								 String[] titulo = division[2-ayuda].split(" *[(]+\\d+[)]");
								 titulo[0].replaceAll("[\"]","");
								 if(titulo[0].equals("\t")){
									 todobien=false;
									 ayuda++;
								 }else{
									 ultimoactor.anadirPelicula(titulo[0]);
								 }
							 }
						 }
					 }catch(ArrayIndexOutOfBoundsException ae){
							//A veces en vez de salir actriz\t\tpelicula solo hay un \t. Lo solucionamos aqui:
							todobien=false;
							ayuda++;
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
