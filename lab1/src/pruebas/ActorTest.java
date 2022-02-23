package probandohashmaps;

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
		assertFalse(actor1.getMiListaPeliculas().estaPelicula(p1));
		assertFalse(actor1.getMiListaPeliculas().estaPelicula(p2));
		assertFalse(actor1.getMiListaPeliculas().estaPelicula(p3));
		actor1.anadirPelicula(p1.getTitulo());
		assertTrue(actor1.getMiListaPeliculas().estaPelicula(p1));
		assertFalse(actor1.getMiListaPeliculas().estaPelicula(p2));
		assertFalse(actor1.getMiListaPeliculas().estaPelicula(p3));
		actor1.anadirPelicula(p2.getTitulo());
		assertTrue(actor1.getMiListaPeliculas().estaPelicula(p1));
		assertTrue(actor1.getMiListaPeliculas().estaPelicula(p2));
		assertFalse(actor1.getMiListaPeliculas().estaPelicula(p3));
	}
	
	@Test
	public void testEliminarPelicula()  {
		actor1.anadirPelicula(p1.getTitulo());
		actor1.anadirPelicula(p2.getTitulo());
		assertTrue(actor1.getMiListaPeliculas().estaPelicula(p1));
		assertTrue(actor1.getMiListaPeliculas().estaPelicula(p2));
		assertFalse(actor1.getMiListaPeliculas().estaPelicula(p3));
		actor1.eliminarPelicula(p3);
		assertTrue(actor1.getMiListaPeliculas().estaPelicula(p1));
		assertTrue(actor1.getMiListaPeliculas().estaPelicula(p2));
		assertFalse(actor1.getMiListaPeliculas().estaPelicula(p3));
		actor1.eliminarPelicula(p2);
		assertTrue(actor1.getMiListaPeliculas().estaPelicula(p1));
		assertFalse(actor1.getMiListaPeliculas().estaPelicula(p2));
		assertFalse(actor1.getMiListaPeliculas().estaPelicula(p3));
		actor1.eliminarPelicula(p1);
		assertFalse(actor1.getMiListaPeliculas().estaPelicula(p1));
		assertFalse(actor1.getMiListaPeliculas().estaPelicula(p2));
		assertFalse(actor1.getMiListaPeliculas().estaPelicula(p3));
	}

}
