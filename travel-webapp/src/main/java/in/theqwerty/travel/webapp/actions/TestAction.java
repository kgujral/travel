package in.theqwerty.travel.webapp.actions;

import in.theqwerty.travel.flight.beans.SolutionMin;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class TestAction extends ActionSupport {

	private List<SolutionMin> testList = new ArrayList<SolutionMin>();

	public List<SolutionMin> getTestList() {
		return testList;
	}
	public void setTestList(List<SolutionMin> testList) {
		this.testList = testList;
	}
	
	@Override
	public String execute() throws Exception {
		SolutionMin min;
		min = new SolutionMin();
		min.setArrivalTime("10");
		min.setDepartTime("20");
		
		testList.add(min);
		
		min = new SolutionMin();
		min.setArrivalTime("30");
		min.setDepartTime("40");
		
		testList.add(min);
		
		min = new SolutionMin();
		min.setArrivalTime("50");
		min.setDepartTime("60");
		
		testList.add(min);
		
		return SUCCESS;
	}
	
}
