package in.theqwerty.travel.deal.api;

import java.util.List;

import in.theqwerty.travel.core.api.GenericDao;
import in.theqwerty.travel.deal.domain.Deal;
import in.theqwerty.travel.deal.domain.DealCategory;
import in.theqwerty.travel.hotel.domain.Hotel;

public interface DealDao extends GenericDao<Long, Deal> {
	
	List<Deal> findAll(int pageNumber,int pageSize);
	
	int getDealCount();
	
	List<Deal> getDealsByHotel(Hotel hotel);
	
	List<Deal> getDealsByPriceBetween(double min, double max);
	
	List<Deal> getDealsByPriceGreaterThan(double min);
	
	List<Deal> getDealsByPriceLessThan(double max);
	
	List<Deal> getDealsByCategory(List<DealCategory> dealCategories);

	List<Deal> getDealsByCategoryGreaterThan(List<DealCategory> dealCategories,
			double min);

	List<Deal> getDealsByCategoryLessThan(List<DealCategory> dealCategories,
			double max);

	List<Deal> getDealsByCategoryBetween(List<DealCategory> dealCategories,
			double min, double max);
	
	List<Deal> getFeaturedDeals(boolean featured);
	
	List<Deal> getLatestAddedFeaturedDeals(boolean featured);
	
	List<Deal> getSliderDeals(boolean slider);
	
	List<Deal> getNLatestAddedDeals(int howMany);

	
	List<Deal> getDealsCorrespondingToQueryString(String name,
			double price, Long id, int pageNumber, int pageSize);
	
	int getCountOfDealsCorrespondingToQueryString(String name,
			double price, Long id);
	
}
