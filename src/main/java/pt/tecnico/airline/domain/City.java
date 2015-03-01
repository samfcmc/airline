package pt.tecnico.airline.domain;

public class City extends City_Base {
    
    public City(String name) {
        setName(name);
    }
    
    public void delete() {
    	setAirport(null);
    	deleteDomainObject();
    }
    
}
