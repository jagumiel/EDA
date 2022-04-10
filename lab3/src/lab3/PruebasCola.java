package lab3;

public class PruebasCola {
	
	public static void main(String[] args){
		Cola<Integer> c = new Cola<Integer>(3);
		System.out.println("Añado el 3");
		c.anadir(3);
		System.out.println("El tamaño de la cola tiene que ser 1 y es: "+c.getTamano());
		c.imprimirCola();

		System.out.println("Añado el 6");
		c.anadir(6);
		System.out.println("El tamaño de la cola tiene que ser 2 y es: "+c.getTamano());
		c.imprimirCola();
		
		System.out.println("Añado el 23");
		c.anadir(23);
		System.out.println("El tamaño de la cola tiene que ser 3 y es: "+c.getTamano());
		c.imprimirCola();
		
		System.out.println("Añado el 567");
		c.anadir(567);
		System.out.println("El tamaño de la cola tiene que ser 3 y es: "+c.getTamano());
		c.imprimirCola();
		
		System.out.println("Saco el primero");
		c.sacarPrimerElemento();
		System.out.println("El tamaño de la cola tiene que ser 2 y es: "+c.getTamano());
		c.imprimirCola();
		
		System.out.println("Añado el 400");
		c.anadir(400);
		System.out.println("El tamaño de la cola tiene que ser 3 y es: "+c.getTamano());
		c.imprimirCola();
		
		System.out.println("Saco el primero");
		c.sacarPrimerElemento();
		System.out.println("El tamaño de la cola tiene que ser 2 y es: "+c.getTamano());
		c.imprimirCola();
		
		System.out.println("Saco el primero");
		c.sacarPrimerElemento();
		System.out.println("El tamaño de la cola tiene que ser 1 y es: "+c.getTamano());
		c.imprimirCola();
		
		System.out.println("Añado el 4142");
		c.anadir(4142);
		System.out.println("El tamaño de la cola tiene que ser 2 y es: "+c.getTamano());
		c.imprimirCola();
	}

}
