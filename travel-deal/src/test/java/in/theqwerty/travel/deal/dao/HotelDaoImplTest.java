package in.theqwerty.travel.deal.dao;

import in.theqwerty.travel.deal.api.DealAnalyticsDao;
import in.theqwerty.travel.deal.api.DealCategoryDao;
import in.theqwerty.travel.deal.api.DealDao;
import in.theqwerty.travel.deal.domain.Deal;
import in.theqwerty.travel.deal.domain.DealAnalytics;
import in.theqwerty.travel.deal.domain.DealCategory;
import in.theqwerty.travel.hotel.api.HotelDao;
import in.theqwerty.travel.hotel.domain.Hotel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

public class HotelDaoImplTest extends AbstractDealTest{

	@Resource
	private HotelDao hotelDao;
	
	@Resource
	private DealDao dealDao;
	
	@Resource
	private DealCategoryDao dealCategoryDao;
	
	@Resource
	private DealAnalyticsDao dealAnalyticsDao;
	
	@Test
	public void shouldGetHotelByDeal() {
		// TODO Auto-generated method stub

	}
	
	private Deal createDeal(String name,Hotel hotel,double price,
			List<DealCategory> dealCategories,DealAnalytics dealAnalytics) {
		Deal deal = new Deal();
		deal.setDealPrice(price);
		deal.setShortDescription("demo description");
		deal.setHotel(hotel);
		deal.setName(name);		
		deal.setDealCategories(dealCategories);
		deal.setDealAnalytics(dealAnalytics);
		return deal;
	}
	
	private List<DealCategory> createDealCategoryAdventureAndFamily() {
		List<DealCategory> dealCategories =  new ArrayList<DealCategory>();
		DealCategory dealCategory = new DealCategory();
		dealCategory.setDealType("Adventure");
		dealCategoryDao.persist(dealCategory);
		dealCategories.add(dealCategory);
		dealCategory = new DealCategory();
		dealCategory.setDealType("Family");
		dealCategoryDao.persist(dealCategory);
		dealCategories.add(dealCategory);
		return dealCategories;
	}

	
	private List<DealCategory> createDealCategoryRomanticAndFamily() {
		List<DealCategory> dealCategories =  new ArrayList<DealCategory>();
		DealCategory dealCategory = new DealCategory();
		dealCategory.setDealType("Romantic");
		dealCategoryDao.persist(dealCategory);
		dealCategories.add(dealCategory);
		dealCategory = new DealCategory();
		dealCategory.setDealType("Family");
		dealCategoryDao.persist(dealCategory);
		dealCategories.add(dealCategory);
		return dealCategories;
	}
	
	private DealAnalytics createDealAnalytics(boolean featured, Date dateAdded, Date dateDeleted,
			boolean expired, int boughtCount) {
		DealAnalytics dealAnalytics = new DealAnalytics();
		dealAnalytics.setFeatured(featured);
		dealAnalytics.setBoughtCount(boughtCount);
		dealAnalytics.setDateAdded(dateAdded);
		dealAnalytics.setDateDeleted(dateDeleted);
		dealAnalytics.setExpired(expired);
		dealAnalyticsDao.persist(dealAnalytics);
		return dealAnalytics;
	}

	private Hotel createHotel(String name){
		Hotel hotel = new Hotel();
		hotel.setAddress("demoAddress");
		hotel.setName(name);
		hotel.setCity("demoCity");
		hotel.setCountry("demoCountry");
		hotel.setCountryCode("IN");
		hotel.setLocality("demoLocality");
		hotel.setState("demoState");
		hotel.setZip("110075");
		ArrayList<String> phoneNumbers = new ArrayList<String>();
		phoneNumbers.add("9910863823");
		phoneNumbers.add("9912263823");
		phoneNumbers.add("9888863823");
		hotel.setPhoneNumbers(phoneNumbers);
		return hotel;
	}
}
