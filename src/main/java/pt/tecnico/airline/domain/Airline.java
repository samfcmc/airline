package pt.tecnico.airline.domain;

import pt.tecnico.airline.exception.AirportAlreadyExistsException;
import pt.tecnico.airline.exception.FlightNumberAlreadyExistsException;

public class Airline extends Airline_Base {
    
    public Airline(String name, String codeIATA) {
        setName(name);
        setCodeIATA(codeIATA);
    }
    
    public Flight getFlightByNumber(long number) {
    	for(Flight flight : getFlightSet()) {
    		if(flight.getNumber() == number) {
    			return flight;
    		}
    	}
    	return null;
    }
    
    public boolean hasFlight(long number) {
    	return getFlightByNumber(number) != null;
    }

	@Override
	public void addFlight(Flight flight) {
		if(hasFlight(flight.getNumber())) {
			throw new FlightNumberAlreadyExistsException(flight.getNumber());
		}
		super.addFlight(flight);
	}

	public Airport getAirportByCodes(String codeIATA, String codeICAO) {
		for(Airport airport : getAirportSet()) {
			if(airport.getCodeIATA().equals(codeIATA) || airport.getCodeICAO().equals(codeICAO)) {
				return airport;
			}
		}
		return null;
	}
	
	public boolean hasAirport(String codeIATA, String codeICAO) {
		return getAirportByCodes(codeIATA, codeICAO) != null;
	}
	
	@Override
	public void addAirport(Airport airport) {
		String codeIATA = airport.getCodeIATA();
		String codeICAO = airport.getCodeICAO();
		if(getAirlineManagementSystem().hasAirport(codeIATA, codeICAO)) {
			throw new AirportAlreadyExistsException(codeIATA, codeICAO);
		}
		super.addAirport(airport);
	}

	public void delete() {
		deleteFlights();
		deleteAirports();
		setAirlineManagementSystem(null);
		deleteDomainObject();
		
	}

	private void deleteAirports() {
		for(Airport airport : getAirportSet()) {
			airport.delete();
		}
		
	}
	
	private void deleteFlights() {
		for(Flight flight : getFlightSet()) {
			flight.delete();
		}
	}
	
	
    
    
    
}
