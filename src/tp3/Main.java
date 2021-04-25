package tp3;

import java.util.ArrayList;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) {
		
		try 
		{
			Archivo fmPersonas = new Archivo("Personas.txt");
			// Punto B
			// Leo el archivo de personas y guardo las lineas del archivo en la variable lineasArchivo.
			ArrayList<String> lineasArchivo = fmPersonas.leerLineas();
			// Declaracion del treeset de personas para tener una lista ordernado y sin duplicados.
			TreeSet<Persona> personasTS = new TreeSet<Persona>();
			for (String linea : lineasArchivo)
			{
				try
				{
					// Spliteo cada linea del archivo. Segun la especificacion cada campo esta separado por "-".  
					String[] lineaSpliteada = linea.split("-");
					
					// Valido que el "dni"se valido.
					Validator.verificarDniInvalido(lineaSpliteada[2]);
					
					// Se agrega una nueva instancia de persona con el contenido de la linea al TreeSet.
					personasTS.add(new Persona(lineaSpliteada[2], lineaSpliteada[0], lineaSpliteada[1]));
				}
				catch(DniInvalido ex)
				{
					System.out.println(ex.getMessage());
				}
				catch(Exception ex)
				{
					System.out.println(ex.getMessage());
				}
			}
			//Punto C
			System.out.println("Armado y grabado del archivo Resultado.txt");
			
			// Preparo el texto a grabar
			String stringAgrabar = "";
			for (Persona p : personasTS)
				stringAgrabar += p.getNombre() + "-" + p.getApellido() + "-" + p.getDni() + System.lineSeparator();
			
			// Grabo el texto armado en el archivo Resultado.txt
			Archivo fmPersonasNuevo = new Archivo("Resultado.txt");
			fmPersonasNuevo.escribirLineas(stringAgrabar);
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
	}
}
