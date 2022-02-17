package lab1;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ListaActoresTest {
	Actor actor1;
	Actor actor2;
	Actor actor3;
	Actor actor4;
	Actor actor5;

	@Before
	public void setUp() throws Exception {
		actor1 = new Actor("Robert Downey Jr");
		actor2 = new Actor("David Duchovny");
		actor3 = new Actor("Neil Patrick Harris");
		actor4 = new Actor("Chuck Norris");
	}

	@After
	public void tearDown() throws Exception {
		actor1=null;
		actor2=null;
		actor3=null;
		actor4=null;
		actor5=null;
		ListaActores.getListaActores().resetear();
	}

	@Test
	public void testAnadirActor() {
		assertEquals(ListaActores.getListaActores().getTamano(),0);
		ListaActores.getListaActores().anadirActor(actor1);
		assertEquals(ListaActores.getListaActores().getTamano(),1);
		ListaActores.getListaActores().anadirActor(actor2);
		assertEquals(ListaActores.getListaActores().getTamano(),2);
		ListaActores.getListaActores().anadirActor(actor3);
		assertEquals(ListaActores.getListaActores().getTamano(),3);
		ListaActores.getListaActores().anadirActor(actor1);
		assertEquals(ListaActores.getListaActores().getTamano(),3);
		ListaActores.getListaActores().anadirActor(actor4);
		assertEquals(ListaActores.getListaActores().getTamano(),4);
		ListaActores.getListaActores().anadirActor(actor5);
		assertEquals(ListaActores.getListaActores().getTamano(),4);
	}

	@Test
	public void testEliminarActor() {
		ListaActores.getListaActores().anadirActor(actor1);
		ListaActores.getListaActores().anadirActor(actor2);
		ListaActores.getListaActores().anadirActor(actor3);
		ListaActores.getListaActores().anadirActor(actor4);
		assertEquals(ListaActores.getListaActores().getTamano(),4);
		ListaActores.getListaActores().eliminarActor(actor1);
		assertEquals(ListaActores.getListaActores().getTamano(),3);
		ListaActores.getListaActores().eliminarActor(actor2);
		assertEquals(ListaActores.getListaActores().getTamano(),2);
		ListaActores.getListaActores().eliminarActor(actor2);
		assertEquals(ListaActores.getListaActores().getTamano(),2);
		ListaActores.getListaActores().eliminarActor(actor3);
		assertEquals(ListaActores.getListaActores().getTamano(),1);
		ListaActores.getListaActores().eliminarActor(actor4);
		assertEquals(ListaActores.getListaActores().getTamano(),0);
	}

	@Test
	public void testBuscarActor() {
		ListaActores.getListaActores().anadirActor(actor1);
		ListaActores.getListaActores().anadirActor(actor2);
		ListaActores.getListaActores().anadirActor(actor3);
		assertEquals(ListaActores.getListaActores().buscarActor(actor1),actor1);
		assertEquals(ListaActores.getListaActores().buscarActor(actor2),actor2);
		assertEquals(ListaActores.getListaActores().buscarActor(actor3),actor3);
		assertNull(ListaActores.getListaActores().buscarActor(actor4));
		
	}

}
