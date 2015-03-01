package pt.tecnico.airline.domain;

public class Airport extends Airport_Base {
    
    public Airport(String codeIATA, String codeICAO, City city) {
        setCity(city);
        setCodeIATA(codeIATA);
        setCodeICAO(codeICAO);
    }

	public void delete() {
		setUsedAsSource(null);
		setUsedAsTarget(null);
		setCity(null);
		setAirline(null);
		deleteDomainObject();
	}
    
}
