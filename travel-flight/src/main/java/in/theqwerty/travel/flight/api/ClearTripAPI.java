package in.theqwerty.travel.flight.api;

import in.theqwerty.travel.flight.beans.FlightMin;
import in.theqwerty.travel.flight.beans.xml.FlightSearch;

public interface ClearTripAPI {
	
	int SUCCESS_SEARCH_CODE = 200;
	FlightMin searchFlight(final FlightSearch search) throws Exception;
	
}
