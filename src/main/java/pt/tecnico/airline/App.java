package pt.tecnico.airline;

import org.joda.time.DateTime;

import pt.ist.fenixframework.Atomic;
import pt.tecnico.airline.domain.Airline;
import pt.tecnico.airline.domain.AirlineManagementSystem;
import pt.tecnico.airline.domain.Airport;
import pt.tecnico.airline.domain.City;
import pt.tecnico.airline.domain.Flight;
import pt.tecnico.airline.exception.AirlineException;

public class App {

	public static void main(String[] args) {
		try {
			populate();
			print();
		}
		catch(AirlineException e) {
			
		}
		
		clear();

	}
	
	@Atomic
	private static void populate() throws AirlineException {
		AirlineManagementSystem system = AirlineManagementSystem.getInstance();
		City lisbon = new City("Lisboa");
		City porto = new City("Porto");
		City amsterdam = new City("Amsterdão");
		Airline tap = new Airline("TAP Portugal", "TAP");
		DateTime dateTime = new DateTime();
		Airport lisbonAP = new Airport("LIS", "LIS", lisbon);
		Airport portoAP = new Airport("POR", "POR", porto);
		Airport amsterdamAP = new Airport("AMS", "AMS", amsterdam);
		
		DateTime time1 = dateTime.withHourOfDay(6).withMinuteOfHour(50);
		Flight flight1 = new Flight(1951, time1, portoAP, lisbonAP);
		
		DateTime time2 = dateTime.withHourOfDay(21).withMinuteOfHour(55);
		Flight flight2 = new Flight(1988, time2, lisbonAP, portoAP);
		
		system.addAirline(tap);
		
		tap.addAirport(amsterdamAP);
		tap.addAirport(portoAP);
		tap.addAirport(lisbonAP);
		
		tap.addFlight(flight1);
		tap.addFlight(flight2);
		
		
		
	}


	@Atomic
	private static void print() {
		AirlineManagementSystem system = AirlineManagementSystem.getInstance();
		System.out.println("FLIGHTS");
		for(Airline airline : system.getAirlineSet()) {
			for(Flight flight : airline.getFlightSet()) {
				printFlight(flight);
			}
		}
	}
	
	private static void printFlight(Flight flight) {
		String airlineCode = flight.getAirline().getCodeIATA();
		long number = flight.getNumber();
		String source = flight.getSourceAirport().getCity().getName();
		String sourceCode = flight.getSourceAirport().getCodeIATA();
		String target = flight.getTargetAirport().getCity().getName();
		String targetCode = flight.getTargetAirport().getCodeIATA();
		DateTime time = flight.getTime();
		int hour = time.getHourOfDay();
		int minute = time.getMinuteOfHour();
		String timeString = hour + ":" + minute;
		
		System.out.println(airlineCode + " " + number + " : " + source + " (" + sourceCode + "), " + 
				target + " (" + targetCode + "), " + timeString);
	}

	@Atomic
	private static void clear() {
		AirlineManagementSystem system = AirlineManagementSystem.getInstance();
		for(Airline airline : system.getAirlineSet()) {
			for(Airport airport : airline.getAirportSet()) {
				if(airport.getCity() != null) {
					airport.getCity().delete();
				}
				airport.delete();
			}
			airline.delete();
		}
	}

}
