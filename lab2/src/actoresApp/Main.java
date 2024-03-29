package actoresApp;

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
	
	
	//Otros M�todos
	
	public static void main(String[] args){
		boolean repetir;
		repetir = true;
		JOptionPane.showMessageDialog(null, "Bienvenido a la base virtual de cine");
		do{
			String entrada = JOptionPane.showInputDialog("�Qu� quieres hacer?\n"
					+ "1- Cargar fichero\n"
					+ "2- A�adir un actor\n"
					+ "3- A�adir una pelicula\n"
					+ "4- Ordenar la lista de actores\n"
					+ "5- Guardar fichero\n"
					+ "6- Salir");
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
				if(ListaActores.getListaActores().esta(anadir)){
					System.out.println("El actor ya se encuentra en la lista"); //ListaActores lo comprueba tambi�n pero poniendo esto aqui te ahorras meterle peliculas para nada.
				}else{
					boolean quedanpeliculas = true;
					String respuesta;
					do{
						respuesta = JOptionPane.showInputDialog("�Quieres a�adirle una pel�cula? (Si/No)");
						if (respuesta.equalsIgnoreCase("si")){
							anadir.anadirPelicula(JOptionPane.showInputDialog("Introduce el titulo de la pel�cula"));
						}else if (respuesta.equalsIgnoreCase("no")){
							quedanpeliculas=false;
						}else{
							JOptionPane.showMessageDialog(null, "La respuesta introducida es incorrecta. Por favor introduzca si o no");
						}
					}while (quedanpeliculas);
					ListaActores.getListaActores().anadirActor(anadir);
				}	
				break;
			case "3":
				ListaPeliculasPrincipal.getListaPeliculasPrincipal().anadirPelicula(new Pelicula(JOptionPane.showInputDialog("Introduce el titulo de la pel�cula")));
				break;
			case "4":/*
				Main.getMain().guardarFichero();
				break;
			case "5":*/
				repetir=false;
				break;
			default:
				JOptionPane.showMessageDialog(null, "La opci�n itroducida es incorrecta. Introduce un n�mero del 1 al 5.");
			}
		}while(repetir==true);	
	}
	
	
	
	public void cargarFichero(File nomF){
		try{
			 FileReader fr = new FileReader(nomF);
			 @SuppressWarnings("resource")
			BufferedReader br = new BufferedReader(fr);
			 String linea, tituloaux;
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
									 tituloaux = titulo[0].replaceAll("[\"]","");
									 if(tituloaux.equals("")){
										 todobien=false;
										 ayuda++;
									 }else{
										 ultimoactor.anadirPelicula(tituloaux);
									 }
								 }else{
									 JOptionPane.showMessageDialog(null, "Ha ocurrido un error");
								 }
							 }else{
								 String[] division = linea.split("\t");
								 if(ayuda==0){
									 ultimoactor = new Actor(division[0]);
									 if (ListaActores.getListaActores().esta(ultimoactor)){
										 Actor aux = ultimoactor;
										 ultimoactor = ListaActores.getListaActores().buscarActor(aux);
									 }else{
										 ListaActores.getListaActores().anadirActor(ultimoactor);
									 }
								 }
								 String[] titulo = division[2-ayuda].split(" *[(]+\\d+[)]");
								 tituloaux = titulo[0].replaceAll("\"","");
								 if(tituloaux.equals("\t")){
									 todobien=false;
									 ayuda++;
								 }else{
									 ultimoactor.anadirPelicula(tituloaux);
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
	
	
/*	public void guardarFichero(){
		FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter("C:\\actrices.txt");
            pw = new PrintWriter(fichero);
            String auxAct, auxPel;
            
            Iterator<String> itrAct = ListaActores.getListaActores().getIterador();
            Iterator<String> itrPel; 
            
            while(itrAct.hasNext()){
            	auxAct = itrAct.next();
            	pw.println(auxAct);
            	itrPel = ListaActores.getListaActores().getMilista().get(auxAct).getMiListaPeliculas().getIterador();
            	while(itrPel.hasNext()){
            		auxPel=itrPel.next();
            		pw.println("--> "+auxPel);
            	}
            }
 
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        finally {
           try {
	           if (null != fichero)
	              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
	}*/
	
}
