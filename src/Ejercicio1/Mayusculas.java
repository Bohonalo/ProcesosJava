package Ejercicio1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Scanner;

public class Mayusculas {
	
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		String linea ;
		Process p = null;
		Runtime r = Runtime.getRuntime();
			try {
				do {
					linea = sc.nextLine()+"\n";
					p = r.exec("java -jar MayusculasHijo.jar");
					
					
					
					OutputStream os = p.getOutputStream();
					os.write(linea.getBytes());
					os.flush();
					
					
					InputStream is = p.getInputStream();
					InputStreamReader isr = new InputStreamReader(is);
					BufferedReader br = new BufferedReader(isr);
					String linea2;
					
					while ((linea2 = br.readLine()) != null){
						System.out.println(linea2);
					}
					br.close();
				}
				while(!linea.equals("\n"));
				p.destroy();
			
			
			} catch (IOException e) {
				e.printStackTrace();
			}
			sc.close();
	}
	
}
