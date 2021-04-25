package tp3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Archivo {
	private String ruta;
	
	public Archivo(String ruta) throws IOException
	{
		this.ruta = ruta;
		if(!existe())
			throw new IOException("No se encontro el archivo "+ this.ruta);
	}
	
	private boolean existe()
	{
		File archivo = new File(ruta); 
		return archivo.exists();
	}
	
	public ArrayList<String> leer_lineas() throws IOException, Exception {
		ArrayList<String> lineas = new ArrayList<String>();
		FileReader entrada;
		try {
			entrada = new FileReader(ruta);
			BufferedReader miBuffer = new BufferedReader(entrada);
			
		   String linea = "";
		   //int i = 0;
			while (linea != null) {
				linea = miBuffer.readLine();
				if(linea != null)
				{
					//System.out.println(i++ + ")    " + linea);
					lineas.add(linea);
				}
			}
			miBuffer.close();
			entrada.close();
			
			return lineas;
		} catch (IOException e) {
			throw new IOException("No se encontro el archivo " + this.ruta);
		}
		catch (Exception e) {
			throw new Exception("Exception en metodo lee_lineas(). Ruta: " + this.ruta + ". Mensaje"+e.getMessage());
		}
	}
}
