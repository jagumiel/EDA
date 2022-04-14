package pruebas;

import lab3.Actor;
import lab3.ListaActoresPrincipal;
import lab3.Main;

public class PruebaEstanRelacionados {
	
	public static void main(){
		Actor a1 = new Actor(null);
		Actor a2 = new Actor(null);
		a1 = ListaActoresPrincipal.getListaActoresPrincipal().buscarActorNombre("Aalam, Roxanne");
		a2 = ListaActoresPrincipal.getListaActoresPrincipal().buscarActorNombre("Aalbu, Fern");
		if((a1!=null)&&(a2!=null)){
			System.out.println(Main.estanRelacionados2(a1, a2));
		}else{
			System.out.println("FATAL ERROR 1");
		}
		
		
		System.out.println("Prueba 2:");
		System.out.println("Vamos a hallar la distancia entre Aalam Roxanne y Aalbers Francisca que tiene que ser 0");
		a1 = ListaActoresPrincipal.getListaActoresPrincipal().buscarActorNombre("Aalam, Roxanne");
		a2 = ListaActoresPrincipal.getListaActoresPrincipal().buscarActorNombre("Aalbers, Francisca");
		if((a1!=null)&&(a2!=null)){
			System.out.println(Main.estanRelacionados2(a1, a2));
		}else{
			System.out.println("FATAL ERROR 2");
		}
		
		
		System.out.println("Prueba 3:");
		System.out.println("Vamos a hallar la distancia entre Aalam Roxanne y Aalbu, Harriet que tiene que ser 2");
		a1 = ListaActoresPrincipal.getListaActoresPrincipal().buscarActorNombre("Aalam, Roxanne");
		a2 = ListaActoresPrincipal.getListaActoresPrincipal().buscarActorNombre("Aalbu, Harriet");
		if((a1!=null)&&(a2!=null)){
			System.out.println(Main.estanRelacionados2(a1, a2));
		}else{
			System.out.println("FATAL ERROR 3");
		}
		
		
		
		System.out.println("Prueba 4:");
		System.out.println("Vamos a hallar la distancia entre Aalam Roxanne y Aalda, Mariann que tiene que ser 3");
		a1 = ListaActoresPrincipal.getListaActoresPrincipal().buscarActorNombre("Aalam, Roxanne");
		a2 = ListaActoresPrincipal.getListaActoresPrincipal().buscarActorNombre("Aalda, Mariann");
		if((a1!=null)&&(a2!=null)){
			System.out.println(Main.estanRelacionados2(a1, a2));
		}else{
			System.out.println("FATAL ERROR 4");
		}
		
		
		
		System.out.println("Prueba 5:");
		System.out.println("Vamos a hallar la distancia entre Aalam Roxanne y Aalderink, Jacqueline que tiene que ser 4");
		a1 = ListaActoresPrincipal.getListaActoresPrincipal().buscarActorNombre("Aalam, Roxanne");
		a2 = ListaActoresPrincipal.getListaActoresPrincipal().buscarActorNombre("Aalderink, Jacqueline");
		if((a1!=null)&&(a2!=null)){
			System.out.println(Main.estanRelacionados2(a1, a2));
		}else{
			System.out.println("FATAL ERROR 5");
		}
		
		
	}
}
