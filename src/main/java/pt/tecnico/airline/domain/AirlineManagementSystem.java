package pt.tecnico.airline.domain;

import pt.ist.fenixframework.FenixFramework;
import pt.tecnico.airline.exception.AirlineAlreadyExistsExceptiob;

public class AirlineManagementSystem extends AirlineManagementSystem_Base {
	
	public static AirlineManagementSystem getInstance() {
		AirlineManagementSystem system = FenixFramework.getDomainRoot().getAirlineManagementSystem();
		if(system == null) {
			system = new AirlineManagementSystem();
		}
		return system;
	}
	
    private AirlineManagementSystem() {
        super();
        FenixFramework.getDomainRoot().setAirlineManagementSystem(this);
    }
    
    protected Airport getAirportByCodes(String codeIATA, String codeICAO) {
    	for(Airline airline : getAirlineSet()) {
    		Airport airport = airline.getAirportByCodes(codeIATA, codeICAO);
    		if(airport != null) {
    			return airport;
    		}
    	}
    	
    	return null;
    }
    
    protected boolean hasAirport(String codeIATA, String codeICAO) {
    	return getAirportByCodes(codeIATA, codeICAO) != null;
    }
    
    public Airline getAirline(String name, String codeIATA) {
    	for(Airline airline : getAirlineSet()) {
    		if(airline.getName().equals(name) || airline.getCodeIATA().equals(codeIATA)) {
    			return airline;
    		}
    	}
    	return null;
    }
    
    public boolean hasAirline(String name, String codeIATA) {
    	return getAirline(name, codeIATA) != null;
    }
    

	@Override
	public void addAirline(Airline airline) {
		String name = airline.getName();
		String codeIATA = airline.getCodeIATA();
		if(hasAirline(name, codeIATA)) {
			throw new AirlineAlreadyExistsExceptiob(name, codeIATA);
		}
		super.addAirline(airline);
	}
    
    
    
}
