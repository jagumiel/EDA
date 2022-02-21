package pruebas;

import static org.junit.Assert.*;
import lab1.ListaPeliculas;
import lab1.Pelicula;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ListaPeliculasTest {
	Pelicula p1;
	Pelicula p2;
	Pelicula p3;
	Pelicula p4;
	ListaPeliculas lp;

	@Before
	public void setUp() throws Exception {
		p1 = new Pelicula("Iron Man");
		p2 = new Pelicula("How High");
		p3 = new Pelicula("Thor");
		lp = new ListaPeliculas();
	}

	@After
	public void tearDown() throws Exception {
		p1=null;
		p2=null;
		p3=null;
		p4=null;
		lp=null;
	}

	@Test
	public void testAnadirPelicula() {
		assertFalse(lp.estaPelicula(p1));
		assertFalse(lp.estaPelicula(p2));
		assertFalse(lp.estaPelicula(p3));
		assertFalse(lp.estaPelicula(p4));
		lp.anadirPelicula(p1.getTitulo());
		assertTrue(lp.estaPelicula(p1));
		assertFalse(lp.estaPelicula(p2));
		assertFalse(lp.estaPelicula(p3));
		assertFalse(lp.estaPelicula(p4));
		lp.anadirPelicula(p2.getTitulo());
		assertTrue(lp.estaPelicula(p1));
		assertTrue(lp.estaPelicula(p2));
		assertFalse(lp.estaPelicula(p3));
		assertFalse(lp.estaPelicula(p4));
		lp.anadirPelicula(p3.getTitulo());
		assertTrue(lp.estaPelicula(p1));
		assertTrue(lp.estaPelicula(p2));
		assertTrue(lp.estaPelicula(p3));
		assertFalse(lp.estaPelicula(p4));
		lp.anadirPelicula(p4.getTitulo());
		assertTrue(lp.estaPelicula(p1));
		assertTrue(lp.estaPelicula(p2));
		assertTrue(lp.estaPelicula(p3));
		assertFalse(lp.estaPelicula(p4));
	}
	
	@Test
	public void testEliminarPelicula()  {
		lp.anadirPelicula(p1.getTitulo());
		lp.anadirPelicula(p2.getTitulo());
		lp.anadirPelicula(p3.getTitulo());
		assertTrue(lp.estaPelicula(p1));
		assertTrue(lp.estaPelicula(p2));
		assertTrue(lp.estaPelicula(p3));
		lp.eliminarPelicula(p1);
		assertFalse(lp.estaPelicula(p1));
		assertTrue(lp.estaPelicula(p2));
		assertTrue(lp.estaPelicula(p3));
		lp.eliminarPelicula(p2);
		assertFalse(lp.estaPelicula(p1));
		assertFalse(lp.estaPelicula(p2));
		assertTrue(lp.estaPelicula(p3));
		lp.eliminarPelicula(p3);
		assertFalse(lp.estaPelicula(p1));
		assertFalse(lp.estaPelicula(p2));
		assertFalse(lp.estaPelicula(p3));
	}

}
