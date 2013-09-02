package in.theqwerty.travel.webapp.actions;


import in.theqwerty.travel.core.services.FormSubmitService;
import in.theqwerty.travel.deal.api.DealDao;
import in.theqwerty.travel.deal.domain.Deal;
import in.theqwerty.travel.deal.domain.DealCategory;
import in.theqwerty.travel.hotel.domain.Hotel;
import in.theqwerty.travel.webapp.cache.ApplicationCache;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletContext;

public class UpdateDealAction extends AdminAction {
	
	private static final long serialVersionUID = 1L;

	@Resource
	private ServletContext servletContext;
	
	@Resource
	private FormSubmitService formSubmitService;
	
	@Resource
	private DealDao dealDao;
	
	private Deal deal;
	
	private Long hotelId;
	
	private List<String> dealTypes = new ArrayList<String>();
	private String featured;
	private String slider;
	
	private List<File> dealFileUpload = new ArrayList<File>();
	private List<String> dealFileUploadContentType = new ArrayList<String>();
	private List<String> dealFileUploadFileName = new ArrayList<String>();
	
	//Still mapping of Date added and Date deal will expire is missing
	@Override
	public String execute() throws Exception {
		if(isAuthorized()) {
			ArrayList<String> dealImageUrls = formSubmitService.fileUploader(dealFileUpload, dealFileUploadContentType, dealFileUploadFileName,servletContext,"deal",deal.getName());
			
			if(dealImageUrls==null)
				return ERROR;
			
			getDeal().setImageUrls(dealImageUrls);
			List<DealCategory> dealCategories = getCategoriesOutOfList(dealTypes);
	
			Hotel hotel = new Hotel();
			hotel.setId(hotelId);
			
			
			updateDeal(dealCategories,hotel);
			dealDao.persist(deal);
			ApplicationCache.refreshDeals();
			return SUCCESS;
		}
		return LOGIN;
	}
	
	private void updateDeal(List<DealCategory> dealCategories,Hotel hotel) {

		getDeal().setHotel(hotel);
		getDeal().setDealCategories(dealCategories);
		getDeal().getDealAnalytics().setFeatured(featured.equalsIgnoreCase("yes"));
		getDeal().getDealAnalytics().setSlider(slider.equalsIgnoreCase("yes"));
		
	}
	
	private List<DealCategory> getCategoriesOutOfList(List<String> list) {
		List<DealCategory> dealCategories = new ArrayList<DealCategory>();
		for(String dealType : list) {
			DealCategory temp = new DealCategory();
			temp.setId(Long.parseLong(dealType));
			dealCategories.add(temp);
		}
		return dealCategories;
	}

	public Deal getDeal() {
		return deal;
	}
	public void setDeal(Deal deal) {
		this.deal = deal;
	}

	public List<File> getDealFileUpload() {
		return dealFileUpload;
	}

	public void setDealFileUpload(List<File> dealFileUpload) {
		this.dealFileUpload = dealFileUpload;
	}

	public List<String> getDealFileUploadContentType() {
		return dealFileUploadContentType;
	}

	public void setDealFileUploadContentType(List<String> dealFileUploadContentType) {
		this.dealFileUploadContentType = dealFileUploadContentType;
	}

	public List<String> getDealFileUploadFileName() {
		return dealFileUploadFileName;
	}

	public void setDealFileUploadFileName(List<String> dealFileUploadFileName) {
		this.dealFileUploadFileName = dealFileUploadFileName;
	}

	public List<String> getDealTypes() {
		return dealTypes;
	}

	public void setDealTypes(List<String> dealTypes) {
		this.dealTypes = dealTypes;
	}

	public String getFeatured() {
		return featured;
	}

	public void setFeatured(String featured) {
		this.featured = featured;
	}

	public Long getHotelId() {
		return hotelId;
	}

	public void setHotelId(Long hotelId) {
		this.hotelId = hotelId;
	}

	public String getSlider() {
		return slider;
	}

	public void setSlider(String slider) {
		this.slider = slider;
	}
	
}
