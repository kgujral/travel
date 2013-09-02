package in.theqwerty.travel.flight.services;

import in.theqwerty.travel.flight.AbstractFlightTest;
import in.theqwerty.travel.flight.api.ClearTripAPI;
import in.theqwerty.travel.flight.beans.FlightMin;
import in.theqwerty.travel.flight.beans.xml.FlightSearch;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.annotation.Resource;

import junit.framework.Assert;

import org.junit.Test;

public class ClearTripAPIImplTest extends AbstractFlightTest {
	
	@Resource
	private ClearTripAPI clearTripAPI; 

	@Test
	public void testSearchFlight() throws Exception {
		
		Assert.assertEquals(0, clearTripAPI.searchFlight(null).getOnwardSolutions().size());
		Assert.assertEquals(0, clearTripAPI.searchFlight(null).getReturnSolutions().size());
		FlightSearch search = new FlightSearch();
		Assert.assertEquals(0, clearTripAPI.searchFlight(search).getOnwardSolutions().size());
		Assert.assertEquals(0, clearTripAPI.searchFlight(search).getReturnSolutions().size());
		search.setFrom("DEL");
		Assert.assertEquals(0, clearTripAPI.searchFlight(search).getOnwardSolutions().size());
		Assert.assertEquals(0, clearTripAPI.searchFlight(search).getReturnSolutions().size());
		search.setTo("BOM");
		Assert.assertEquals(0, clearTripAPI.searchFlight(search).getOnwardSolutions().size());
		Assert.assertEquals(0, clearTripAPI.searchFlight(search).getReturnSolutions().size());
		/*
		 * Uncomment the following if u want to test by actually calling the web service.
		 * Will take around 50 seconds to run the tests.
		 * 
		 */
		/*
		FlightMin min = new FlightMin();
		search.setDepartDate("RANDOM");
		min = clearTripAPI.searchFlight(search);
		System.out.println(min.getStatusCode());
		Assert.assertEquals(0, min.getOnwardSolutions().size());
		Assert.assertEquals(0, min.getReturnSolutions().size());
		

		String DATE_FORMAT = "yyyy-MM-dd";
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
		Calendar c1 = Calendar.getInstance(); // today
		c1.add(Calendar.DATE, 100);
		search.setDepartDate(sdf.format(c1.getTime()));
		min = clearTripAPI.searchFlight(search);
		System.out.println(min.getStatusCode());
		Assert.assertNotSame(0, min.getOnwardSolutions().size());
		Assert.assertEquals(0, min.getReturnSolutions().size());
		c1.add(Calendar.DATE, 100);
		search.setReturnDate(sdf.format(c1.getTime()));
		search.setChildren("1");
		search.setInfants("0");
		search.setCabinType("Business");
		search.setCarrier("9W");
		min = clearTripAPI.searchFlight(search);
		System.out.println(min.getStatusCode());
		Assert.assertNotSame(0, min.getOnwardSolutions().size());
		Assert.assertNotSame(0, min.getReturnSolutions().size());
		*/
	}
}
