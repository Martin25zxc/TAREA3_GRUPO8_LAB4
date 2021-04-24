package tp3;

public class Validator{
	public static void verificarDniInvalido (String dni) throws DniInvalido 
	{
		if(!dni.matches("[0-9]+"))
			throw new DniInvalido("El dni " + dni + " no es valido.");
	}
}
