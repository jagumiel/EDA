package pruebas;

//import static org.junit.Assert.*;

import java.io.File;

import javax.swing.JFileChooser;

import lab1.Main;
import lab1.StopWatch;

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
			StopWatch timer = new StopWatch();
			Main.getMain().cargarFichero(fc.getSelectedFile());
			System.out.println(timer.elapsedTime());
			Main.getMain().guardarFichero();
		} else {
			System.out.println("No seleccion");
		}
	}

}

