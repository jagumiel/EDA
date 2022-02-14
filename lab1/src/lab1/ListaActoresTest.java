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
	}

	@Test
	public void testAnadirActor() {
		//TODO
	}

	@Test
	public void testEliminarActor() {
		//TODO
	}

	@Test
	public void testBuscarActor() {
		//TODO
	}

}
