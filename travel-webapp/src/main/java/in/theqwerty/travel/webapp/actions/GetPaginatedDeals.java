package in.theqwerty.travel.webapp.actions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.ParameterAware;

import in.theqwerty.travel.deal.api.DealDao;
import in.theqwerty.travel.deal.beans.DealMin;
import in.theqwerty.travel.deal.domain.Deal;
import in.theqwerty.travel.deal.services.DealSummary;
import in.theqwerty.travel.webapp.actions.json.PaginatedDealsResponse;

import com.opensymphony.xwork2.Action;

public class GetPaginatedDeals implements Action,ParameterAware{
	
	private PaginatedDealsResponse paginatedDealsResponse;
	
	private Map<String, String[]> parameters;
	
	@Resource
	private DealDao dealDao;
	
	public Map<String, String[]> getParameters() {
		return parameters;
	}

	public PaginatedDealsResponse getPaginatedDealsResponse() {
		return paginatedDealsResponse;
	}

	public void setPaginatedDealsResponse(
			PaginatedDealsResponse paginatedDealsResponse) {
		this.paginatedDealsResponse = paginatedDealsResponse;
	}

	public String execute() throws Exception {
		String name = ((String[])parameters.get("name"))[0];
		if(name == null) {
			name ="";
		}
		double price = Double.valueOf(((String[])parameters.get("price"))[0]);
		Long id = Long.valueOf(((String[])parameters.get("id"))[0]);
		int pageNumber = Integer.valueOf(((String[])parameters.get("pageNumber"))[0]);
		int pageSize = Integer.valueOf(((String[])parameters.get("pageSize"))[0]);
		List<Deal> deals = dealDao.getDealsCorrespondingToQueryString(name, price, id, pageNumber, pageSize);
		List<DealMin> dealMins = new ArrayList<DealMin>();
		for(Deal deal:deals) {
			dealMins.add(DealSummary.valueOf(deal, 75, 1));
		}
		
		paginatedDealsResponse = new PaginatedDealsResponse();
		paginatedDealsResponse.setDealmins(dealMins);
		paginatedDealsResponse.setRowCount(dealDao.getCountOfDealsCorrespondingToQueryString(name, price, id));
		return SUCCESS;
	}

	public void setParameters(Map<String, String[]> parameters) {
		this.parameters=parameters;
	}

}
