package lab1;

public class PruebaSplit {
	
	public static void main(String args[]){
		String prueba = "Aalam, Roxanne		Silver Bullet (1985)  [Uncle Red's Girl]  <30>";
		String[] lineas = prueba.split("\t");
		System.out.println("Actriz: "+lineas[0]);
		String[] lineas2 = lineas[2].split("\\(");
		System.out.println("Pelicula: "+lineas2[0]);
		
	}

}
