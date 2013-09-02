package in.theqwerty.travel.webapp.cache;

import in.theqwerty.travel.deal.api.DealCategoryDao;
import in.theqwerty.travel.deal.api.DealDao;
import in.theqwerty.travel.deal.beans.DealMin;
import in.theqwerty.travel.deal.domain.Deal;
import in.theqwerty.travel.deal.domain.DealCategory;
import in.theqwerty.travel.deal.services.DealSummary;
import in.theqwerty.travel.hotel.api.HotelDao;
import in.theqwerty.travel.hotel.beans.HotelMin;
import in.theqwerty.travel.hotel.domain.Hotel;
import in.theqwerty.travel.hotel.services.HotelSummary;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public final class ApplicationCache implements  ServletContextListener {

	private static DealCategoryDao dealCategoryDao;
	
	private static DealDao dealDao;

	private static HotelDao hotelDao;
	
	public static final ArrayList<DealCategory> DEAL_CATEGORIES = new ArrayList<DealCategory>();
	public static final ArrayList<DealMin> FEATURED_DEALS = new ArrayList<DealMin>();
	public static final ArrayList<DealMin> SLIDER_DEALS = new ArrayList<DealMin>();
	public static final ArrayList<DealMin> LATEST_DEALS = new ArrayList<DealMin>();
	public static final ArrayList<HotelMin> HOTELS = new ArrayList<HotelMin>();
	
	public void contextInitialized(ServletContextEvent arg0) {
		ServletContext servletContext = arg0.getServletContext();
		WebApplicationContext wac = WebApplicationContextUtils.
		getRequiredWebApplicationContext(servletContext);
		init(wac);
		refreshAll();
		System.out.println(HOTELS);
	}

	private static void fillHotels() {
		HOTELS.clear();
		List<Hotel> hotelList = hotelDao.findAll();
		for(Hotel hotel : hotelList) {
			HOTELS.add(HotelSummary.valueOf(hotel));
		}
	}

	private static void fillSliderDeals() {
		SLIDER_DEALS.clear();
		List<Deal> deals = dealDao.getSliderDeals(true);
		int count = 0;
		for(Deal t: deals) {
			count ++;
			DealMin min = DealSummary.valueOf(t, 75, 305);
			SLIDER_DEALS.add(min);
			if(count == 5) {
				break;
			}
		}
	}

	private static void fillFeaturedDeals() {
		FEATURED_DEALS.clear();
		List<Deal> temp = dealDao.getLatestAddedFeaturedDeals(true);
		int count = 0;
		for(Deal t: temp) {
			count ++;
			DealMin min = DealSummary.valueOf(t, 1, 305);
			FEATURED_DEALS.add(min);
			if(count == 2) {
				break;
			}
		}
	}
	private static void fillLatestDeals() {
		LATEST_DEALS.clear();
		List<Deal> temp = dealDao.getNLatestAddedDeals(5);
		for(Deal t: temp) {
			DealMin min = DealSummary.valueOf(t, 1, 1);
			LATEST_DEALS.add(min);
		}
	}

	private static void fillDealCategories() {
		DEAL_CATEGORIES.clear();
		DEAL_CATEGORIES.addAll(dealCategoryDao.findAll());
		
	}

	private static void init(WebApplicationContext wac) {
		hotelDao = (HotelDao)wac.getBean("hotelDao");
		dealDao = (DealDao)wac.getBean("dealDao");
		dealCategoryDao = (DealCategoryDao)wac.getBean("dealCategoryDao");
	}
	
	public static void refreshAll() {
		fillLatestDeals();
		fillDealCategories();
		fillFeaturedDeals();
		fillSliderDeals();
		fillHotels();
	}
	public static void refreshDeals() {
		fillLatestDeals();
		fillFeaturedDeals();
		fillSliderDeals();
	}

	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
	}


}
