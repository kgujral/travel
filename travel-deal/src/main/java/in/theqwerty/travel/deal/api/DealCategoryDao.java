package in.theqwerty.travel.deal.api;

import in.theqwerty.travel.core.api.GenericDao;
import in.theqwerty.travel.deal.domain.DealCategory;

public interface DealCategoryDao extends GenericDao<Long, DealCategory> {
	DealCategory getDealCategoryByDealType(String dealType);
}
