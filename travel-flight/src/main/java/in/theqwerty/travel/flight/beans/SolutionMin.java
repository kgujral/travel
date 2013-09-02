package in.theqwerty.travel.flight.beans;

public class SolutionMin {

	
	private String flightName;
	private String departTime;
	private String arrivalTime;
	private float totalFare;
	
	public float getTotalFare() {
		return totalFare;
	}
	public void setTotalFare(float totalFare) {
		this.totalFare = totalFare;
	}
	public String getFlightName() {
		return flightName;
	}
	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}
	public String getDepartTime() {
		return departTime;
	}
	public void setDepartTime(String departTime) {
		this.departTime = departTime;
	}
	public String getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	@Override
	public String toString() {
		return "SolutionMin [flightName=" + flightName + ", departTime="
				+ departTime + ", arrivalTime=" + arrivalTime + ", totalFare="
				+ totalFare + "]";
	}
	
}
