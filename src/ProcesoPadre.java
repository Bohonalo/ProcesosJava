import java.io.*;

public class ProcesoPadre {
	
	public static void main(String[] args) {
		
		Process p = null;
		Runtime r = Runtime.getRuntime();

			try {
				p = r.exec("java -jar ProcesoHijo.jar");
	
				OutputStream os = p.getOutputStream();
				os.write("Hola que tal\n".getBytes());
				os.flush();
				
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
