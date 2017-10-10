import java.io.IOException;

public class EjecucionAplicacion {

	public static void main(String[] args) {
		
		/* Vamos a iniciar un subproceso para ejecutar
		 la aplicación notepad. Mediante la clase
		 Runtime podemos crear subprocesos.*/
		Runtime r = Runtime.getRuntime();
		Process p = null;
		Process p2 = null;
		
		try {
			p = r.exec("notepad");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*  Usamos la clase ProcessBuilder para cerar un segundo
		 *  subproceso.
		 * */
		ProcessBuilder pb = new ProcessBuilder("C:\\Windows\\system32\\mspaint.exe");
		try {
			p2 = pb.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
