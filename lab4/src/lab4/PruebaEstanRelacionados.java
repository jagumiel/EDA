package lab4;

import java.io.File;

public class PruebaEstanRelacionados {
	
	public static void main(String[] args){
		
		//Tengo el fichero en el sobremesa, ya lo adjuntaré.
		//Uso esto porque estoy hasta los cojones de tener que seleccionar el fichero
		File archivo = new File("C:\\Documents and Settings\\HP_Propietario\\Escritorio\\aaaa.txt");
		Main.getMain().cargarFichero(archivo);
		
		Actor a1 = null;
		Actor a2 = null;
		
		System.out.println("Prueba 1:");
		System.out.println("Vamos a hallar la distancia entre Aalam Roxanne y Aalbu Fern que tiene que ser 1");                     
		a1 = ListaActoresPrincipal.getListaActoresPrincipal().buscarActorNombre("Aalam, Roxanne");
		a2 = ListaActoresPrincipal.getListaActoresPrincipal().buscarActorNombre("Aalbu, Fern");
		if((a1!=null)&&(a2!=null)){
			System.out.println(Main.estanRelacionados(a1, a2));
		}else{
			System.out.println("FATAL ERROR 1");
		}
		
		
		System.out.println("Prueba 2:");
		System.out.println("Vamos a hallar la distancia entre Aalam Roxanne y Aalbers Francisca que tiene que ser 0");
		a1 = ListaActoresPrincipal.getListaActoresPrincipal().buscarActorNombre("Aalam, Roxanne");
		a2 = ListaActoresPrincipal.getListaActoresPrincipal().buscarActorNombre("Aalbers, Francisca");
		if((a1!=null)&&(a2!=null)){
			System.out.println(Main.estanRelacionados(a1, a2));
		}else{
			System.out.println("FATAL ERROR 2");
		}
		
		
		System.out.println("Prueba 3:");
		System.out.println("Vamos a hallar la distancia entre Aalam Roxanne y Aalbu, Harriet que tiene que ser 2");
		a1 = ListaActoresPrincipal.getListaActoresPrincipal().buscarActorNombre("Aalam, Roxanne");
		a2 = ListaActoresPrincipal.getListaActoresPrincipal().buscarActorNombre("Aalbu, Harriet");
		if((a1!=null)&&(a2!=null)){
			System.out.println(Main.estanRelacionados(a1, a2));
		}else{
			System.out.println("FATAL ERROR 3");
		}
		
		
		
		System.out.println("Prueba 4:");
		System.out.println("Vamos a hallar la distancia entre Aalam Roxanne y Aalda, Mariann que tiene que ser 3");
		a1 = ListaActoresPrincipal.getListaActoresPrincipal().buscarActorNombre("Aalam, Roxanne");
		a2 = ListaActoresPrincipal.getListaActoresPrincipal().buscarActorNombre("Aalda, Mariann");
		if((a1!=null)&&(a2!=null)){
			System.out.println(Main.estanRelacionados(a1, a2));
		}else{
			System.out.println("FATAL ERROR 4");
		}
		
		
		
		System.out.println("Prueba 5:");
		System.out.println("Vamos a hallar la distancia entre Aalam Roxanne y Aalderink, Jacqueline que tiene que ser 4");
		a1 = ListaActoresPrincipal.getListaActoresPrincipal().buscarActorNombre("Aalam, Roxanne");
		a2 = ListaActoresPrincipal.getListaActoresPrincipal().buscarActorNombre("Aalderink, Jacqueline");
		if((a1!=null)&&(a2!=null)){
			System.out.println(Main.estanRelacionados(a1, a2));
		}else{
			System.out.println("FATAL ERROR 5");
		}
	}
}
