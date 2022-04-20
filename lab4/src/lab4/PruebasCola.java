package lab4;
public class PruebasCola {
	
	public static void main(String[] args){
		Cola<Integer> c = new Cola<Integer>(3);
		System.out.println("Añado el 3");
		c.anadirElemento(3);
		System.out.println("El tamaño de la cola tiene que ser 1 y es: "+c.getTamano());
		c.imprimir();

		System.out.println("Añado el 6");
		c.anadirElemento(6);
		System.out.println("El tamaño de la cola tiene que ser 2 y es: "+c.getTamano());
		c.imprimir();
		
		System.out.println("Añado el 23");
		c.anadirElemento(23);
		System.out.println("El tamaño de la cola tiene que ser 3 y es: "+c.getTamano());
		c.imprimir();
		
		System.out.println("Añado el 567");
		c.anadirElemento(567);
		System.out.println("El tamaño de la cola tiene que ser 3 y es: "+c.getTamano());
		c.imprimir();
		
		System.out.println("Saco el primero");
		c.sacarPrimerElemento();
		System.out.println("El tamaño de la cola tiene que ser 2 y es: "+c.getTamano());
		c.imprimir();
		
		System.out.println("Añado el 400");
		c.anadirElemento(400);
		System.out.println("El tamaño de la cola tiene que ser 3 y es: "+c.getTamano());
		c.imprimir();
		
		System.out.println("Saco el primero");
		c.sacarPrimerElemento();
		System.out.println("El tamaño de la cola tiene que ser 2 y es: "+c.getTamano());
		c.imprimir();
		
		System.out.println("Saco el primero");
		c.sacarPrimerElemento();
		System.out.println("El tamaño de la cola tiene que ser 1 y es: "+c.getTamano());
		c.imprimir();
		
		System.out.println("Añado el 4142");
		c.anadirElemento(4142);
		System.out.println("El tamaño de la cola tiene que ser 2 y es: "+c.getTamano());
		c.imprimir();
	}

}
