package in.theqwerty.travel.webapp.actions.json;

import in.theqwerty.travel.deal.beans.DealMin;

import java.util.List;

public class PaginatedDealsResponse {

	private List<DealMin> dealmins;
	
	private int rowCount;

	public List<DealMin> getDealmins() {
		return dealmins;
	}

	public void setDealmins(List<DealMin> dealmins) {
		this.dealmins = dealmins;
	}

	public int getRowCount() {
		return rowCount;
	}

	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}
}
