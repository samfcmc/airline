package pt.tecnico.airline.exception;

public class FlightNumberAlreadyExistsException extends AirlineException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private long number;

	public FlightNumberAlreadyExistsException(long number) {
		super();
		this.number = number;
	}

	public long getNumber() {
		return number;
	}
}
