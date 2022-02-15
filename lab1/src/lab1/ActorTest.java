package lab1;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ActorTest {
	Actor actor1;
	Actor actor2;
	Actor actor3;
	Actor actor4;
	Actor actor5;
	Pelicula p1;
	Pelicula p2;
	Pelicula p3;
	
	@Before
	public void setUp() throws Exception {
		actor1 = new Actor("Robert Downey Jr");
		actor2 = new Actor("David Duchovny");
		actor3 = new Actor("Neil Patrick Harris");
		actor4 = new Actor("Chuck Norris");
		p1 = new Pelicula("Avengers");
		p2 = new Pelicula("X-Files");
	}

	@After
	public void tearDown() throws Exception {
		actor1=null;
		actor2=null;
		actor3=null;
		actor4=null;
		actor5=null;
		p1=null;
		p2=null;
		p3=null;
	}

	@Test
	public void testTieneElMismoNombre() {
		assertFalse(actor1.tieneElMismoNombre(actor2));
		assertFalse(actor1.tieneElMismoNombre(actor3));
		assertFalse(actor1.tieneElMismoNombre(actor4));
		actor2.setNombre("Robert Downey Jr");
		assertTrue(actor1.tieneElMismoNombre(actor2));
		assertFalse(actor3.tieneElMismoNombre(actor5));
	}
	
	@Test
	public void testAnadirPelicula()  {
		assertFalse(actor1.getMiListaPeliculas().getMiListaPeliculas().contains(p1));
		assertFalse(actor1.getMiListaPeliculas().getMiListaPeliculas().contains(p2));
		assertFalse(actor1.getMiListaPeliculas().getMiListaPeliculas().contains(p3));
		actor1.anadirPelicula(p1);
		assertTrue(actor1.getMiListaPeliculas().getMiListaPeliculas().contains(p1));
		assertFalse(actor1.getMiListaPeliculas().getMiListaPeliculas().contains(p2));
		assertFalse(actor1.getMiListaPeliculas().getMiListaPeliculas().contains(p3));
		actor2.anadirPelicula(p2);
		assertFalse(actor2.getMiListaPeliculas().getMiListaPeliculas().contains(p1));
		assertTrue(actor2.getMiListaPeliculas().getMiListaPeliculas().contains(p2));
		assertFalse(actor2.getMiListaPeliculas().getMiListaPeliculas().contains(p3));
		actor3.anadirPelicula(p3);
		assertFalse(actor3.getMiListaPeliculas().getMiListaPeliculas().contains(p1));
		assertFalse(actor3.getMiListaPeliculas().getMiListaPeliculas().contains(p2));
		assertFalse(actor3.getMiListaPeliculas().getMiListaPeliculas().contains(p3));
	}
	
	@Test
	public void testEliminarPelicula()  {
		actor1.anadirPelicula(p1);
		actor1.anadirPelicula(p2);
		assertTrue(actor1.getMiListaPeliculas().getMiListaPeliculas().contains(p1));
		assertTrue(actor1.getMiListaPeliculas().getMiListaPeliculas().contains(p2));
		assertFalse(actor1.getMiListaPeliculas().getMiListaPeliculas().contains(p3));
		actor1.eliminarPelicula(p3);
		assertTrue(actor1.getMiListaPeliculas().getMiListaPeliculas().contains(p1));
		assertTrue(actor1.getMiListaPeliculas().getMiListaPeliculas().contains(p2));
		assertFalse(actor1.getMiListaPeliculas().getMiListaPeliculas().contains(p3));
		actor1.eliminarPelicula(p2);
		assertTrue(actor1.getMiListaPeliculas().getMiListaPeliculas().contains(p1));
		assertFalse(actor1.getMiListaPeliculas().getMiListaPeliculas().contains(p2));
		assertFalse(actor1.getMiListaPeliculas().getMiListaPeliculas().contains(p3));
		actor1.eliminarPelicula(p1);
		assertFalse(actor1.getMiListaPeliculas().getMiListaPeliculas().contains(p1));
		assertFalse(actor1.getMiListaPeliculas().getMiListaPeliculas().contains(p2));
		assertFalse(actor1.getMiListaPeliculas().getMiListaPeliculas().contains(p3));
	}

}
