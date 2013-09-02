package in.theqwerty.travel.deal.services;

import in.theqwerty.travel.core.services.GenericDaoImpl;
import in.theqwerty.travel.deal.api.DealCategoryDao;
import in.theqwerty.travel.deal.domain.DealCategory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository("dealCategoryDao")
public class DealCategoryDaoImpl extends GenericDaoImpl<Long, DealCategory> implements
		DealCategoryDao {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	public DealCategory getDealCategoryByDealType(String dealType) {
		
		logger.info("DAO Layer getDealCategoryByDealType");
		try{
			DealCategory dealCategory = (DealCategory)getEntityManager()
					.createQuery("from DealCategory where dealType=:dealType")
					.setParameter("dealType", dealType).getSingleResult();
			
			logger.info("Successfully returning deals");
			return dealCategory;
		}catch (Exception e) {
			logger.error("some exception occured while fetching from DB ..returning null");
			return null;
		}
	}
}

