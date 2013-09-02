package in.theqwerty.travel.hotel.services;

import in.theqwerty.travel.hotel.beans.HotelMin;
import in.theqwerty.travel.hotel.domain.Hotel;

public final class HotelSummary {

	public static HotelMin valueOf(final Hotel hotel) {
		if(hotel == null) {
			return null;
		}
		HotelMin min = new HotelMin();
		
		min.setId(hotel.getId().toString());
		min.setName(hotel.toString());
		
		return min;
	}
}
