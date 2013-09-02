package in.theqwerty.travel.webapp.actions;

import in.theqwerty.travel.deal.domain.DealCategory;
import in.theqwerty.travel.webapp.cache.ApplicationCache;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

public class ToDeals extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private List<DealCategory> categories = new ArrayList<DealCategory>();	

	public List<DealCategory> getCategories() {
		return categories;
	}

	public void setCategories(List<DealCategory> categories) {
		this.categories = categories;
	}

	@Override
	public String execute() throws Exception {
		DealCategory tempCat = new DealCategory();
		tempCat.setDealType("(any)");
		tempCat.setId(0L);
		categories.add(tempCat);
		categories.addAll(ApplicationCache.DEAL_CATEGORIES);
		return SUCCESS;
	}
}
