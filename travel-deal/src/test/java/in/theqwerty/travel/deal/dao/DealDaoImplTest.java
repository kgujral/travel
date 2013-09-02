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

import org.junit.Assert;
import org.junit.Test;

public class DealDaoImplTest extends AbstractDealTest{

	@Resource
	private DealDao dealDao;
	
	@Resource
	private DealCategoryDao dealCategoryDao;
	
	@Resource
	private HotelDao hotelDao;
	
	@Resource
	private DealAnalyticsDao dealAnalyticsDao;
	
	@Test
	public void testPersist() {

		Assert.assertNull(dealDao.findById(1L));
		Hotel hotel = createHotel("demoHotel");
		hotelDao.persist(hotel);
		Assert.assertNotNull(hotel.getId());

		Hotel hotelNew = hotelDao.findById(hotel.getId());
		Assert.assertEquals("9910863823", hotelNew.getPhoneNumbers().get(0));
		List<DealCategory> dealCategories = createDealCategoryAdventureAndFamily();
		DealAnalytics dealAnalytics = createDealAnalytics(true, new Date(), new Date(), false, 5);
		Deal deal = createDeal("demoDeal",hotel,500,dealCategories,dealAnalytics);
		Deal deal2 = createDeal("demoDeal2",hotel,500,dealCategories,dealAnalytics);
		dealDao.persist(deal);
		dealDao.persist(deal2);
		Assert.assertNotNull(dealDao.findById(1L));
		
	}
	
	@Test
	public void shouldGetDealsByHotel() {
		Hotel hotel = createHotel("demoHotel1");
		hotelDao.persist(hotel);
		List<DealCategory> dealCategories = createDealCategoryAdventureAndFamily();
		DealAnalytics dealAnalytics = createDealAnalytics(true, new Date(), new Date(), false, 5);
		Deal deal = createDeal("demoDeal", hotel,500,dealCategories,dealAnalytics);
		dealDao.persist(deal);
		Deal deal2 = createDeal("demoDeal2", hotel,1000,dealCategories,dealAnalytics);
		dealDao.persist(deal2);
		
		List<Deal> deals= dealDao.getDealsByHotel(hotel);
		Assert.assertNotNull(deals);
		Assert.assertEquals(2, deals.size());
		
	}
	
	@Test
	public void shouldGetDealsByPriceBetween() {
		Hotel hotel = createHotel("demoHotel1");
		hotelDao.persist(hotel);
		List<DealCategory> dealCategories = createDealCategoryAdventureAndFamily();
		DealAnalytics dealAnalytics = createDealAnalytics(true, new Date(), new Date(), false, 5);
		Deal deal = createDeal("demoDeal", hotel,500,dealCategories,dealAnalytics);
		dealDao.persist(deal);
		Deal deal2 = createDeal("demoDeal2", hotel,1000,dealCategories,dealAnalytics);
		dealDao.persist(deal2);
		
		List<Deal> deals= dealDao.getDealsByPriceBetween(600,1222);
		Assert.assertNotNull(deals);
		Assert.assertEquals(1, deals.size());
		deals= dealDao.getDealsByPriceBetween(500,1000);
		Assert.assertNotNull(deals);
		Assert.assertEquals(2, deals.size());
	}
	
	@Test
	public void shouldGetDealsByPriceGreaterThan() {
		Hotel hotel = createHotel("demoHotel1");
		hotelDao.persist(hotel);
		List<DealCategory> dealCategories = createDealCategoryAdventureAndFamily();
		DealAnalytics dealAnalytics = createDealAnalytics(true, new Date(), new Date(), false, 5);
		Deal deal = createDeal("demoDeal", hotel,500,dealCategories,dealAnalytics);
		dealDao.persist(deal);
		Deal deal2 = createDeal("demoDeal2", hotel,1000,dealCategories,dealAnalytics);
		dealDao.persist(deal2);
		
		List<Deal> deals= dealDao.getDealsByPriceGreaterThan(600);
		Assert.assertNotNull(deals);
		Assert.assertEquals(1, deals.size());
		deals= dealDao.getDealsByPriceGreaterThan(200);
		Assert.assertNotNull(deals);
		Assert.assertEquals(2, deals.size());
	}
	
	@Test
	public void shouldGetDealsByPriceLessThan() {
		Hotel hotel = createHotel("demoHotel1");
		hotelDao.persist(hotel);
		List<DealCategory> dealCategories = createDealCategoryAdventureAndFamily();
		DealAnalytics dealAnalytics = createDealAnalytics(true, new Date(), new Date(), false, 5);
		Deal deal = createDeal("demoDeal", hotel,500,dealCategories,dealAnalytics);
		dealDao.persist(deal);
		Deal deal2 = createDeal("demoDeal2", hotel,1000,dealCategories,dealAnalytics);
		dealDao.persist(deal2);
		
		List<Deal> deals= dealDao.getDealsByPriceLessThan(600);
		Assert.assertNotNull(deals);
		Assert.assertEquals(1, deals.size());
		deals= dealDao.getDealsByPriceLessThan(1200);
		Assert.assertNotNull(deals);
		Assert.assertEquals(2, deals.size());
	}
	
	@Test
	public void shouldGetDealsByCategory() {
		Hotel hotel = createHotel("demoHotel1");
		hotelDao.persist(hotel);
		List<DealCategory> dealCategories = createDealCategoryAdventureAndFamily();
		DealAnalytics dealAnalytics = createDealAnalytics(true, new Date(), new Date(), false, 5);
		Deal deal = createDeal("demoDeal", hotel,500,dealCategories,dealAnalytics);
		dealDao.persist(deal);
		dealCategories = createDealCategoryRomanticAndFamily();
		System.out.println(dealCategories.get(0).getDealType());
		Deal deal2 = createDeal("demoDeal2", hotel,1000,dealCategories,dealAnalytics);
		dealDao.persist(deal2);
		dealCategories.remove(1);
		List<Deal> deals = dealDao.getDealsByCategory(dealCategories);
		Assert.assertNotNull(deals);
		Assert.assertEquals(1, deals.size());
		
	}
	
	@Test
	public void shouldGetDealsByCategoryGreaterThan() {
		Hotel hotel = createHotel("demoHotel1");
		hotelDao.persist(hotel);
		List<DealCategory> dealCategories = createDealCategoryAdventureAndFamily();
		DealAnalytics dealAnalytics = createDealAnalytics(true, new Date(), new Date(), false, 5);
		Deal deal = createDeal("demoDeal", hotel,500,dealCategories,dealAnalytics);
		dealDao.persist(deal);
		dealCategories = createDealCategoryRomanticAndFamily();
		System.out.println(dealCategories.get(0).getDealType());
		Deal deal2 = createDeal("demoDeal2", hotel,1000,dealCategories,dealAnalytics);
		dealDao.persist(deal2);
		dealCategories.remove(0);
		List<Deal> deals = dealDao.getDealsByCategoryGreaterThan(dealCategories,600);
		Assert.assertNotNull(deals);
		Assert.assertEquals(1, deals.size());
		
	}
	
	@Test
	public void shouldGetDealsByCategoryLessThan() {
		Hotel hotel = createHotel("demoHotel1");
		hotelDao.persist(hotel);
		List<DealCategory> dealCategories = createDealCategoryAdventureAndFamily();
		DealAnalytics dealAnalytics = createDealAnalytics(true, new Date(), new Date(), false, 5);
		Deal deal = createDeal("demoDeal", hotel,500,dealCategories,dealAnalytics);
		dealDao.persist(deal);
		dealCategories = createDealCategoryRomanticAndFamily();
		System.out.println(dealCategories.get(0).getDealType());
		Deal deal2 = createDeal("demoDeal2", hotel,1000,dealCategories,dealAnalytics);
		dealDao.persist(deal2);
		dealCategories.remove(0);
		List<Deal> deals = dealDao.getDealsByCategoryLessThan(dealCategories,600);
		Assert.assertNotNull(deals);
		Assert.assertEquals(1, deals.size());
		
	}
	
	@Test
	public void shouldGetDealsByCategoryBetween() {
		Hotel hotel = createHotel("demoHotel1");
		hotelDao.persist(hotel);
		List<DealCategory> dealCategories = createDealCategoryAdventureAndFamily();
		DealAnalytics dealAnalytics = createDealAnalytics(true, new Date(), new Date(), false, 5);
		Deal deal = createDeal("demoDeal", hotel,500,dealCategories,dealAnalytics);
		dealDao.persist(deal);
		dealCategories = createDealCategoryRomanticAndFamily();
		System.out.println(dealCategories.get(0).getDealType());
		Deal deal2 = createDeal("demoDeal2", hotel,1000,dealCategories,dealAnalytics);
		dealDao.persist(deal2);
		dealCategories.remove(0);
		List<Deal> deals = dealDao.getDealsByCategoryBetween(dealCategories,500,1000);
		Assert.assertNotNull(deals);
		Assert.assertEquals(2, deals.size());
		
	}
	
	
	@Test
	public void shouldGetDealsByCategory2() {
		Hotel hotel = createHotel("demoHotel1");
		hotelDao.persist(hotel);
		List<DealCategory> dealCategories = createDealCategoryAdventureAndFamily();
		DealAnalytics dealAnalytics = createDealAnalytics(true, new Date(), new Date(), false, 5);
		Deal deal = createDeal("demoDeal", hotel,500,dealCategories,dealAnalytics);
		dealDao.persist(deal);
		dealCategories = createDealCategoryRomanticAndFamily();
		System.out.println(dealCategories.get(0).getDealType());
		Deal deal2 = createDeal("demoDeal2", hotel,1000,dealCategories,dealAnalytics);
		dealDao.persist(deal2);
		dealCategories.remove(0);
		List<Deal> deals = dealDao.getDealsByCategory(dealCategories);
		Assert.assertNotNull(deals);
		Assert.assertEquals(2, deals.size());
		
	}
	
	@Test
	public void shouldGetSliderDeals() {
		Hotel hotel = createHotel("demoHotel1");
		hotelDao.persist(hotel);
		List<DealCategory> dealCategories = createDealCategoryAdventureAndFamily();
		DealAnalytics dealAnalytics = createDealAnalytics(true, new Date(), new Date(), false, 5);
		Deal deal = createDeal("demoDeal", hotel,500,dealCategories,dealAnalytics);
		dealDao.persist(deal);
		dealCategories = createDealCategoryRomanticAndFamily();
		System.out.println(dealCategories.get(0).getDealType());
		Deal deal2 = createDeal("demoDeal2", hotel,1000,dealCategories,dealAnalytics);
		dealDao.persist(deal2);
		List<Deal> deals = dealDao.getFeaturedDeals(true);
		Assert.assertNotNull(deals);
		Assert.assertEquals(2, deals.size());
	}
	
	@Test
	public void shouldGetFeaturedDeals() {
		Hotel hotel = createHotel("demoHotel1");
		hotelDao.persist(hotel);
		List<DealCategory> dealCategories = createDealCategoryAdventureAndFamily();
		DealAnalytics dealAnalytics = createDealAnalytics(true, new Date(), new Date(), false, 5);
		Deal deal = createDeal("demoDeal", hotel,500,dealCategories,dealAnalytics);
		dealDao.persist(deal);
		dealCategories = createDealCategoryRomanticAndFamily();
		System.out.println(dealCategories.get(0).getDealType());
		Deal deal2 = createDeal("demoDeal2", hotel,1000,dealCategories,dealAnalytics);
		dealDao.persist(deal2);
		List<Deal> deals = dealDao.getFeaturedDeals(true);
		Assert.assertNotNull(deals);
		Assert.assertEquals(2, deals.size());
	}
	
	@Test
	public void shouldNotGetFeaturedDeals() {
		Hotel hotel = createHotel("demoHotel1");
		hotelDao.persist(hotel);
		List<DealCategory> dealCategories = createDealCategoryAdventureAndFamily();
		DealAnalytics dealAnalytics = createDealAnalytics(true, new Date(), new Date(), false, 5);
		Deal deal = createDeal("demoDeal", hotel,500,dealCategories,dealAnalytics);
		dealDao.persist(deal);
		dealCategories = createDealCategoryRomanticAndFamily();
		System.out.println(dealCategories.get(0).getDealType());
		Deal deal2 = createDeal("demoDeal2", hotel,1000,dealCategories,dealAnalytics);
		dealDao.persist(deal2);
		List<Deal> deals = dealDao.getFeaturedDeals(false);
		Assert.assertSame(0, deals.size());
	}
	
	@Test
	public void shouldGetDealsCorrespondingToQueryString() {
		List<DealCategory> dealCategories = createDealCategoryAdventureAndFamily();
		for(int i=0;i<50;i++ ) {
			Hotel hotel = createHotel("demoHotel1");
			hotelDao.persist(hotel);
			
			DealAnalytics dealAnalytics = createDealAnalytics(true, new Date(), new Date(), false, 5);
			Deal deal = createDeal("demoDeal", hotel,6000,dealCategories,dealAnalytics);
			dealDao.persist(deal);
		}
		List<Deal> deals = dealDao.getDealsCorrespondingToQueryString("", 0, 0L, 1, 9);
		System.out.println(deals.size());
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
	
	/*private Deal createDeal(String name,Hotel hotel) {
		Deal deal = new Deal();
		deal.setDealPrice(5000.00);
		deal.setShortDescription("demo description");
		deal.setHotel(hotel);
		deal.setName(name);		
		deal.setDealAnalytics(createDealAnalytics(true,new Date(),new Date(),false,3));
		return deal;
	}*/
	
	
	
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
		ArrayList<String> emails = new ArrayList<String>();
		emails.add("a");
		emails.add("b");
		emails.add("c");
		hotel.setEmails(emails);
		ArrayList<String> websites = new ArrayList<String>();
		websites.add("a");
		websites.add("b");
		hotel.setWebsites(websites);
		ArrayList<String> faxNumbers= new ArrayList<String>();
		faxNumbers.add("a");
		faxNumbers.add("b");
		faxNumbers.add("ca");
		hotel.setFaxNumbers(faxNumbers);
		ArrayList<String> imageUrls= new ArrayList<String>();
		imageUrls.add("a");
		imageUrls.add("ba");
		imageUrls.add("aa");
		hotel.setImageUrls(imageUrls);
		return hotel;
	}
}
