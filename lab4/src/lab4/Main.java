package lab4;

import java.io.*;  //Importo el Paquete Entero
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

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
					+ "6- Imprimir colegas de un actor\n"
					+ "7- Ver relación entre dos actores (distancia)\n"
					+ "8 ¿Estan relacionados los actores? (boolean)\n"
					+ "9- Ver relación entre dos actores (distancia y nombres)\n"
					+ "10- Hallar el grado de relaciones de los actores en la lista\n"
					+ "11- Mostrar Top 10 (Más nodos)\n"
					+ "12- top\n"
					+ "13- Salir");
			switch(entrada){
			case "1":
				JFileChooser fc = new JFileChooser();
				fc.setCurrentDirectory(new File("."));
				fc.setDialogTitle("Elige un fichero"); 
				fc.setAcceptAllFileFilterUsed(false);  
				if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) { //Comprueba que hemos seleccionado un archivo
					StopWatch crono = new StopWatch();
					Main.getMain().cargarFichero(fc.getSelectedFile()); 
					System.out.println(crono.elapsedTime());
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
				String auuuux = JOptionPane.showInputDialog("Introduce el nombre del actor");
				Actor aaux = ListaActoresPrincipal.getListaActoresPrincipal().buscarActorNombre(auuuux);
				if(aaux!=null){
					aaux.imprimirInformacion();
				}else{
					JOptionPane.showMessageDialog(null, "El actor introducido es incorrecto");
				}
				break;
			case "7":
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
			case "8":
				String compar1 = JOptionPane.showInputDialog("Introduce el nombre del actor");
				String compar2 = JOptionPane.showInputDialog("Introduce el nombre del actor");
				Actor acompar1 = ListaActoresPrincipal.getListaActoresPrincipal().buscarActorNombre(compar1);
				Actor acompar2 = ListaActoresPrincipal.getListaActoresPrincipal().buscarActorNombre(compar2);
				boolean relacionados = false;
				if((acompar1!=null)&&(acompar2!=null)){
					relacionados = estanRelacionadosBool(acompar1,acompar2);
				
				}else{
					JOptionPane.showMessageDialog(null,"Uno de los actores introducidos no se encuentra en la Lista de Actores");
				}
				System.out.println(relacionados);
				break;
				
			case "9":
				String comparas1 = JOptionPane.showInputDialog("Introduce el nombre del actor");
				String comparas2 = JOptionPane.showInputDialog("Introduce el nombre del actor");
				Actor acomparas1 = ListaActoresPrincipal.getListaActoresPrincipal().buscarActorNombre(comparas1);
				Actor acomparas2 = ListaActoresPrincipal.getListaActoresPrincipal().buscarActorNombre(comparas2);
				Pila<Actor> distancias=new Pila<Actor>(ListaActoresPrincipal.getListaActoresPrincipal().getTamano());
				if((acomparas1!=null)&&(acomparas2!=null)){
					distancias = estanRelacionadosCola(acomparas1,acomparas2);
				}else{
					JOptionPane.showMessageDialog(null,"Uno de los actores introducidos no se encuentra en la Lista de Actores");
				}
				try{
					while(distancias!=null){
						System.out.println(distancias.sacarPrimerElemento().getNombre());
					}
				}catch(Exception e){}
				break;
			case "10":
				System.out.println(Main.getMain().gradoRelaciones());
				break;
			case "11":
				ArrayList<Actor>top=Main.getMain().nodoCentral(ListaActoresPrincipal.getListaActoresPrincipal().getMilista());
				/*Iterator<Actor> iterador = top.iterator();
				while(iterador.hasNext()){
					System.out.println(iterador.next().getNombre());
				}*/
				break;	
				
			case"12":
				Actor one;
				String reps = JOptionPane.showInputDialog("Introduce cuantos casos analizar");
				int repes=Integer.parseInt(reps);
				if(repes<ListaActoresPrincipal.getListaActoresPrincipal().getTamano()){
					one=hallarNodoCentral(repes);
					System.out.println(one.getNombre());
				}
				
			case "13":
				repetir=false;
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
	
	
	public static int estanRelacionados(Actor actor1, Actor actor2){
		boolean enc = false;
		Pila<String> porExaminar = new Pila<String>(ListaActoresPrincipal.getListaActoresPrincipal().getTamano());
		ListaActores examinados = new ListaActores();
		porExaminar.anadir(actor1.getNombre());
		Actor actoraexaminar = new Actor("Actor por Defecto");
		Iterator<String> iteradordecolegas;
		String saux;
		Actor aaux;
		int nivel = 1;
		actor1.setNivel(nivel);//Porque si lo encuentra de primeras devuelve 0.
		ArrayList<String> caminomascorto = new ArrayList<String>();
		caminomascorto.add(actor1.getNombre());
		
		while((enc==false)&&(porExaminar.getTamano()>0)){
			saux = porExaminar.sacarPrimerElemento();
			actoraexaminar = ListaActoresPrincipal.getListaActoresPrincipal().getMilista().get(saux);
			if(actoraexaminar.getColegas().estaActor(actor2)){
				enc=true;
				caminomascorto.add(actor2.getNombre());
			}else{
				iteradordecolegas = actoraexaminar.getColegas().getIterador();
				nivel=actoraexaminar.getNivel()+1;
				while(iteradordecolegas.hasNext()){
					saux = iteradordecolegas.next();
					aaux = actoraexaminar.getColegas().getMiListaActores().get(saux);
					if((aaux!=null)&&(!examinados.estaActor(aaux))){
						aaux.setNivel(nivel);
						porExaminar.anadir(aaux.getNombre());
						examinados.anadirActor(aaux);
					}
				}
				caminomascorto.add(actor1.getNombre());
			}
		}
		
		//--------------------------------------------------------------------------------------------------
		
		int resultado=actoraexaminar.getNivel();
		while(porExaminar.getTamano()!=0){
			saux = porExaminar.sacarPrimerElemento();
			Actor a = ListaActoresPrincipal.getListaActoresPrincipal().getMilista().get(saux);
			ListaActoresPrincipal.getListaActoresPrincipal().buscarActor(a).setNivel(0);
			//Esto borra la lista de actores porExaminar y ademas restaura su valor a 0.
		}
		while(examinados.getIterador().hasNext()){
			String a1=examinados.getIterador().next();
			ListaActoresPrincipal.getListaActoresPrincipal().buscarActorNombre(a1).setNivel(0);
			examinados.eliminarActor(examinados.buscarActorNombre(a1));
			/*Hace lo mismo con los examinados. Esto es porque si lo dejamos igual y
			volvemos a hacer otra búsqueda, el resultado no sería correcto, ya que
			tendrían niveles asignados.*/
		}
		
		//-----------------------------------------------------------------------------------------------------
		
		for(String s:caminomascorto){
			System.out.print(s+" - ");
		}
			
		return resultado;	
	}
	
	public static boolean estanRelacionadosBool(Actor pActor1, Actor pActor2){
		boolean enc=false;
		if(estanRelacionados(pActor1, pActor2)>0){
			enc=true;
		}
		return enc;
	}
	
	
	public static Pila<Actor> estanRelacionadosCola(Actor actor1, Actor actor2){
		boolean enc = false;
		Pila <Actor> camino=new Pila<Actor>(ListaActoresPrincipal.getListaActoresPrincipal().getTamano());
		Pila<Actor> porExaminar = new Pila<Actor>(ListaActoresPrincipal.getListaActoresPrincipal().getTamano());
		ListaActores examinados = new ListaActores();
		porExaminar.anadir(actor1);
		Actor actoraexaminar = new Actor("Actor por Defecto");
		Iterator<String> iteradordecolegas;
		String saux;
		Actor aaux;
		int nivel = 1;
		actor1.setNivel(nivel);//Porque si lo encuentra de primeras devuelve 0
		
		while((enc==false)&&(porExaminar.getTamano()>0)){
			actoraexaminar = porExaminar.sacarPrimerElemento();
			if(actoraexaminar.getColegas().estaActor(actor2)){
				enc=true;
			}else{
				iteradordecolegas = actoraexaminar.getColegas().getIterador();
				nivel=actoraexaminar.getNivel()+1;
				String ultiActorNom=actoraexaminar.getNombre();
				Actor ultiActor=ListaActoresPrincipal.getListaActoresPrincipal().buscarActorNombre(ultiActorNom);
				while(iteradordecolegas.hasNext()){
					saux = iteradordecolegas.next();
					aaux = actoraexaminar.getColegas().getMiListaActores().get(saux);
					if((aaux!=null)&&(!examinados.estaActor(aaux))){
						aaux.setNivel(nivel);
						aaux.setUltiActor(ultiActor);
						porExaminar.anadir(aaux);
						examinados.anadirActor(aaux);
					}
				}
			}
		}
		int resultado=actoraexaminar.getNivel();
		if (resultado!=0){
			camino.anadir(actor2);
			Actor ulti=actoraexaminar;
			while (ulti!=null){
				camino.anadir(ulti);
				ulti=ulti.getUltActor();
			}
		}
		
		while(porExaminar.getTamano()!=0){
			Actor a=porExaminar.sacarPrimerElemento();
			ListaActoresPrincipal.getListaActoresPrincipal().buscarActor(a).setNivel(0);
			ListaActoresPrincipal.getListaActoresPrincipal().buscarActor(a).setUltiActor(null);
			//Esto borra la lista de actores porExaminar, restaura su valor a 0 y restaura ultiActor.
		}
		while(examinados.getIterador().hasNext()){
			String a1=examinados.getIterador().next();
			ListaActoresPrincipal.getListaActoresPrincipal().buscarActorNombre(a1).setNivel(0);
			ListaActoresPrincipal.getListaActoresPrincipal().buscarActorNombre(a1).setUltiActor(null);
			examinados.eliminarActor(examinados.buscarActorNombre(a1));
			/*Hace lo mismo con los examinados. Esto es porque si lo dejamos igual y
			volvemos a hacer otra búsqueda, el resultado no sería correcto, ya que
			tendrían niveles asignados.*/
		}
			
		return camino;	
	}
	
	public double gradoRelaciones(){
		double gr = 0;
		int numeropruebas = ListaActoresPrincipal.getListaActoresPrincipal().getTamano();
		
		if(numeropruebas>500){
			numeropruebas=500;
		}
		
		boolean fin = false;
		String[] arraynombres = new String[ListaActoresPrincipal.getListaActoresPrincipal().getTamano()];
		arraynombres = rellenarArray();
		int r1;
		int r2;
		double distancia = 0;
		double distanciaantigua = 0;
		int cont = 0; //Borrar tras las pruebas
		Random rg = new Random();
		Actor a1;
		Actor a2;
		
		while(!fin){
			
			for (int i=0; i<numeropruebas; i++){
				r1 = rg.nextInt(ListaActoresPrincipal.getListaActoresPrincipal().getTamano());
				r2 = rg.nextInt(ListaActoresPrincipal.getListaActoresPrincipal().getTamano());
				a1 = ListaActoresPrincipal.getListaActoresPrincipal().buscarActorNombre(arraynombres[r1]);
				a2 = ListaActoresPrincipal.getListaActoresPrincipal().buscarActorNombre(arraynombres[r2]);
				distancia += estanRelacionados(a1, a2);
			}
			
			distancia /= numeropruebas;
			
			//Borrar tras las pruebas (o no)
			cont++;
			System.out.println("Vuelta número: "+cont);
			System.out.println(distancia);
			System.out.println(distanciaantigua);
			System.out.println(fin);
			
			
			if((distancia-0.05<distanciaantigua)&&(distanciaantigua<distancia+0.05)){
				fin = true;
				gr = distancia;
			}else{
				numeropruebas*=2;
				distanciaantigua=distancia;
				distancia = 0;
			}
		}
		
		return gr;
	}

	public String[] rellenarArray(){
		String[] miarray = new String[ListaActoresPrincipal.getListaActoresPrincipal().getTamano()];
		int cont = 0;
		
		Object[] arraydellaves = ListaActoresPrincipal.getListaActoresPrincipal().getMilista().keySet().toArray();
		for(Object a :arraydellaves){
			miarray[cont] = a.toString();
			cont++;
		}
		
		
		return miarray;
	}
 
	public ArrayList<Actor> nodoCentral(HashMap<String,Actor> pMiMapa) {
		ArrayList<Actor> topActores = new ArrayList<Actor>();
		Iterator<String> it = ListaActoresPrincipal.getListaActoresPrincipal().getIterador();
		for(int i=0; i<10;i++){
			//Suponemos que trabajamos con una lista de actores grande, asi que siempre tendrá más de 10 elementos.
			ListaActoresPrincipal.getListaActoresPrincipal().getIterador();
			String pActorNom=it.next();
			Actor pActor=ListaActoresPrincipal.getListaActoresPrincipal().buscarActorNombre(pActorNom);
			topActores.add(pActor);//TODO, siempre me está metiendo al primer actor, el array se llena con el mismo actor. ERROR.
			//Hasta aqui llenamos una lista con los 10 primeros actores.
		}
		
		Iterator<String> itr = ListaActoresPrincipal.getListaActoresPrincipal().getIterador();
		
		while(itr.hasNext()){
			String pActorNom=itr.next();
			Actor pActor=ListaActoresPrincipal.getListaActoresPrincipal().buscarActorNombre(pActorNom);
			int min=this.buscarPosMin(topActores);
			if(pActor.getNumColegas()>topActores.get(min).getNumColegas()){
				topActores.add(min, pActor);
			}
		}
		//Metodo para imprimir el top 10 de actores
		for (int j=0; j < 10; j++) {
			Actor aux = topActores.get(j);
			System.out.println(aux.getNombre());
		}
		//Orden constante, 10 iteraciones, la longitud del array;
		return topActores;
	}
	
	public int buscarPosMin(ArrayList<Actor>pTop){
		int pos=0;
		int i=0;
		while(i<10) {
		    if (pTop.get(i).getNumColegas()<=pTop.get(pos).getNumColegas()) {
		        pos=i;
		    }
		    i++;
		}
		return pos;
		//TODO AQUI FALLA.
	}
	
	
	//public
	
	
	/*public ArrayList<Actor> losDeMasCentralidad(int n){
		ArrayList<Actor> centrales = new ArrayList<Actor>();
		
		
		
		return centrales;
	}*/
		
	public static Actor hallarNodoCentral(int repes){
		int i=0;
		Pila<Actor> miPila=new Pila<Actor>(ListaActoresPrincipal.getListaActoresPrincipal().getTamano());
		while(i<repes){
			Random gen1 = new Random();
			Random gen2 = new Random();
			Object[] values = ListaActoresPrincipal.getListaActoresPrincipal().getMilista().values().toArray();
			Actor randomActor1 = (Actor)values[gen1.nextInt(values.length)];
			Actor randomActor2 = (Actor)values[gen2.nextInt(values.length)];
			//Esto coge un actor aleatorio de la lista de actores principal.
			Pila<Actor> miPilaAux=new Pila<Actor>(ListaActoresPrincipal.getListaActoresPrincipal().getTamano());
			miPilaAux=estanRelacionadosCola(randomActor1, randomActor2);
			//Ahora apilamos los actores resultantes en la pila principal.
			while(miPilaAux.getTamano()!=0){
				miPila.anadir(miPilaAux.sacarPrimerElemento());
			}
			i++;
		}
		//Ahora tenemos una pila con todos los actores, hay que apuntar sus repeticiones.
		while(miPila.getTamano()!=0){
			Actor aux=miPila.sacarPrimerElemento();
			aux.setRepeticiones(aux.getRepeticiones()+1);
		}
		//Ahora hemos seteado las veces que un actor aparece repetido cuando hayamos el camino entre dos actores diferentes.
		//Es hora de recorrer el HashMap con el iterador y mirar quien es el actor que en más caminos aparece.
		String topNom=ListaActoresPrincipal.getListaActoresPrincipal().getIterador().next();
		Actor top=ListaActoresPrincipal.getListaActoresPrincipal().buscarActorNombre(topNom);
		//inicializamos top
		while(ListaActoresPrincipal.getListaActoresPrincipal().getIterador().hasNext()){
			String a1=ListaActoresPrincipal.getListaActoresPrincipal().getIterador().next();
			Actor ac1=ListaActoresPrincipal.getListaActoresPrincipal().buscarActorNombre(a1);
			if(ac1.getRepeticiones()>top.getRepeticiones()){
				top=ac1;
			}
		}
		//Ahora hay que restaurar todos los valores de repeticiones a 0
		while(ListaActoresPrincipal.getListaActoresPrincipal().getIterador().hasNext()){
			String aux=ListaActoresPrincipal.getListaActoresPrincipal().getIterador().next();
			ListaActoresPrincipal.getListaActoresPrincipal().buscarActorNombre(aux).setRepeticiones(0);
		}
		return top;
	}
}

/*
 *1er ejercicio: 
 *for i in 1..numPruebas{
 *	Generar Aleatoriamente x,y Tomamos una muestra(Hacemos pruebas de distintos tamaños hasta que los resultados obtenidos no difieran mucho entre si)
 *	calcular dist(x,y)
 *}
 *hacer media 
 *
 *
 *Random rg = new Random()
 *int x = rg.nextInt(numeroactores)
 *
 *
 *Para acceder al actor por posicion, creamos un ArrayList de claves
 *T.Hash.keySet().toArray(); <-- PROBAR ESTO
 *
 *-----------------------------------------------------------------------
 *
 *2º ejercicio:
 *Centralidad(a)
 *cont=0
 *for i in 1..numPruebas
 *	Genero aleatoriamente x,y
 *	Si a pertenece al camino entre x e y
 *		cont++;
 *	}
 *}
 *centralidad de a = numero de apariciones de a/numero de actores en el grafo
 *
 *-------------------------------------------------------------------------
 *
 *Del Labo Anterior: Hacer que imprima el camino del recorrido minimo
 *
 *-------------------------------------------------------------------------
 *
 *3er Ejercicio:
 *Para saber los actores de mas centralidad, hacemos pruebas hallando el camino 
 *mas corto entrte dos actores Random, y apuntamos en una tabla los actores 
 *que están por medio y el número de veces que aparecen
 *
 *Si hacemos el tercer ejercicio no hay que hacer el segundo.
 *Se puede hacer un filtrado para que no aparezcan cantantes.
 */
