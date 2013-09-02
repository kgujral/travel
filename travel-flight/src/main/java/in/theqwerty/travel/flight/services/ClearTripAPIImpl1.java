package in.theqwerty.travel.flight.services;

import in.theqwerty.travel.flight.api.ClearTripAPI;
import in.theqwerty.travel.flight.beans.FlightMin;
import in.theqwerty.travel.flight.beans.SolutionMin;
import in.theqwerty.travel.flight.beans.WebServiceResponse;
import in.theqwerty.travel.flight.beans.xml.FlightSearch;
import in.theqwerty.travel.flight.beans.xml.jaxb.AirSearchResult;
import in.theqwerty.travel.flight.beans.xml.jaxb.OnwardSolutions;
import in.theqwerty.travel.flight.beans.xml.jaxb.ReturnSolutions;
import in.theqwerty.travel.flight.beans.xml.jaxb.Segment;
import in.theqwerty.travel.flight.beans.xml.jaxb.Solution;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClearTripAPIImpl1 implements ClearTripAPI {

	
	private static Logger logger = LoggerFactory.getLogger(ClearTripAPIImpl.class);
	
	public FlightMin searchFlight(FlightSearch search) {
		WebServiceResponse response = null ;
		try{
			FlightMin list = new FlightMin();
			List<SolutionMin> onwardsList = new ArrayList<SolutionMin>();
			List<SolutionMin> returnList = new ArrayList<SolutionMin>();
			list.setOnwardSolutions(onwardsList);
			list.setReturnSolutions(returnList);
			if(search == null) {
				return list;
			}
			final String queryString = createQueryString(search);
			if(queryString.isEmpty()) {
				return list;
			}
			JAXBContext jb = JAXBContext.newInstance("in.theqwerty.travel.flight.beans.xml.jaxb");
			Unmarshaller um = jb.createUnmarshaller();
			//response = ws.doGet(Constants.SEARCH_URL, queryString);
			list.setStatusCode(200);
			System.out.println(list.getStatusCode());
			if(Boolean.valueOf(true)) {
				AirSearchResult airSearch = (AirSearchResult) um.unmarshal(new  FileInputStream(new File("C:\\search-data.xml")));
				List<Solution> temp = (List<Solution>) ((OnwardSolutions)airSearch.getSolutionsOrOnwardSolutionsOrReturnSolutions().get(0)).getSolution();
				for(Solution s: temp) {
					SolutionMin min = new SolutionMin();
					min.setTotalFare(s.getPricingSummary().getTotalFare());
					Segment seg = s.getFlights().getFlight().get(0).getSegments().getSegment().get(0);
					min.setArrivalTime(seg.getArrivalDateTime().toString());
					min.setDepartTime(seg.getDepartureDateTime().toString());
					min.setFlightName(seg.getFlightNumber());
					onwardsList.add(min);
				}
				list.setOnwardSolutions(onwardsList);
				if(search.getReturnDate() != null && search.getReturnDate().length() > 0) {
					temp = (List<Solution>) ((ReturnSolutions)airSearch.getSolutionsOrOnwardSolutionsOrReturnSolutions().get(1)).getSolution();
					for(Solution s: temp) {
						SolutionMin min = new SolutionMin();
						min.setTotalFare(s.getPricingSummary().getTotalFare());
						Segment seg = s.getFlights().getFlight().get(0).getSegments().getSegment().get(0);
						min.setArrivalTime(seg.getArrivalDateTime().toString());
						min.setDepartTime(seg.getDepartureDateTime().toString());
						min.setFlightName(seg.getFlightNumber());
						returnList.add(min);
					}
					list.setReturnSolutions(returnList);
				}
			}
			return list;
		} catch (Exception e) {
			logger.error("Error while Unmarshling the search flights");
			e.printStackTrace();
			return null;
		} finally {
			if(response != null) {
				response.close();
			}
		}
		
	}
	
	private String createQueryString(final FlightSearch search) {
		if(search.getFrom() == null || search.getTo()== null || search.getDepartDate()== null) {
			return "";
		}
		StringBuilder builder = new StringBuilder();
		builder.append("from=").append(search.getFrom())
				.append("&to=").append(search.getTo())
				.append("&depart-date=").append(search.getDepartDate())
				.append("&sort=asc");
		
		if(search.getReturnDate() != null && search.getReturnDate().length() > 0) {
			builder.append("&return-date=").append(search.getReturnDate());
		}
		if(search.getAdults() != null && search.getAdults().length() > 0) {
			builder.append("&adults=").append(search.getAdults());
		}
		else {
			builder.append("&adults=1");
		}
		if(search.getChildren() != null && search.getChildren().length() > 0) {
			builder.append("&children=").append(search.getChildren());
		}
		if(search.getInfants() != null && search.getInfants().length() > 0) {
			builder.append("&infants=").append(search.getInfants());
		}
		if(search.getCarrier() != null && search.getCarrier().length() > 0) {
			builder.append("&carrier=").append(search.getCarrier());
		}
		if(search.getCabinType() != null && search.getCabinType().length() > 0) {
			builder.append("&cabin-type=").append(search.getCabinType());
		}
		return builder.toString();
	}
		
}
