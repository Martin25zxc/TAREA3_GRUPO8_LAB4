package tp3;

import java.util.ArrayList;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) {
		
		try 
		{
			Archivo fmPersonas = new Archivo("Personas.txt");
			// Punto B
			// Leo el archivo de personas y guardo las lineas del archivo en la variable lineasArchivo
			ArrayList<String> lineasArchivo = fmPersonas.leer_lineas();
			// Declaracion del treeset de personas para tener un listado ordernado y sin duplicados
			TreeSet<Persona> personasTS = new TreeSet<Persona>();
			for (String linea : lineasArchivo)
			{
				try
				{
					// Spliteo cada linea del archivo. Segun la especificacion cada campo esta separado por "-"  
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
			// Listado del TreeSet de Personas
			System.out.println("personasTS");
			for (Persona p : personasTS)
			{
				System.out.println(p.toString());
			}
			System.out.println(personasTS.size());
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
	}
}
