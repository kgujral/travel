package in.theqwerty.travel.webapp.actions;

import in.theqwerty.travel.deal.api.DealDao;
import in.theqwerty.travel.deal.domain.Deal;
import in.theqwerty.travel.user.domain.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;


@SuppressWarnings("serial")
public class ToSingleDeal extends ActionSupport {

	private User user;
	private String id;
	private String imageUrl;
	private List<String> inclusionList;
	
	
	public List<String> getInclusionList() {
		return inclusionList;
	}

	public void setInclusionList(List<String> inclusionList) {
		this.inclusionList = inclusionList;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	private Deal deal;
	
	@Resource
	private DealDao dealDao;
	

	public String execute() throws Exception {
		go();
		user();
		id = deal == null? id : String.valueOf(deal.getId());
		if( id != null && !id.isEmpty()) {
			 
			if(!isDealInSession(id)) {
				deal = dealDao.findById(Long.valueOf(id));
				session.put("deal", deal);
			}
			else {
				deal = (Deal) session.get("deal");
			}
		}
		else if (session.containsKey("deal")){
			deal = (Deal) session.get("deal");
		}
		else {
			return INPUT;
		}
		imageUrl = deal.getImageUrls().get(0);
		if(deal.getInclusions() != null && !deal.getInclusions().isEmpty()) {
			inclusionList = Arrays.asList(deal.getInclusions().split(":"));
		}
		else {
			inclusionList = new ArrayList<String>();
			inclusionList.add("Minimum stay for 01 Nights and 02 Days in well appointed woom on twin sharing basis.");
			inclusionList.add("Free use of Hotel Amenities.");
			inclusionList.add("Rates are applicable on per person per night basis.");
			inclusionList.add("Terms and Conditions apply.");
		}
		
		return SUCCESS;
	}

	private boolean isDealInSession(String id) {
		if(session.containsKey("deal")) {
			Deal deal = (Deal)session.get("deal");
			return deal.getId().toString().equals(id);
		}
		return false;
	}

	private void user() {
		if(user == null && session.containsKey("user")) {
			user = (User)session.get("user");
		}
		else if(user != null && user.getEmail() != null) {
			session.put("user", user);
		}
		else {
			user = null;
		}
	}
	
	public Deal getDeal() {
		return deal;
	}

	public void setDeal(Deal deal) {
		this.deal = deal;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
