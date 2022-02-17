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
		Main.getMain().cargarFichero("C:actresses-small.txt"); //TODO Corregir, da error C:actresses-small.txt (El sistema no puede encontrar el archivo especificado)
		ListaActores.getListaActores().imprimir();
	}

}
