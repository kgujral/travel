package in.theqwerty.travel.flight.services;

import in.theqwerty.travel.flight.beans.SolutionMin;
import in.theqwerty.travel.flight.beans.xml.jaxb.Segment;
import in.theqwerty.travel.flight.beans.xml.jaxb.Solution;

public final class FlightSummary {
	
	public static SolutionMin valueOf(final Solution s) {
		SolutionMin min = new SolutionMin();
		min.setTotalFare(s.getPricingSummary().getTotalFare());
		final Segment seg = s.getFlights().getFlight().get(0).getSegments().getSegment().get(0);
		min.setArrivalTime(seg.getArrivalDateTime().toString());
		min.setDepartTime(seg.getDepartureDateTime().toString());
		min.setFlightName(seg.getFlightNumber());
		return min;
	}
}
