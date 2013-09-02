package in.theqwerty.travel.flight.beans;

import java.util.ArrayList;
import java.util.List;

public class FlightMin {

	private List<SolutionMin> onwardSolutions;
	private List<SolutionMin> returnSolutions;
	private int statusCode;
	
	public List<SolutionMin> getOnwardSolutions() {
		return onwardSolutions;
	}
	public void setOnwardSolutions(List<SolutionMin> onwardSolutions) {
		this.onwardSolutions = onwardSolutions;
	}
	public List<SolutionMin> getReturnSolutions() {
		return returnSolutions;
	}
	public void setReturnSolutions(List<SolutionMin> returnSolutions) {
		this.returnSolutions = returnSolutions;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	
	public FlightMin() {
		onwardSolutions = new ArrayList<SolutionMin>();
		returnSolutions = new ArrayList<SolutionMin>();
		statusCode = 404;
	}
	
}
