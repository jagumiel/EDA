package test;

import packSorteo.*;


import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ListaNumerosTest {
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
	public void testAddYEstaNumero() {
		assertFalse(l.estaNumero(2));
		l.addNumero(2);
		assertTrue(l.estaNumero(2));
		assertFalse(l.estaNumero(5));
		l.addNumero(5);
		assertTrue(l.estaNumero(5));
	}
	
	public void testEstaCompletaYAddNumero(){
		assertFalse(l.estaCompleta());
		l.addNumero(1);
		assertFalse(l.estaCompleta());
		l.addNumero(2);
		assertFalse(l.estaCompleta());
		l.addNumero(3);
		assertFalse(l.estaCompleta());
		l.addNumero(4);
		assertFalse(l.estaCompleta());
		l.addNumero(5);
		assertFalse(l.estaCompleta());
		l.addNumero(6);
		assertFalse(l.estaCompleta());
		l.addNumero(7);
		assertTrue(l.estaCompleta());
	}

}
