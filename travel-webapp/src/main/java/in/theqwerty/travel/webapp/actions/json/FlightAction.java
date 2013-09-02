package in.theqwerty.travel.webapp.actions.json;

import in.theqwerty.travel.flight.api.ClearTripAPI;
import in.theqwerty.travel.flight.beans.FlightMin;
import in.theqwerty.travel.flight.beans.xml.FlightSearch;
import in.theqwerty.travel.webapp.actions.ActionSupport;

import javax.annotation.Resource;

import com.google.gson.Gson;

public class FlightAction extends ActionSupport {

	/**
	 * all search parameters are passed in this object
	 */
	private FlightSearch search;
	/**
	 * to return onwardSolutions
	 */
	private String on;
	/**
	 * to return returnSolutions
	 */
	private String ret;
	/**
	 * for oneWay or returnTrip flag
	 */
	private String trip;
	/**
	 * for advanced search options
	 */
	private String optionalVal;

	@Resource
	private ClearTripAPI api;

	public String getTrip() {
		return trip;
	}

	public void setTrip(final String trip) {
		this.trip = trip;
	}

	public String getOptionalVal() {
		return optionalVal;
	}

	public void setOptionalVal(final String optionalVal) {
		this.optionalVal = optionalVal;
	}

	public String getOn() {
		return on;
	}

	public void setOn(final String on) {
		this.on = on;
	}

	public String getRet() {
		return ret;
	}

	public void setRet(final String ret) {
		this.ret = ret;
	}

	public FlightSearch getSearch() {
		return search;
	}

	public void setSearch(final FlightSearch search) {
		this.search = search;
	}

	@Override
	public String execute() throws Exception {
		System.out.println(search);
		go();
		if(search == null) {
			return INPUT;
		}
		if (isValidSearch()) {
			final FlightMin flightList = api.searchFlight(search);
			final Gson gson = new Gson();
			on = gson.toJson(flightList.getOnwardSolutions());
			ret = gson.toJson(flightList.getOnwardSolutions());
			return SUCCESS;
		} else {
			return INPUT;
		}
	}

	private boolean isValidSearch() {
		if (search.getTo() == null || search.getFrom() == null
				|| search.getDepartDate() == null || search.getTo().isEmpty()
				|| search.getFrom().isEmpty()
				|| search.getDepartDate().isEmpty()) {
			return false;
		}
		if(search.getTo().contains("India -") && search.getFrom().contains("India -")) {
			search.setDomestic(true);
		}
		else {
			search.setDomestic(false);
		}
		// extracting the IATA code
		String sub = search.getTo();
		sub = sub.substring(sub.length() - 4, sub.length()-1);
		search.setTo(sub);
		sub = search.getFrom();
		sub = sub.substring(sub.length() - 4, sub.length()-1);
		search.setFrom(sub);
		// end of extracting the IATA code
		if (trip != null && trip.equals("oneWay")) {
			search.setReturnDate(null);
		}
		if (optionalVal != null && optionalVal.equals("true")) {
			search.setInfants(null);
			search.setChildren(null);
			search.setCarrier(null);
			search.setCabinType(null);
			search.setAdults(null);
		}
		return true;
	}

	/**
	 * Auto-generated
	 */
	private static final long serialVersionUID = 1L;
}
