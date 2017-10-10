import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class AplacacionEjecutaAplicacion {

	public static void main(String[] args) {

		// Aplicacion java ejecuta otra aplicacion java
		
		Runtime r = Runtime.getRuntime();
		Process p = null;
		
			try {
				p = r.exec("java -jar EjecucionComando2.jar");
				
				InputStream is = p.getInputStream();
				InputStreamReader isr = new InputStreamReader(is);
				BufferedReader br = new BufferedReader(isr);
				
				String linea;
				
				while ((linea=br.readLine()) != null){
					System.out.println(linea);
				}
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}

}
