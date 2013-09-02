package in.theqwerty.travel.webapp.actions;


import in.theqwerty.travel.core.services.FormSubmitService;
import in.theqwerty.travel.hotel.api.HotelDao;
import in.theqwerty.travel.hotel.domain.Hotel;
import in.theqwerty.travel.hotel.services.HotelSummary;
import in.theqwerty.travel.webapp.cache.ApplicationCache;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletContext;

public class UpdateHotelAction extends AdminAction {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Resource
	private ServletContext servletContext;
	
	@Resource
	private FormSubmitService formSubmitService;
	
	@Resource
	private HotelDao hotelDao;
	
	private Hotel hotel;
	
	private List<String> hotelPhoneNumbers = new ArrayList<String>();
	private List<String> hotelFaxNumbers = new ArrayList<String>();
	private List<String> hotelEmails = new ArrayList<String>();
	private List<String> hotelWebsites = new ArrayList<String>();
	private List<File>   hotelFileUpload = new ArrayList<File>();
	private List<String> hotelFileUploadContentType = new ArrayList<String>();
	private List<String> hotelFileUploadFileName = new ArrayList<String>();

	@Override
	public String execute() throws Exception {
		if(isAuthorized()) {
			ArrayList<String> hotelImageUrls = formSubmitService.fileUploader(hotelFileUpload, hotelFileUploadContentType, hotelFileUploadFileName, servletContext, "hotel",hotel.getName());
			
			if(hotelImageUrls==null) {
				return ERROR;
			}
			getHotel().setImageUrls(hotelImageUrls);
			updateHotel();
			hotelDao.persist(getHotel());
			ApplicationCache.HOTELS.add(HotelSummary.valueOf(getHotel()));
			return SUCCESS;
		}
		return LOGIN;
	}

	private void updateHotel() {
		
		getHotel().setEmails(formSubmitService.getListOutOfList((ArrayList<String>) hotelEmails));
		getHotel().setFaxNumbers(formSubmitService.getListOutOfList((ArrayList<String>)hotelFaxNumbers));
		getHotel().setPhoneNumbers(formSubmitService.getListOutOfList((ArrayList<String>)hotelPhoneNumbers));
		getHotel().setWebsites(formSubmitService.getListOutOfList((ArrayList<String>)hotelWebsites));
	}

	public List<String> getHotelPhoneNumbers() {
		return hotelPhoneNumbers;
	}

	public void setHotelPhoneNumbers(List<String> hotelPhoneNumbers) {
		this.hotelPhoneNumbers = hotelPhoneNumbers;
	}

	public List<String> getHotelFaxNumbers() {
		return hotelFaxNumbers;
	}

	public void setHotelFaxNumbers(List<String> hotelFaxNumbers) {
		this.hotelFaxNumbers = hotelFaxNumbers;
	}

	public List<String> getHotelEmails() {
		return hotelEmails;
	}

	public void setHotelEmails(List<String> hotelEmails) {
		this.hotelEmails = hotelEmails;
	}

	public List<String> getHotelWebsites() {
		return hotelWebsites;
	}

	public void setHotelWebsites(List<String> hotelWebsites) {
		this.hotelWebsites = hotelWebsites;
	}

	public void setHotelWebsites(ArrayList<String> hotelWebsites) {
		this.hotelWebsites = hotelWebsites;
	}

	public List<File> getHotelFileUpload() {
		return hotelFileUpload;
	}

	public void setHotelFileUpload(List<File> hotelFileUpload) {
		this.hotelFileUpload = hotelFileUpload;
	}

	public List<String> getHotelFileUploadContentType() {
		return hotelFileUploadContentType;
	}

	public void setHotelFileUploadContentType(
			List<String> hotelFileUploadContentType) {
		this.hotelFileUploadContentType = hotelFileUploadContentType;
	}

	public List<String> getHotelFileUploadFileName() {
		return hotelFileUploadFileName;
	}

	public void setHotelFileUploadFileName(List<String> hotelFileUploadFileName) {
		this.hotelFileUploadFileName = hotelFileUploadFileName;
	}
	
	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	
}
