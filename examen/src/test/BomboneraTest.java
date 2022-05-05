package test;

import packSorteo.*;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BomboneraTest {
	private ListaNumeros l;

	@Before
	public void setUp() throws Exception {  
		l = new ListaNumeros();
	}

	@After
	public void tearDown() throws Exception {
		l = null;
	}

	@Test
	public void testRealizarSorteo() {
		System.out.println("Prueba 1:");
		l = Bombonera.getBombonera().realizarSorteo();
		l.imprimir();
		
		System.out.println("Prueba 2:");
		l = Bombonera.getBombonera().realizarSorteo();
		l.imprimir();
		
		System.out.println("Prueba 3:");
		l = Bombonera.getBombonera().realizarSorteo();
		l.imprimir();
		
		System.out.println("Prueba 4:");
		l = Bombonera.getBombonera().realizarSorteo();
		l.imprimir();
		
		System.out.println("Prueba 5:");
		l = Bombonera.getBombonera().realizarSorteo();
		l.imprimir();
	}

}
