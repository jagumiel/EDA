package lab3;

import java.io.*;  //Importo el Paquete Entero
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

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
		repetir = true;
		JOptionPane.showMessageDialog(null, "Bienvenido a la base virtual de cine");
		do{
			String entrada = JOptionPane.showInputDialog("¿Qué quieres hacer?\n"
					+ "1- Cargar fichero\n"
					+ "2- Añadir un actor\n"
					+ "3- Añadir una pelicula\n"
					+ "4- Ordenar la lista de actores\n"
					+ "5- Guardar fichero\n"
					+ "6- Salir\n"
					+ "7- Imprimir colegas de un actor\n"
					+ "8- Ver relación entre dos actores");
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
				Pelicula anadepelicula;
				if(ListaActoresPrincipal.getListaActoresPrincipal().esta(anadir)){
					System.out.println("El actor ya se encuentra en la lista"); //ListaActores lo comprueba también pero poniendo esto aqui te ahorras meterle peliculas para nada.
				}else{
					boolean quedanpeliculas = true;
					String respuesta;
					do{
						respuesta = JOptionPane.showInputDialog("¿Quieres añadirle una película? (Si/No)");
						if (respuesta.equalsIgnoreCase("si")){
							anadepelicula = new Pelicula(JOptionPane.showInputDialog("Introduce el titulo de la película"));
							anadir.anadirPelicula(anadepelicula);
						}else if (respuesta.equalsIgnoreCase("no")){
							quedanpeliculas=false;
						}else{
							JOptionPane.showMessageDialog(null, "La respuesta introducida es incorrecta. Por favor introduzca si o no");
						}
					}while (quedanpeliculas);
					ListaActoresPrincipal.getListaActoresPrincipal().anadirActor(anadir);
				}	
				break;
			case "3":
				ListaPeliculasPrincipal.getListaPeliculasPrincipal().anadirPelicula(new Pelicula(JOptionPane.showInputDialog("Introduce el titulo de la película")));
				break;
			case "4":
				ListaActoresPrincipal.getListaActoresPrincipal().ordenarLista();
				break;
			case "5":
				Main.getMain().guardarFichero();
				break;
			case "6":
				repetir=false;
				break;
			case "7":
				String auuuux = JOptionPane.showInputDialog("Introduce el nombre del actor");
				Actor aaux = ListaActoresPrincipal.getListaActoresPrincipal().buscarActorNombre(auuuux);
				if(aaux!=null){
					aaux.imprimirInformacion();
				}else{
					JOptionPane.showMessageDialog(null, "El actor introducido es incorrecto");
				}
				break;
			case "8":
				String compara1 = JOptionPane.showInputDialog("Introduce el nombre del actor");
				String compara2 = JOptionPane.showInputDialog("Introduce el nombre del actor");
				Actor acompara1 = ListaActoresPrincipal.getListaActoresPrincipal().buscarActorNombre(compara1);
				Actor acompara2 = ListaActoresPrincipal.getListaActoresPrincipal().buscarActorNombre(compara2);
				int distancia = 0;
				if((acompara1!=null)&&(acompara2!=null)){
					distancia = estanRelacionados(acompara1,acompara2);
				}else{
					JOptionPane.showMessageDialog(null,"Uno de los actores introducidos no se encuentra en la Lista de Actores");
				}
				System.out.println(distancia);
				break;
			default:
				JOptionPane.showMessageDialog(null, "La opción introducida es incorrecta. Introduce un número del 1 al 5.");
			}
		}while(repetir==true);	
	}
	
	
	
	public void cargarFichero(File nomF){
		try{
			 FileReader fr = new FileReader(nomF);
			 @SuppressWarnings("resource")
			 BufferedReader br = new BufferedReader(fr);
			 String nombreactor;
			 String linea, tituloaux;
			 Actor ultimoactor = null;
			 Pelicula anadepelicula;
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
									 
									 
									 //Tenemos el título de la película
									 if(tituloaux.equals("")){
										 todobien=false;
										 ayuda++;
									 }else{
										 anadepelicula = ListaPeliculasPrincipal.getListaPeliculasPrincipal().buscarPeliNombre(tituloaux);
										 if(anadepelicula==null){
											 //No está en la Lista Principal de Peliculas
											 anadepelicula = new Pelicula(tituloaux);
											 ListaPeliculasPrincipal.getListaPeliculasPrincipal().anadirPelicula(anadepelicula);
											 ultimoactor.anadirPelicula(anadepelicula);
										 }else{
											 ultimoactor.anadirPelicula(anadepelicula);
										 }
									 }
									 
									 
								 }else{
									 JOptionPane.showMessageDialog(null, "Ha ocurrido un error");
								 }
							 }else{
								 String[] division = linea.split("\t");
								 nombreactor=division[0];
								 
								 
								 //Tenemos el nombre del actor
								 if(ayuda==0){
									 ultimoactor = ListaActoresPrincipal.getListaActoresPrincipal().buscarActorNombre(nombreactor);
									 if (ultimoactor==null){
										//No está en la Lista Principal de Actores
										 ultimoactor = new Actor(nombreactor);
										 ListaActoresPrincipal.getListaActoresPrincipal().anadirActor(ultimoactor);
									 }
								 }
								 
									 
								 String[] titulo = division[2-ayuda].split(" *[(]+\\d+[)]");
								 tituloaux = titulo[0].replaceAll("\"","");
								 
								 
								//Tenemos el titulo de la película	 
								 if(tituloaux.equals("\t")){
									 todobien=false;
									 ayuda++;
								 }else{
									 anadepelicula = ListaPeliculasPrincipal.getListaPeliculasPrincipal().buscarPeliNombre(tituloaux);
									 if(anadepelicula==null){
										 anadepelicula = new Pelicula(tituloaux);
										 ListaPeliculasPrincipal.getListaPeliculasPrincipal().anadirPelicula(anadepelicula);
										 ultimoactor.anadirPelicula(anadepelicula);
									 }else{
										 ultimoactor.anadirPelicula(anadepelicula);
									 }
								 }	 
							 }
						 }
					 }catch(ArrayIndexOutOfBoundsException ae){
							//A veces en vez de salir actriz\t\tpelicula solo hay un \t. Lo solucionamos aqui:
							todobien=false;
							ayuda++;
							ListaActoresPrincipal.getListaActoresPrincipal().eliminarActor(ultimoactor); //Para evitar duplicados
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
            fichero = new FileWriter("C:\\Documents and Settings\\euitibi\\Escritorio\\actrices.txt");
            pw = new PrintWriter(fichero);
            String auxAct, auxPel;
            
            Iterator<String> itrAct = ListaActoresPrincipal.getListaActoresPrincipal().getIterador();
            Iterator<String> itrPel; 
            
            while(itrAct.hasNext()){
            	auxAct = itrAct.next();
            	pw.println(auxAct);
            	itrPel = ListaActoresPrincipal.getListaActoresPrincipal().getMilista().get(auxAct).getMiListaPeliculas().getIterador();
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
	}
	
	
	/*public int estanRelacionados(Actor a1, Actor a2){
		int distancia = 0;
		Cola porExaminar = new Cola(ListaActoresPrincipal.getListaActoresPrincipal().getTamano());
		ListaActores examinados = new ListaActores();
		
		
		
		
		
		return distancia;
	
	
	public int estanRelacionados(Actor a1, Actor a2){
		int distancia=0;
		//boolean enc=false;
		Cola porExaminar = new Cola(ListaActoresPrincipal.getListaActoresPrincipal().getTamano());
		ListaActores examinados = new ListaActores();
		if(a1.getColegas().estaActor(a2)){
			distancia=distancia++;
			//enc=true;
		}else{
			//Crear un iterador, por cada colega de a1 lo anado a examinados porque ya lo he comprobado antes.
			Iterator<String> itColega=a1.getColegas().getIterador();
			while (itColega.hasNext()){
				String colegAux=itColega.next();
				Actor actorAux=ListaActoresPrincipal.getListaActoresPrincipal().buscarActorNombre(colegAux);
				examinados.anadirActor(actorAux);
				distancia=distancia++;
			}//Hasta aquí hemos comparado si a1 y a2 son amigos, y si no lo son, añadimos los colegas de a1 a examinados
			//TODO ahora hay que anadir los "porExaminar".
			itColega=examinados.getIterador();
			while (itColega.hasNext()){
				String actorAux=itColega.next();
				Actor colegAux=ListaActoresPrincipal.getListaActoresPrincipal().buscarActorNombre(actorAux);
				if(a2==colegAux){
					distancia++;
					return distancia;
				}
			}
		}
		return distancia;
	}
	
	public int estanRelacionados2(Actor a1, Actor a2){
		boolean enc=false;
		int distancia=0;
		Cola porExaminar = new Cola(ListaActoresPrincipal.getListaActoresPrincipal().getTamano());
		ListaActores examinados = new ListaActores();
		Iterator<String> itColega=a1.getColegas().getIterador();
		while (itColega.hasNext()){
			String colegAux=itColega.next();
			porExaminar.anadir(ListaActoresPrincipal.getListaActoresPrincipal().buscarActorNombre(colegAux));
		}
		distancia++;
		while(!enc){
			while(porExaminar.sacarUltimoElemento()!=null){
				if(a2.equals(porExaminar.sacarUltimoElemento())){	
					enc=true;
					return distancia;
				}
			examinados.anadirActor(porExaminar.sacarUltimoElemento());
			}
			Iterator<String> it2=examinados.getIterador();
			while(it2.hasNext()){
				String actor=it2.next();
				Actor a3=ListaActoresPrincipal.getListaActoresPrincipal().buscarActorNombre(actor);
				distancia=distancia+estanRelacionados2(a3, a2);
			}

		}
		//TODO hacer una llamada recursiva para que se vuelva a cargar la lista de elementos por examinar.
	return distancia;
	}*/
	
	/*public static int estanRelacionados(Actor a1, Actor a2){
		boolean enc=false;
		int distancia=1;
		Cola porExaminar = new Cola(ListaActoresPrincipal.getListaActoresPrincipal().getTamano());
		ListaActores examinados = new ListaActores();
		Iterator<String> itColega=a1.getColegas().getIterador();
		if(a1.getColegas().estaActor(a2)){
			return 1; //Aqui se rompe el metodo si son colegas.
		}else{
			while (itColega.hasNext()){
				String colegAux=itColega.next();
				porExaminar.anadir(ListaActoresPrincipal.getListaActoresPrincipal().buscarActorNombre(colegAux));
			}
			distancia=distancia+1;
			while((enc==false)||(porExaminar.getTamano()<0)){
				Actor aux=porExaminar.sacarUltimoElemento();
				if(aux.equals(a2)){
					enc=true;
				}
				else{
					examinados.anadirActor(aux);
					itColega=aux.getColegas().getIterador();
					while(itColega.hasNext()){
						String colegAux=itColega.next();
						porExaminar.anadir(ListaActoresPrincipal.getListaActoresPrincipal().buscarActorNombre(colegAux));
					}
				}
			}
		}
		//TODO no va a devolver la distancia correcta, pero sí que es capaz de decir si estan o no relacionados.
		return distancia;
	}*/
	
	
	public static int estanRelacionados(Actor actor1, Actor actor2){
		boolean enc = false;
		Cola<Actor> porExaminar = new Cola(ListaActoresPrincipal.getListaActoresPrincipal().getTamano());
		ListaActores examinados = new ListaActores();
		porExaminar.anadir(actor1);
		Actor actoraexaminar = new Actor("Actor por Defecto");
		Iterator<String> iteradordecolegas;
		String saux;
		Actor aaux;
		actoraexaminar = porExaminar.sacarPrimerElemento();
		int nivel = 1;
		if(actoraexaminar.getColegas().estaActor(actor2)){
			enc=true;
			return 1;
		}else{
			//Aqui copio
			iteradordecolegas = actoraexaminar.getColegas().getIterador();
			nivel=actoraexaminar.getNivel()+1;
			while(iteradordecolegas.hasNext()){
				saux = iteradordecolegas.next();
				aaux = actoraexaminar.getColegas().getMiListaActores().get(saux);
				if((aaux!=null)&&(!examinados.estaActor(aaux))){
					aaux.setNivel(nivel);
					porExaminar.anadir(aaux);
					examinados.anadirActor(aaux);
				}
			}
			//Aqui termino
		}
		
		actor1.setNivel(nivel);//Porque si lo encuentra de primeras devuelve 0
		
		while((enc==false)&&(porExaminar.getTamano()>0)){
			actoraexaminar = porExaminar.sacarPrimerElemento();
			if(actoraexaminar.equals(actor2)){
				enc=true;
			}else{
				iteradordecolegas = actoraexaminar.getColegas().getIterador();
				nivel=actoraexaminar.getNivel()+1;
				while(iteradordecolegas.hasNext()){
					saux = iteradordecolegas.next();
					aaux = actoraexaminar.getColegas().getMiListaActores().get(saux);
					if((aaux!=null)&&(!examinados.estaActor(aaux))){
						aaux.setNivel(nivel);
						porExaminar.anadir(aaux);
						examinados.anadirActor(aaux);
					}
				}
			}
		}
		if (enc){
			return actoraexaminar.getNivel();	
		}else{
			return (0);
		}
	}
}
