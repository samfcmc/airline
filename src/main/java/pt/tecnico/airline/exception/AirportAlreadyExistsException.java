package pt.tecnico.airline.exception;

public class AirportAlreadyExistsException extends AirlineException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String codeIATA;
	private String codeICAO;

	public AirportAlreadyExistsException(String codeIATA, String codeICAO) {
		this.codeIATA = codeIATA;
		this.codeICAO = codeICAO;
	}
	
	public String getCodeIATA() {
		return codeIATA;
	}
	
	public String getCodeICAO() {
		return codeICAO;
	}

}
