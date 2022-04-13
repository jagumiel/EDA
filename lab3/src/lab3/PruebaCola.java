package lab3;

import lab3.Cola;



public class PruebaCola {
	
	private static Cola<Integer> micoladepruebas;
	
	public static void main(String[] args){
		 System.out.println("Prueba 1: ");
		 micoladepruebas = new Cola(5);
		 
		
		System.out.println("Compruebo que efctivamente est� vac�a: ");
		micoladepruebas.imprimir();
		
		System.out.println("A�ado el 5");
		System.out.println(micoladepruebas.anadirElemento(5));
		System.out.println("La cola es: ");
		micoladepruebas.imprimir();

		System.out.println();
		System.out.println("A�ado el 8");
		System.out.println(micoladepruebas.anadirElemento(8));
		System.out.println("La cola es: ");
		micoladepruebas.imprimir();

		System.out.println();
		System.out.println("A�ado el 10");
		System.out.println(micoladepruebas.anadirElemento(10));
		System.out.println("La cola es: ");
		micoladepruebas.imprimir();

		System.out.println();
		System.out.println("A�ado el 13");
		System.out.println(micoladepruebas.anadirElemento(13));
		System.out.println("La cola es: ");
		micoladepruebas.imprimir();

		System.out.println();
		System.out.println("A�ado el 25");
		System.out.println(micoladepruebas.anadirElemento(25));
		System.out.println("La cola es: ");
		micoladepruebas.imprimir();

		System.out.println();
		System.out.println("A�ado el 50 y comprobamos que como la cola est� llena no se mete");
		System.out.println(micoladepruebas.anadirElemento(50));
		System.out.println("La cola es: ");
		micoladepruebas.imprimir();
		
		

		System.out.println();
		System.out.println();
		System.out.println("AHORA EMPEZAMOS A QUITAR ELEMENTOS");
		System.out.println("Quito el primer elemento (5)");
		System.out.println(micoladepruebas.sacarPrimerElemento());
		System.out.println("La cola es: ");
		micoladepruebas.imprimir();

		System.out.println();
		System.out.println("Quito el primer elemento (8)");
		System.out.println(micoladepruebas.sacarPrimerElemento());
		System.out.println("La cola es: ");
		micoladepruebas.imprimir();

		System.out.println();
		System.out.println("Quito el primer elemento (10)");
		System.out.println(micoladepruebas.sacarPrimerElemento());
		System.out.println("La cola es: ");
		micoladepruebas.imprimir();

		System.out.println();
		System.out.println();
		System.out.println("AHORA VUELVO A A�ADIR");
		System.out.println("A�ado el 7");
		System.out.println(micoladepruebas.anadirElemento(7));
		System.out.println("La cola es: ");
		micoladepruebas.imprimir();

		System.out.println();
		System.out.println("A�ado el 112");
		System.out.println(micoladepruebas.anadirElemento(112));
		System.out.println("La cola es: ");
		micoladepruebas.imprimir();

		System.out.println();
		System.out.println("A�ado el 666");
		System.out.println(micoladepruebas.anadirElemento(666));
		System.out.println("La cola es: ");
		micoladepruebas.imprimir();

		System.out.println();
		System.out.println("A�ado el 5000 y comprobamos que como la cola est� llena no se mete");
		System.out.println(micoladepruebas.anadirElemento(5000));
		System.out.println("La cola es: ");
		micoladepruebas.imprimir();
		

		System.out.println();
		System.out.println();
		System.out.println("Y por �ltimo pruebo quitando one more time");
		System.out.println("Quito el primer elemento (13)");
		System.out.println(micoladepruebas.sacarPrimerElemento());
		System.out.println("La cola es: ");
		micoladepruebas.imprimir();

		System.out.println();
		System.out.println("Quito el primer elemento (25)");
		System.out.println(micoladepruebas.sacarPrimerElemento());
		System.out.println("La cola es: ");
		micoladepruebas.imprimir();

		System.out.println();
		System.out.println("Quito el primer elemento (7)");
		System.out.println(micoladepruebas.sacarPrimerElemento());
		System.out.println("La cola es: ");
		micoladepruebas.imprimir();
		
		System.out.println("Prueba 2:");
		Cola<Integer> c = new Cola<Integer>(3);
		System.out.println("A�ado el 3");
		c.anadirElemento(3);
		System.out.println("El tama�o de la cola tiene que ser 1 y es: "+c.getTamano());
		c.imprimir();

		System.out.println("A�ado el 6");
		c.anadirElemento(6);
		System.out.println("El tama�o de la cola tiene que ser 2 y es: "+c.getTamano());
		c.imprimir();
		
		System.out.println("A�ado el 23");
		c.anadirElemento(23);
		System.out.println("El tama�o de la cola tiene que ser 3 y es: "+c.getTamano());
		c.imprimir();
		
		System.out.println("A�ado el 567");
		c.anadirElemento(567);
		System.out.println("El tama�o de la cola tiene que ser 3 y es: "+c.getTamano());
		c.imprimir();
		
		System.out.println("Saco el primero");
		c.sacarPrimerElemento();
		System.out.println("El tama�o de la cola tiene que ser 2 y es: "+c.getTamano());
		c.imprimir();
		
		System.out.println("A�ado el 400");
		c.anadirElemento(400);
		System.out.println("El tama�o de la cola tiene que ser 3 y es: "+c.getTamano());
		c.imprimir();
		
		System.out.println("Saco el primero");
		c.sacarPrimerElemento();
		System.out.println("El tama�o de la cola tiene que ser 2 y es: "+c.getTamano());
		c.imprimir();
		
		System.out.println("Saco el primero");
		c.sacarPrimerElemento();
		System.out.println("El tama�o de la cola tiene que ser 1 y es: "+c.getTamano());
		c.imprimir();
		
		System.out.println("A�ado el 4142");
		c.anadirElemento(4142);
		System.out.println("El tama�o de la cola tiene que ser 2 y es: "+c.getTamano());
		c.imprimir();
	}

}
