package in.theqwerty.travel.flight.services;

import in.theqwerty.travel.flight.api.ClearTripAPI;
import in.theqwerty.travel.flight.beans.FlightMin;
import in.theqwerty.travel.flight.beans.SolutionMin;
import in.theqwerty.travel.flight.beans.WebServiceResponse;
import in.theqwerty.travel.flight.beans.xml.FlightSearch;
import in.theqwerty.travel.flight.beans.xml.jaxb.AirSearchResult;
import in.theqwerty.travel.flight.beans.xml.jaxb.OnwardSolutions;
import in.theqwerty.travel.flight.beans.xml.jaxb.ReturnSolutions;
import in.theqwerty.travel.flight.beans.xml.jaxb.Solution;
import in.theqwerty.travel.flight.beans.xml.jaxb.Solutions;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service("clearTripAPI")
public class ClearTripAPIImpl implements ClearTripAPI {

	@Resource
	private WebServiceAPI ws;
	
	private static Logger logger = LoggerFactory.getLogger(ClearTripAPIImpl.class);
	
	public FlightMin searchFlight(final FlightSearch search) {
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
			response = ws.doGet(Constants.SEARCH_URL, queryString);
			list.setStatusCode(response.getStatusCode());
			System.out.println(list.getStatusCode());
			if(response.getStatusCode() == SUCCESS_SEARCH_CODE) {
				
				AirSearchResult airSearch = (AirSearchResult) um.unmarshal(response.getStream());
				if(search.isDomestic()) {
					List<Solution> temp = (List<Solution>) ((OnwardSolutions)airSearch.getSolutionsOrOnwardSolutionsOrReturnSolutions().get(0)).getSolution();
					for(Solution s: temp) {
						SolutionMin min = FlightSummary.valueOf(s);
						onwardsList.add(min);
					}
					list.setOnwardSolutions(onwardsList);
					if(search.getReturnDate() != null && search.getReturnDate().length() > 0) {
						temp = (List<Solution>) ((ReturnSolutions)airSearch.getSolutionsOrOnwardSolutionsOrReturnSolutions().get(1)).getSolution();
						for(Solution s: temp) {
							SolutionMin min = FlightSummary.valueOf(s);
							returnList.add(min);
						}
						list.setReturnSolutions(returnList);
					}
				}
				else {
					List<Solution> temp = (List<Solution>) ((Solutions)airSearch.getSolutionsOrOnwardSolutionsOrReturnSolutions().get(0)).getSolution();
					for(Solution s: temp) {
						SolutionMin min = FlightSummary.valueOf(s);
						onwardsList.add(min);
					}
					list.setOnwardSolutions(onwardsList);
				}
			}
			return list;
		} catch (JAXBException e) {
			if(response.getStatusCode() != SUCCESS_SEARCH_CODE) {
				logger.error("Error while Unmarshling the search flights");
				e.printStackTrace();
			}
		} catch (Exception e) {
			logger.error("Error while Unmarshling the search flights");
			e.printStackTrace();
		} finally {
			if(response != null) {
				response.close();
			}
		}
		return new FlightMin();
		
	}
	
	private String createQueryString(final FlightSearch search) {
		if(search.getFrom() == null || search.getTo()== null || search.getDepartDate()== null) {
			return "";
		}
		StringBuilder builder = new StringBuilder();
		builder.append("from=").append(search.getFrom())
				.append("&to=").append(search.getTo())
				.append("&depart-date=").append(search.getDepartDate());
				
		
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
		return builder.append("&sort=asc").toString();
	}
		
}
