package tp3;

import java.io.IOException;

public class DniInvalido extends IOException {
	private static final long serialVersionUID = -2892419532443123476L;
	
	public DniInvalido()
	{
		super();
	}
	
	public DniInvalido(String message)
	{
		super(message);
	}
}
