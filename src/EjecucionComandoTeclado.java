import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class EjecucionComandoTeclado {

	public static void main(String[] args) {

		/* Vamos a crear un subproceso que ejecute la orden date. Este comando
		 * solicita al usuario un dato desde teclado y muestra infomación en pantalla.*/
		
		Runtime r = Runtime.getRuntime();
		Process p = null;
		
		try {
			p = r.exec("cmd /c date");
			
			InputStream iserror = p.getErrorStream();
			InputStreamReader isrerror = new InputStreamReader(iserror);
			BufferedReader brerror = new BufferedReader(isrerror);
			
			InputStream is = p.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			
			/* Vamos a enviar datos al proceso hijo desde el proceso padre,
			 * para ello capturamos el flujo de datos de entrada del proceso hijo.*/
			
			OutputStream os = p.getOutputStream();
			os.write("04/10/2017\n".getBytes());
			os.flush();
			
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
			
		try {
			exitVal = p.waitFor();
			System.out.println("Valor de salida: " + exitVal);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
