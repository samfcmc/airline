package pt.tecnico.airline.exception;

public class AirlineAlreadyExistsExceptiob extends AirlineException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String codeIATA;

	public AirlineAlreadyExistsExceptiob(String name, String codeIATA) {
		this.name = name;
		this.codeIATA = codeIATA;
	}
	
	public String getName() {
		return name;
	}
	
	public String getCodeIATA() {
		return codeIATA;
	}

}
