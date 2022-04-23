package pruebas;

import lab4.*;

import java.io.File;

public class PruebaEstanRelacionados {
	
	public static void main(String[] args){
		
		//Utilizo el fichero que esta en el src
		File archivo = new File("C:\\Users\\Mikel\\Desktop\\actresses-small-ok.txt");
		Main.getMain().cargarFichero(archivo);
		
		Actor a1 = null;
		Actor a2 = null;
		Pila<Actor> p = new Pila<Actor>(20);
		
		
		System.out.println("Prueba estanRelacionados (distancia)");
		
		System.out.println("Prueba 1:");
		System.out.println("Vamos a hallar la distancia entre Aaliste, Agnes y Aalders, Mairen que tiene que ser 0");                     
		a1 = ListaActoresPrincipal.getListaActoresPrincipal().buscarActorNombre("Aaliste, Agnes");
		a2 = ListaActoresPrincipal.getListaActoresPrincipal().buscarActorNombre("Aalders, Mairen");
		if((a1!=null)&&(a2!=null)){
			System.out.println(Main.estanRelacionados(a1, a2));
		}else{
			System.out.println("FATAL ERROR 1");
		}
		
		
		System.out.println("Prueba 2:");
		System.out.println("Vamos a hallar la distancia entre Aalam Roxanne y Aalbers Francisca que tiene que ser 1");
		a1 = ListaActoresPrincipal.getListaActoresPrincipal().buscarActorNombre("Aalam, Roxanne");
		a2 = ListaActoresPrincipal.getListaActoresPrincipal().buscarActorNombre("Aalbers, Francisca");
		if((a1!=null)&&(a2!=null)){
			System.out.println(Main.estanRelacionados(a1, a2));
		}else{
			System.out.println("FATAL ERROR 2");
		}
		
		
		System.out.println("Prueba 3:");
		System.out.println("Vamos a hallar la distancia entre Aalam Roxanne y Aalan, Lynne que tiene que ser 2");
		a1 = ListaActoresPrincipal.getListaActoresPrincipal().buscarActorNombre("Aalam, Roxanne");
		a2 = ListaActoresPrincipal.getListaActoresPrincipal().buscarActorNombre("Aalan, Lynne");
		if((a1!=null)&&(a2!=null)){
			System.out.println(Main.estanRelacionados(a1, a2));
		}else{
			System.out.println("FATAL ERROR 3");
		}
		
		
		
		System.out.println("Prueba 4:");
		System.out.println("Vamos a hallar la distancia entre Aalbregt, Djamilla y Aalia, Nila que tiene que ser 3");
		a1 = ListaActoresPrincipal.getListaActoresPrincipal().buscarActorNombre("Aalbregt, Djamilla");
		a2 = ListaActoresPrincipal.getListaActoresPrincipal().buscarActorNombre("Aalia, Nila");
		if((a1!=null)&&(a2!=null)){
			System.out.println(Main.estanRelacionados(a1, a2));
		}else{
			System.out.println("FATAL ERROR 4");
		}
		
		
		
		System.out.println("Prueba 5:");
		System.out.println("Vamos a hallar la distancia entre Aaliste, Agnes y Aalam, Schahla que tiene que ser 4");
		a1 = ListaActoresPrincipal.getListaActoresPrincipal().buscarActorNombre("Aaliste, Agnes");
		a2 = ListaActoresPrincipal.getListaActoresPrincipal().buscarActorNombre("Aalam, Schahla");
		if((a1!=null)&&(a2!=null)){
			System.out.println(Main.estanRelacionados(a1, a2));
		}else{
			System.out.println("FATAL ERROR 5");
		}
		
		System.out.println();
		System.out.println();
		System.out.println("Prueba estanRelacionados(boolean)");
		
		System.out.println("Prueba 6: Vamos a comprobar si Aalam, Schahla y Aalam, Roxanne son colegas, ha de responder true");
		a1 = ListaActoresPrincipal.getListaActoresPrincipal().buscarActorNombre("Aalam, Schahla");
		a2 = ListaActoresPrincipal.getListaActoresPrincipal().buscarActorNombre("Aalam, Roxanne");
		if((a1!=null)&&(a2!=null)){
			System.out.println(Main.estanRelacionadosBool(a1, a2));
		}else{
			System.out.println("FATAL ERROR 6");
		}
		
		
		System.out.println("Prueba 7: Vamos a comprobar si Aalam, Schahla y Aalgaard, Leannie son colegas, ha de responder false");
		a1 = ListaActoresPrincipal.getListaActoresPrincipal().buscarActorNombre("Aalam, Schahla");
		a2 = ListaActoresPrincipal.getListaActoresPrincipal().buscarActorNombre("Aalgaard, Leannie");
		if((a1!=null)&&(a2!=null)){
			System.out.println(Main.estanRelacionadosBool(a1, a2));
		}else{
			System.out.println("FATAL ERROR 7");
		}
		
		
		System.out.println("Prueba 8: Vamos a comprobar si Aalia, Nila y Aalbu, Fern son colegas, ha de responder true");
		a1 = ListaActoresPrincipal.getListaActoresPrincipal().buscarActorNombre("Aalia, Nila");
		a2 = ListaActoresPrincipal.getListaActoresPrincipal().buscarActorNombre("Aalbu, Fern");
		if((a1!=null)&&(a2!=null)){
			System.out.println(Main.estanRelacionadosBool(a1, a2));
		}else{
			System.out.println("FATAL ERROR 8");
		}
		
		
		System.out.println("Prueba 9: Vamos a comprobar si Aalbu, Courtney y Aalam, Roxanne son colegas, ha de responder false");
		a1 = ListaActoresPrincipal.getListaActoresPrincipal().buscarActorNombre("Aalbu, Courtney");
		a2 = ListaActoresPrincipal.getListaActoresPrincipal().buscarActorNombre("Aalam, Roxanne");
		if((a1!=null)&&(a2!=null)){
			System.out.println(Main.estanRelacionadosBool(a1, a2));
		}else{
			System.out.println("FATAL ERROR 9");
		}
		
		
		System.out.println("Prueba 10: Vamos a comprobar si Aalbers, Francisca y Aaliste, Agnes son colegas, ha de responder true");
		a1 = ListaActoresPrincipal.getListaActoresPrincipal().buscarActorNombre("Aalbers, Francisca");
		a2 = ListaActoresPrincipal.getListaActoresPrincipal().buscarActorNombre("Aaliste, Agnes");
		if((a1!=null)&&(a2!=null)){
			System.out.println(Main.estanRelacionadosBool(a1, a2));
		}else{
			System.out.println("FATAL ERROR 10");
		}
		
		System.out.println();
		System.out.println();
		System.out.println("Prueba estanRelacionados (distancia y nombres)");
		
		
		System.out.println("Prueba 11: Vamos a hallar el camino entre Aalam Roxanne y Aalbers Francisca y el resultado ha de ser vacío porque no hay actrices de por medio");
		a1 = ListaActoresPrincipal.getListaActoresPrincipal().buscarActorNombre("Aalbers, Francisca");
		a2 = ListaActoresPrincipal.getListaActoresPrincipal().buscarActorNombre("Aalam, Roxanne");
		if((a1!=null)&&(a2!=null)){
			p = Main.estanRelacionadosNombres(a1, a2);
			while(p.getTamano()>0){
				System.out.print("-"+p.sacarPrimerElemento().getNombre());
			}
			System.out.println();
		}else{
			System.out.println("FATAL ERROR 11");
		}
		
		System.out.println("Prueba 12: Vamos a hallar el camino entre Aalam Roxanne y Aalan, Lynne y el resultado ha de ser: Aalam, Schahla");
		a1 = ListaActoresPrincipal.getListaActoresPrincipal().buscarActorNombre("Aalan, Lynne");
		a2 = ListaActoresPrincipal.getListaActoresPrincipal().buscarActorNombre("Aalam, Roxanne");
		if((a1!=null)&&(a2!=null)){
			p = Main.estanRelacionadosNombres(a1, a2);
			while(p.getTamano()>0){
				System.out.print("-"+p.sacarPrimerElemento().getNombre());
			}
			System.out.println();
		}else{
			System.out.println("FATAL ERROR 12");
		}
		
		System.out.println("Prueba 13: Vamos a hallar el camino entre Aalbregt, Djamilla y Aalia, Nila y el resultado ha de ser: Aalam, Roxanne-Aalbers, Francisca");
		a1 = ListaActoresPrincipal.getListaActoresPrincipal().buscarActorNombre("Aalbregt, Djamilla");
		a2 = ListaActoresPrincipal.getListaActoresPrincipal().buscarActorNombre("Aalia, Nila");
		if((a1!=null)&&(a2!=null)){
			p = Main.estanRelacionadosNombres(a1, a2);
			while(p.getTamano()>0){
				System.out.print("-"+p.sacarPrimerElemento().getNombre());
			}
			System.out.println();
		}else{
			System.out.println("FATAL ERROR 13");
		}
		
		
		System.out.println("Prueba 14: Vamos a hallar el camino entre Aaliste, Agnes y Aalam, Schahla y el resultado ha de ser: Aalia, Nila-Aalbers, Francisca-Aalam, Roxanne");
		a1 = ListaActoresPrincipal.getListaActoresPrincipal().buscarActorNombre("Aaliste, Agnes");
		a2 = ListaActoresPrincipal.getListaActoresPrincipal().buscarActorNombre("Aalam, Schahla");
		if((a1!=null)&&(a2!=null)){
			p = Main.estanRelacionadosNombres(a1, a2);
			while(p.getTamano()>0){
				System.out.print("-"+p.sacarPrimerElemento().getNombre());
			}
			System.out.println();
		}else{
			System.out.println("FATAL ERROR 13");
		}
		
		
		System.out.println("Prueba 15: Vamos a hallar el camino entre Aaliste, Agnes y Aalan, Lynne y el resultado ha de ser: Aalia, Nila-Aalbers, Francisca-Aalam, Roxanne-Aalam, Schahla");
		a1 = ListaActoresPrincipal.getListaActoresPrincipal().buscarActorNombre("Aaliste, Agnes");
		a2 = ListaActoresPrincipal.getListaActoresPrincipal().buscarActorNombre("Aalan, Lynne");
		if((a1!=null)&&(a2!=null)){
			p = Main.estanRelacionadosNombres(a1, a2);
			while(p.getTamano()>0){
				System.out.print("-"+p.sacarPrimerElemento().getNombre());
			}
			System.out.println();
		}else{
			System.out.println("FATAL ERROR 13");
		}
	}
}
