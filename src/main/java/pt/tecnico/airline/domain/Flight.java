package pt.tecnico.airline.domain;

import org.joda.time.DateTime;

public class Flight extends Flight_Base {
    
    public Flight(long number, DateTime time, Airport sourceAirport, Airport targetAirport) {
        setNumber(number);
        setTime(time);
        setSourceAirport(sourceAirport);
        setTargetAirport(targetAirport);
    }
    
    public void delete() {
    	setSourceAirport(null);
    	setTargetAirport(null);
    	setAirline(null);
    	deleteDomainObject();
    }
    
}
