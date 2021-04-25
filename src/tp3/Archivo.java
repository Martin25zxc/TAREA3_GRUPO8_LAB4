package tp3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Archivo {
	private String ruta;
	
	public Archivo(String ruta) throws IOException
	{
		this.ruta = ruta;
	}
	
	public ArrayList<String> leerLineas() throws IOException, Exception {
		ArrayList<String> lineas = new ArrayList<String>();
		FileReader entrada;
		
		try {
			entrada = new FileReader(ruta);
			BufferedReader miBuffer = new BufferedReader(entrada);
			
		   String linea = "";
			while (linea != null) {
				linea = miBuffer.readLine();
				if(linea != null)
					lineas.add(linea);
			}
			
			miBuffer.close();
			entrada.close();
			
			return lineas;
		} catch (IOException e) {
			throw new IOException("No se encontro el archivo " + this.ruta);
		}
		catch (Exception e) {
			throw new Exception("Exception en metodo leerLineas(). Ruta: " + this.ruta + ". Mensaje" + e.getMessage());
		}
	}
	
	public void escribirLineas(String frase) throws IOException, Exception {
		try {
			FileWriter entrada = new FileWriter(ruta, false);
			BufferedWriter miBuffer = new BufferedWriter(entrada);
			miBuffer.write(frase);
			miBuffer.close();
			entrada.close();
			
		} catch (IOException e) {
			throw new IOException("No se encontro el archivo " + this.ruta);
		}
		catch (Exception e) {
			throw new Exception("Exception en metodo escribirLineas(). Ruta: " + this.ruta + ". Mensaje" + e.getMessage());
		}
	}
}
