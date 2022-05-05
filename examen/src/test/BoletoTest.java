package test;

import packSorteo.*;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BoletoTest {
	private Boleto b;

	@Before
	public void setUp() throws Exception {
		b = new Boleto("Agirretxe", "Zubieta 2", 985632012);
	}

	@After
	public void tearDown() throws Exception {
		b = null;
	}

	@Test
	public void testRellenar() {
		ListaNumeros l = new ListaNumeros();
		l.addNumero(1);
		l.addNumero(2);
		l.addNumero(3);
		l.addNumero(4);
		l.addNumero(5);
		l.addNumero(6);
		b.rellenar(l);
		Iterator<Integer> itl = l.getIterador();
		Iterator<Integer> itb = b.getMisNumeros().getIterador();
		while(itl.hasNext()){
			assertEquals(itl.next(), itb.next());
		}
		
	}

	@Test
	public void testObtNumeroAciertos() {
		ListaNumeros l = new ListaNumeros();
		l.addNumero(1);
		l.addNumero(2);
		l.addNumero(3);
		l.addNumero(4);
		l.addNumero(5);
		l.addNumero(6);
		b.rellenar(l);
		assertEquals(b.obtNumeroAciertos(l), 6);
		
		l = new ListaNumeros();
		l.addNumero(1);
		l.addNumero(2);
		l.addNumero(3);
		l.addNumero(4);
		l.addNumero(5);
		l.addNumero(7);
		assertEquals(b.obtNumeroAciertos(l), 5);
	
		l = new ListaNumeros();
		l.addNumero(1);
		l.addNumero(2);
		l.addNumero(3);
		l.addNumero(4);
		l.addNumero(15);
		l.addNumero(7);
		assertEquals(b.obtNumeroAciertos(l), 4);
	
		l = new ListaNumeros();
		l.addNumero(1);
		l.addNumero(2);
		l.addNumero(3);
		l.addNumero(40);
		l.addNumero(15);
		l.addNumero(7);
		assertEquals(b.obtNumeroAciertos(l), 3);
	
		l = new ListaNumeros();
		l.addNumero(1);
		l.addNumero(2);
		l.addNumero(32);
		l.addNumero(40);
		l.addNumero(15);
		l.addNumero(7);
		assertEquals(b.obtNumeroAciertos(l), 2);
	
		l = new ListaNumeros();
		l.addNumero(1);
		l.addNumero(22);
		l.addNumero(32);
		l.addNumero(40);
		l.addNumero(15);
		l.addNumero(7);
		assertEquals(b.obtNumeroAciertos(l), 1);
	
		l = new ListaNumeros();
		l.addNumero(11);
		l.addNumero(21);
		l.addNumero(32);
		l.addNumero(40);
		l.addNumero(15);
		l.addNumero(7);
		assertEquals(b.obtNumeroAciertos(l), 0);
	
	
	}

}
