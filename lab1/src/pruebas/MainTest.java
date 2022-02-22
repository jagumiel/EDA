package pruebas;

//import static org.junit.Assert.*;

import java.io.File;

import javax.swing.JFileChooser;

import lab1.ListaActores;
import lab1.Main;

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
		JFileChooser fc = new JFileChooser();
		fc.setCurrentDirectory(new File("."));
		fc.setDialogTitle("Elige un fichero");
		fc.setAcceptAllFileFilterUsed(false);
		if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			System.out.println("Directorio: " + fc.getSelectedFile());
			Main.getMain().cargarFichero(fc.getSelectedFile()); //TODO conseguir que el metodo cargarFichero() acepte el archivo
			Main.getMain().guardarFichero();
		} else {
			System.out.println("No seleccion ");
		}
	}

}

