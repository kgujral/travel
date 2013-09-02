package in.theqwerty.travel.flight.beans.xml;


/**
 * This class will be used to store a search criteria
 * for flight searching module.
 * The objects of this class wont ever be persisted in a database.
 */
public class FlightSearch {

	/**
	 * Specifying a valid IATA code.
	 * Default (as assumed by cleartrip API) = (none)
	 * Query String param = from
	 */
	private String from;
	
	/**
	 * Specifying a valid IATA code for destination.
	 * Default (as assumed by cleartrip API) = (none)
	 * Query String param = to
	 */
	private String to;
	
	/**
	 * Date of departure 
	 * A valid ISO date (YYYY-MM-DD)
	 * Default (as assumed by cleartrip API) = (none)
	 * Query String param = depart-date
	 */
	private String departDate;
	
	/**
	 * Return date.
	 * A valid ISO date (YYYY-MM-DD)
	 * Will be used only when a return trip is chosen
	 * If not supplied, Default (as assumed by cleartrip API) = null
	 * Query String param = return-date
	 */
	private String returnDate;
	
	/**
	 * Number of adults boarding the flight
	 * Cannot be greater than 9.
	 * If not supplied, Default (as assumed by cleartrip API) = 1
	 * Query String param = adults
	 */
	private String adults;
	
	/**
	 * Number of children boarding the flight
	 * Cannot be greater than 9.
	 * If not supplied, Default (as assumed by cleartrip API) = 0
	 * Query String param = children
	 */
	private String children;
	
	/**
	 * Number of infants boarding the flight
	 * Cannot be greater than 9.
	 * If not supplied, Default (as assumed by cleartrip API) = 0 
	 * Query String param = infants
	 */
	private String infants;
	
	/**
	 * Airline preference specified as a valid IATA Code.
	 * If not supplied, Default (as assumed by cleartrip API) = Any Carrier
	 * Query String param = carrier
	 */
	private String carrier;
	
	/**
	 * The cabin class as "Economy" or "Business"
	 * If not supplied, Default (as assumed by cleartrip API) = "Economy" 
	 * Query String param = cabin-type
	 */
	private String cabinType;
	
	/**
	 * A boolean value indicating if the selected journey
	 * is domestic (true value) or international (false value).
	 * default = true
	 */
	private boolean domestic;

	/**
	 * @return the from
	 */
	public String getFrom() {
		return from;
	}

	/**
	 * @param from the from to set
	 */
	public void setFrom(String from) {
		this.from = from;
	}

	/**
	 * @return the to
	 */
	public String getTo() {
		return to;
	}

	/**
	 * @param to the to to set
	 */
	public void setTo(String to) {
		this.to = to;
	}

	/**
	 * @return the departDate
	 */
	public String getDepartDate() {
		return departDate;
	}

	/**
	 * @param departDate the departDate to set
	 */
	public void setDepartDate(String departDate) {
		this.departDate = departDate;
	}

	/**
	 * @return the returnDate
	 */
	public String getReturnDate() {
		return returnDate;
	}

	/**
	 * @param returnDate the returnDate to set
	 */
	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}

	/**
	 * @return the adults
	 */
	public String getAdults() {
		return adults;
	}

	/**
	 * @param adults the adults to set
	 */
	public void setAdults(String adults) {
		this.adults = adults;
	}

	/**
	 * @return the children
	 */
	public String getChildren() {
		return children;
	}

	/**
	 * @param children the children to set
	 */
	public void setChildren(String children) {
		this.children = children;
	}

	/**
	 * @return the infants
	 */
	public String getInfants() {
		return infants;
	}

	/**
	 * @param infants the infants to set
	 */
	public void setInfants(String infants) {
		this.infants = infants;
	}

	/**
	 * @return the carrier
	 */
	public String getCarrier() {
		return carrier;
	}

	/**
	 * @param carrier the carrier to set
	 */
	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}

	/**
	 * @return the cabinType
	 */
	public String getCabinType() {
		return cabinType;
	}

	/**
	 * @param cabinType the cabinType to set
	 */
	public void setCabinType(String cabinType) {
		this.cabinType = cabinType;
	}
	
	/**
	 * @return the domestic
	 */
	public boolean isDomestic() {
		return domestic;
	}

	/**
	 * @param domestic the domestic to set
	 */
	public void setDomestic(boolean domestic) {
		this.domestic = domestic;
	}

	public FlightSearch(String from, String to, String departDate,
			String returnDate, String adults, String children, String infants,
			String carrier, String cabinType, boolean domestic) {
		this.from = from;
		this.to = to;
		this.departDate = departDate;
		this.returnDate = returnDate;
		this.adults = adults;
		this.children = children;
		this.infants = infants;
		this.carrier = carrier;
		this.cabinType = cabinType;
		this.domestic = domestic;
	}

	@Override
	public String toString() {
		return "FlightSearch [from=" + from + ", to=" + to + ", departDate="
				+ departDate + ", returnDate=" + returnDate + ", adults="
				+ adults + ", children=" + children + ", infants=" + infants
				+ ", carrier=" + carrier + ", cabinType=" + cabinType
				+ ", domestic=" + domestic + "]";
	}

	public FlightSearch() {
		this.domestic = true; // setting default to true!
	}
}
