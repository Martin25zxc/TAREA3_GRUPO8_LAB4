package tp3;

public class Main {

	public static void main(String[] args) {
		try 
		{
			Validator.verificarDniInvalido("AAAa");
		}
		catch(DniInvalido ex)
		{
			System.out.println("Catch de exception del tipo DniInvalido");
			System.out.println(ex.getMessage());
		}
		catch(Exception ex)
		{
			System.out.println("Catch de exception default");
			System.out.println(ex.getMessage());
		}
		
		try 
		{
			Validator.verificarDniInvalido("123123A");
		}
		catch(DniInvalido ex)
		{
			System.out.println("Catch de exception del tipo DniInvalido");
			System.out.println(ex.getMessage());
		}
		catch(Exception ex)
		{
			System.out.println("Catch de exception default");
			System.out.println(ex.getMessage());
		}
		
	}

}
