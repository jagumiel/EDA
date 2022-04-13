package lab3;

import java.io.File;

public class Pra {

	public static void main(String[] args){
		File archivo = new File("C:\\Documents and Settings\\HP_Propietario\\Escritorio\\aaaa.txt");
		Main.getMain().cargarFichero(archivo);
		String[] aaa = Main.getMain().rellenarArray();
		for(String s:aaa){
			System.out.println(s);
		}
	}
}
