package in.theqwerty.travel.hotel.services;

import in.theqwerty.travel.core.services.GenericDaoImpl;
import in.theqwerty.travel.deal.domain.Deal;
import in.theqwerty.travel.hotel.api.HotelDao;
import in.theqwerty.travel.hotel.domain.Hotel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository("hotelDao")
public class HotelDaoImpl extends GenericDaoImpl<Long, Hotel> implements HotelDao {

	private static Logger logger = LoggerFactory.getLogger("DealDaoImpl");
	
	public Hotel getHotelByDeal(Deal deal) {
		logger.info("DAO Layer getDealsByHotel");
		try{
		Hotel hotel = (Hotel)getEntityManager()
				.createQuery("from Hotel where deal=:deal")
				.setParameter("deal", deal).getSingleResult();
		
		logger.info("Successfully returning deals");
			return hotel;
		}catch (Exception e) {
			logger.error("some exception occured while fetching from DB ..returning null");
			return null;
		}
	}
}
