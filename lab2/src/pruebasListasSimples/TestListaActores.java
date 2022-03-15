package pruebasListasSimples;

import junit.framework.TestCase;
import lab1.Actor;
import lab1.ListaActores;

public class TestListaActores extends TestCase {
	ListaActores l;
	Actor a1;
	Actor a2;
	Actor a3;
	Actor a4;

	protected void setUp() throws Exception {
		l = new ListaActores();
		a1 = new Actor("a");
		a2 = new Actor("b");
		a3 = new Actor("c");
		a4 = new Actor("z");
	}

	protected void tearDown() throws Exception {
		l = null;
		a1 = null;
		a2 = null;
		a3 = null;
		a4 = null;
	}

	public void testAnadiryEliminar(){
		assertEquals(l.getTamano(),0);
		l.anadirActor(a1);
		assertEquals(l.getTamano(),1);
		l.anadirActor(a4);
		assertEquals(l.getTamano(),2);
		l.anadirActor(a4);
		assertEquals(l.getTamano(),2);
		l.anadirActor(a2);
		assertEquals(l.getTamano(),3);
		l.anadirActor(a3);
		assertEquals(l.getTamano(),4);
		//l.imprimir();
		l.eliminarActor(a1);
		System.out.println("Hola");
		assertEquals(l.getTamano(),3);
		l.eliminarActor(a1);
		System.out.println("Hola");
		assertEquals(l.getTamano(),3);
		l.eliminarActor(a2);
		System.out.println("Hola");
		assertEquals(l.getTamano(),2);
		l.eliminarActor(a3);
		System.out.println("Hola");
		assertEquals(l.getTamano(),1);
		l.eliminarActor(a4);
		System.out.println("Hola");
		assertEquals(l.getTamano(),0);
	}
	
}
