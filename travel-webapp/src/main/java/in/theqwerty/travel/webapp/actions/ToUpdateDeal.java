package in.theqwerty.travel.webapp.actions;

import in.theqwerty.travel.deal.domain.DealCategory;
import in.theqwerty.travel.hotel.beans.HotelMin;
import in.theqwerty.travel.webapp.cache.ApplicationCache;

import java.util.ArrayList;
import java.util.List;

public class ToUpdateDeal extends AdminAction {

	
	private static final long serialVersionUID = 1955537722305034678L;
	
	private List<DealCategory> dealCategories;
	private List<String> featured;
	private List<HotelMin> hotels;

	@Override
	public String execute() throws Exception {
		if(isAuthorized()) {
			dealCategories = ApplicationCache.DEAL_CATEGORIES;
			featured = new ArrayList<String>();
			featured.add("Yes");
			featured.add("No");
			hotels = new ArrayList<HotelMin>();
			hotels.addAll(ApplicationCache.HOTELS);
			return SUCCESS;
		}
		return LOGIN;
	}
	
	public List<HotelMin> getHotels() {
		return hotels;
	}

	public void setHotels(List<HotelMin> hotels) {
		this.hotels = hotels;
	}

	public List<String> getFeatured() {
		return featured;
	}

	public void setFeatured(List<String> featured) {
		this.featured = featured;
	}

	public List<DealCategory> getDealCategories() {
		return dealCategories;
	}

	public void setDealCategories(List<DealCategory> dealCategories) {
		this.dealCategories = dealCategories;
	}

}
