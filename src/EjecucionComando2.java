import java.io.*;

public class EjecucionComando2 {
	
	public static void main(String[] args) {
		
		/* Modificamos el ejemplo anterior para poder visualizar la
		 * información generada por la oden dir.
		 */
		
		Runtime r = Runtime.getRuntime();
		Process p = null;
		
		
		try {
			p = r.exec("cmd /c dir C:\\");
			
			/* Con las siguientes tres sentencias, capturamos el flujo o stream
			 * que genera el proceso hijo cuando se ejecuta correctamente, y creamos
			 *  un buffer en memoria con dicha información.
			 * */
			
			InputStream iserror = p.getErrorStream();
			InputStreamReader isrerror = new InputStreamReader(iserror);
			BufferedReader brerror = new BufferedReader(isrerror);
			
			InputStream is = p.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			
			/*Con las siguientes sentencias capturamos el flujo o stream de datos que
			 * genera el proceso hijo como mensajes de error.*/
			
			String linea;
			
			while ((linea=br.readLine()) != null){
				System.out.println(linea);
			}
			
			while ((linea=brerror.readLine()) != null){
				System.out.println(linea);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int exitVal;
		
		/* El método waitFor hace que el padre espere a que el proceso hijo
		 * temine su ejecución y devuelve un valor entero que indica: 0 el 
		 * hijo se ha ejecutado correctamente, 1 no se ha ejecutado correctamente.*/
		try {
			exitVal = p.waitFor();
			System.out.println("Valor de salida: " + exitVal);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/* EL proceso cmd se ha ejecutado correctamente, pero nuestra aplicación
		 * no muestra el resultado (la ejecucion de la order dir) en pantalla.
		 * Esto es debido a que los subprocesos no pueden mostrar informacion en 
		 * pantalla ni recibir datos del teclado*/
		
	}

}

