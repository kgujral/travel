package in.theqwerty.travel.hotel.api;

import in.theqwerty.travel.core.api.GenericDao;
import in.theqwerty.travel.deal.domain.Deal;
import in.theqwerty.travel.hotel.domain.Hotel;

public interface HotelDao extends GenericDao<Long, Hotel> {
	Hotel getHotelByDeal(Deal deal);
}