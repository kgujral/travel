package in.theqwerty.travel.deal.services;

import in.theqwerty.travel.deal.beans.DealMin;
import in.theqwerty.travel.deal.domain.Deal;

public final class DealSummary {

	public static DealMin valueOf(final Deal deal, final int shortLength, final int longLength) {
		if(deal == null) {
			return null;
		}
		DealMin min = new DealMin();
		
		min.setId(deal.getId().toString());
		min.setName(deal.getName());
		min.setImgUrl(deal.getImageUrls().get(0));
		min.setShortDesc(deal.getShortDescription().substring(0, deal.getShortDescription().length() > shortLength? shortLength:deal.getShortDescription().length()));
		min.setLongDesc(deal.getLongDescription().substring(0, deal.getLongDescription().length() > longLength? longLength:deal.getLongDescription().length()));
		min.setOldPrice(Double.toString(deal.getOldPrice()));
		min.setDealPrice(Double.toString(deal.getDealPrice()));
		
		return min;
	}
}
