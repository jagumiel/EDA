package lab1;

//import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MainTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCargarFichero() {
		Main.getMain().cargarFichero("actresses-small.txt");
		ListaActores.getListaActores().imprimir();
	}

}
