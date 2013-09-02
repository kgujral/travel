package in.theqwerty.travel.deal.services;


import in.theqwerty.travel.core.services.GenericDaoImpl;
import in.theqwerty.travel.deal.api.DealDao;
import in.theqwerty.travel.deal.domain.Deal;
import in.theqwerty.travel.deal.domain.DealCategory;
import in.theqwerty.travel.hotel.domain.Hotel;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository("dealDao")
public class DealDaoImpl extends GenericDaoImpl<Long, Deal> implements DealDao {
	
	private static Logger logger = LoggerFactory.getLogger("DealDaoImpl");
	
	public List<Deal> getDealsByHotel(Hotel hotel) {
		logger.info("DAO Layer getDealsByHotel");
		try{
		@SuppressWarnings("unchecked")
		List<Deal> deals = getEntityManager()
				.createQuery("from Deal where hotel=:hotel")
				.setParameter("hotel", hotel).getResultList();

		if(deals.size()==0){
			System.out.println("Size of list is zero...returning null");
			logger.info("Size of list is zero...returning null");
			return deals;
		}
		logger.info("Successfully returning deals");
			return deals;
		}catch (Exception e) {
			System.out.println("some exception occured while fetching from DB ..returning null");
			logger.error("some exception occured while fetching from DB ..returning null");
			return null;
		}
	}

	public List<Deal> getDealsByPriceBetween(double min,double max) {
		try{
			@SuppressWarnings("unchecked")
			List<Deal> deals = getEntityManager()
					.createQuery("from Deal where dealPrice >=:min and dealPrice<=:max")
					.setParameter("min", min).setParameter("max", max).getResultList();
			
			if(deals.size()==0){
				logger.error("Size of list is zero...returning null");
				return deals;
			}
			logger.info("Successfully returning deals");
			return deals;
		}catch (Exception e) {
			logger.error("some exception occured while fetching from DB ..returning null");
			return null;
		}
	}

	public List<Deal> getDealsByPriceGreaterThan(double min) {
		try{
			@SuppressWarnings("unchecked")
			List<Deal> deals = getEntityManager()
					.createQuery("from Deal where dealPrice >=:min")
					.setParameter("min", min).getResultList();
			
			if(deals.size()==0){
				logger.info("Size of list is zero...returning null");
				return deals;
			}
			logger.info("Successfully returning deals");
			return deals;
		}catch (Exception e) {
			logger.error("some exception occured while fetching from DB ..returning null");
			return null;
		}
	}

	public List<Deal> getDealsByPriceLessThan(double max) {
		try{
			@SuppressWarnings("unchecked")
			List<Deal> deals = getEntityManager()
					.createQuery("from Deal where dealPrice <=:max")
					.setParameter("max", max).getResultList();
			
			if(deals.size()==0){
				logger.info("Size of list is zero...returning null");
				return deals;
			}
			logger.info("Successfully returning deals");
			return deals;
		}catch (Exception e) {
			logger.error("some exception occured while fetching from DB ..returning null");
			return null;
		}
	}

	/*public List<Deal> getDealsByCategory(List<DealCategory> dealCategories) {
		
		List<String> dealTypes = new ArrayList<String>();
		
		for(DealCategory dealCategory : dealCategories)
			dealTypes.add(dealCategory.getDealType());

		StringBuilder str1=new StringBuilder("");
		for(String dealType :dealTypes)
			str1.append("dc.dealType='"+dealType+"' OR");
		str1.append(" false");
		
		String str="from Deal d,DealCategory dc where d.dealCategories_id=dc.id and ("+str1+")";
		org.hibernate.Session hSession = (org.hibernate.Session) getEntityManager().getDelegate();
		
		try{
			@SuppressWarnings("unchecked")
			List<Deal> deals = hSession.createCriteria(Deal.class)
					.add(Restrictions.eq("dealCategories", dealCategories)).list();
			
			if(deals.size()==0){
				logger.info("Size of list is zero...returning null");
				return deals;
			}
			logger.info("Successfully returning deals");
			return deals;
		}catch (Exception e) {
			logger.error("some exception occured while fetching from DB ..returning null");
			return null;
		}
	}*/
	
	public List<Deal> getDealsByCategory(List<DealCategory> dealCategories) {
		
		List<String> dealTypes = new ArrayList<String>();
		
		for(DealCategory dealCategory : dealCategories){
			if(!dealTypes.contains(dealCategory.getDealType()))
				dealTypes.add(dealCategory.getDealType());
		}
		
		try{
			@SuppressWarnings("unchecked")
			List<Deal> allDeals = getEntityManager()
					.createQuery("select distinct d from Deal d")
					.getResultList();
			
			
			if(allDeals.size()==0){
				logger.info("Size of list is zero...returning null");
				return allDeals;
			}
			logger.info("alldeals not null");
			
			List<Deal> deals=new ArrayList<Deal>();
			for(Deal deal:allDeals) 
				for(String dealType : dealTypes)
					for(DealCategory dealCategory : deal.getDealCategories())
						if(dealCategory.getDealType().equals(dealType))
							if(!deals.contains(deal))
								deals.add(deal);
			
			
			if(deals.size()==0)
			{	
				logger.info("Size of list is zero...returning null");
				return deals;
			}
			logger.info("Successfully returning deals");
			return deals;
		}catch (Exception e) {
			logger.error("some exception occured while fetching from DB ..returning null");
			return null;
		}
	}
	

	public List<Deal> getDealsByCategoryGreaterThan(List<DealCategory> dealCategories,double min) {
		
		List<String> dealTypes = new ArrayList<String>();
		
		for(DealCategory dealCategory : dealCategories){
			if(!dealTypes.contains(dealCategory.getDealType()))
				dealTypes.add(dealCategory.getDealType());
		}
		
		try{
			@SuppressWarnings("unchecked")
			List<Deal> allDeals = getEntityManager()
					.createQuery("select distinct d from Deal d where d.dealPrice>=:min")
					.setParameter("min", min)
					.getResultList();
			
			
			if(allDeals.size()==0){
				logger.info("Size of list is zero...returning null");
				System.out.println("Size of list is zero...returning null");
				return allDeals;
			}
			logger.info("alldeals not null");
			System.out.println("all deals not null");
			
			List<Deal> deals=new ArrayList<Deal>();
			for(Deal deal:allDeals) 
				for(String dealType : dealTypes)
					for(DealCategory dealCategory : deal.getDealCategories())
						if(dealCategory.getDealType().equals(dealType))
							if(!deals.contains(deal))
								deals.add(deal);
			
			
			if(deals.size()==0)
			{	
				logger.info("Size of list is zero...returning null");
				return deals;
			}
			logger.info("Successfully returning deals");
			return deals;
		}catch (Exception e) {
			logger.error("some exception occured while fetching from DB ..returning null");
			System.out.println("some exception occured while fetching from DB ..returning null"+e.getMessage());
			return null;
		}
	}
	
	public List<Deal> getDealsByCategoryLessThan(List<DealCategory> dealCategories,double max) {
		
		List<String> dealTypes = new ArrayList<String>();
		
		for(DealCategory dealCategory : dealCategories){
			if(!dealTypes.contains(dealCategory.getDealType()))
				dealTypes.add(dealCategory.getDealType());
		}
		
		try{
			@SuppressWarnings("unchecked")
			List<Deal> allDeals = getEntityManager()
					.createQuery("select distinct d from Deal d where d.dealPrice<=:max")
					.setParameter("max", max)
					.getResultList();
			
			
			if(allDeals.size()==0){
				logger.info("Size of list is zero...returning null");
				return allDeals;
			}
			logger.info("alldeals not null");
			
			List<Deal> deals=new ArrayList<Deal>();
			for(Deal deal:allDeals) 
				for(String dealType : dealTypes)
					for(DealCategory dealCategory : deal.getDealCategories())
						if(dealCategory.getDealType()==dealType)
							if(!deals.contains(deal))
								deals.add(deal);
			
			
			if(deals.size()==0)
			{	
				logger.info("Size of list is zero...returning null");
				return deals;
			}
			logger.info("Successfully returning deals");
			return deals;
		}catch (Exception e) {
			logger.error("some exception occured while fetching from DB ..returning null");
			return null;
		}
	}

	public List<Deal> getDealsByCategoryBetween(List<DealCategory> dealCategories,double min,double max) {
		
		List<String> dealTypes = new ArrayList<String>();
		
		for(DealCategory dealCategory : dealCategories){
			if(!dealTypes.contains(dealCategory.getDealType()))
				dealTypes.add(dealCategory.getDealType());
		}
		
		try{
			@SuppressWarnings("unchecked")
			List<Deal> allDeals = getEntityManager()
					.createQuery("select distinct d from Deal d where d.dealPrice>=:min and d.dealPrice<=:max")
					.setParameter("min", min)
					.setParameter("max", max)
					.getResultList();
			
			
			if(allDeals.size()==0){
				logger.info("Size of list is zero...returning null");
				return allDeals;
			}
			logger.info("alldeals not null");
			
			List<Deal> deals=new ArrayList<Deal>();
			for(Deal deal:allDeals) 
				for(String dealType : dealTypes)
					for(DealCategory dealCategory : deal.getDealCategories())
						if(dealCategory.getDealType()==dealType)
							if(!deals.contains(deal))
								deals.add(deal);
			
			
			if(deals.size()==0)
			{	
				logger.info("Size of list is zero...returning null");
				return deals;
			}
			logger.info("Successfully returning deals");
			return deals;
		}catch (Exception e) {
			logger.error("some exception occured while fetching from DB ..returning null");
			return null;
		}
	}

	public List<Deal> getFeaturedDeals(boolean featured) {
		
		logger.info("DAO Layer getDealsByHotel");
		try{
		@SuppressWarnings("unchecked")
		List<Deal> deals = getEntityManager()
				.createQuery("select d from Deal d join d.dealAnalytics da where da.featured=:featured")
				.setParameter("featured", featured).getResultList();
		
		if(deals.size()==0){
			logger.info("Size of list is zero...returning null");
			return deals;
		}
		logger.info("Successfully returning deals");
			return deals;
		}catch (Exception e) {
			logger.error("some exception occured while fetching from DB ..returning null");
			return null;
		}
	}

	public List<Deal> getLatestAddedFeaturedDeals(boolean featured) {
		logger.info("DAO Layer getDealsByHotel");
		try{
		@SuppressWarnings("unchecked")
		List<Deal> deals = getEntityManager()
				.createQuery("select d from Deal d join d.dealAnalytics da " +
						"where da.featured=:featured and da.expired=false " +
						"order by d.dealPrice ASC, da.dateAdded DESC")
				.setParameter("featured", featured)
				.getResultList();
		
		if(deals.size()==0){
			logger.info("Size of list is zero...returning null");
			return deals;
		}
		logger.info("Successfully returning deals");
			return deals;
		}catch (Exception e) {
			logger.error("some exception occured while fetching from DB ..returning null");
			return null;
		}
	}

	public List<Deal> getSliderDeals(boolean slider) {
		logger.info("DAO Layer getSliderDeals");
		try{
		@SuppressWarnings("unchecked")
		List<Deal> deals = getEntityManager()
				.createQuery("select d from Deal d join d.dealAnalytics da " +
						"where da.slider=:slider and da.expired=false " +
						"order by d.dealPrice ASC, da.dateAdded DESC")
				.setParameter("slider", slider)
				.getResultList();
		
		if(deals.size()==0){
			logger.info("Size of list is zero...returning null");
			return deals;
		}
		logger.info("Successfully returning deals");
			return deals;
		}catch (Exception e) {
			logger.error("some exception occured while fetching from DB ..returning null");
			return null;
		}
	}
	
	public List<Deal> getNLatestAddedDeals(int howMany) {
		logger.info("DAO Layer getNLatestAddedDeals");
		try{
		@SuppressWarnings("unchecked")
		List<Deal> deals = getEntityManager()
				.createQuery("select d from Deal d join d.dealAnalytics da  where da.expired=false " +
						"order by d.dealPrice ASC,da.dateAdded DESC")
						.setFirstResult(0)
						.setMaxResults(howMany)
						.getResultList();
		
		if(deals.size()==0){
			logger.info("Size of list is zero...returning null");
			return deals;
		}
		logger.info("Successfully returning deals");
			return deals;
		}catch (Exception e) {
			logger.error("some exception occured while fetching from DB ..returning null");
			return null;
		}
	}
	
	public List<Deal> getDealsCorrespondingToQueryString(String name,
			double price, Long id, int pageNumber, int pageSize) {
		
		logger.info("getDealsCorrespondingToQueryString");
		EntityManager entityManager = getEntityManager();
		Query query = createQuery(entityManager, name, price, id);
		if(query==null)
			return new ArrayList<Deal>();
		else
		{
			try{
			@SuppressWarnings("unchecked")
			List<Deal> deals = query
							.setFirstResult((pageNumber-1)*pageSize)
							.setMaxResults(pageSize)
							.getResultList();
			
			if(deals.size()==0){
				logger.info("Size of list is zero...returning null");
				return deals;
			}
			logger.info("Successfully returning deals");
				return deals;
			}catch (Exception e) {
				logger.error("some exception occured while fetching from DB ..returning null");
				return new ArrayList<Deal>();
			}
		}
	}
	
	public int getCountOfDealsCorrespondingToQueryString(String name,
			double price, Long id) {
		
		logger.info("getDealsCorrespondingToQueryString");
		EntityManager entityManager = getEntityManager();
		Query query = createQueryCount(entityManager, name, price, id);
		if(query==null)
			return 0;
		else
		{
			try{
				
			long count = (Long)query.getSingleResult();
			
			logger.info("Successfully returning deals");
				return (int)count;
			}catch (Exception e) {
				logger.error("some exception occured while fetching from DB ..returning null");
				return 0;
			}
		}
	}

	private Query createQuery(EntityManager entityManager, String name, double price, Long id) {
		if(name.equals("")) {
			if(price==0) {
				if (id == 0) {
					return entityManager.createQuery("select d from Deal d join d.dealAnalytics da where da.expired=false order by d.dealPrice ASC");
				}
				else
				{
					ArrayList<Long> id1 = new ArrayList<Long>();
					id1.add(id);
					return entityManager
							.createQuery(
									"select d from Deal d join d.dealCategories dc join d.dealAnalytics da where  dc.id in :id and da.expired=false order by d.dealPrice ASC")
							.setParameter("id", id1);
				}
			}
			else
			{
				if (id == 0) {
					return entityManager
					.createQuery(
							"select d from Deal d join d.dealAnalytics da where da.expired=false and d.dealPrice<=:dealPrice order by d.dealPrice ASC")
					.setParameter("dealPrice", price);
				}
				else
				{	ArrayList<Long> id1 = new ArrayList<Long>();
					id1.add(id);
					return entityManager
							.createQuery(
									"select d from Deal d join d.dealCategories dc join d.dealAnalytics da where dc.id in :id and d.dealPrice<=:dealPrice and da.expired=false order by d.dealPrice ASC")
							.setParameter("id", id1).setParameter("dealPrice", price);
				}
			}
		}
		else {
			
			if(price==0) {
				if (id == 0) {
					
					return entityManager
					.createQuery(
							"select d from Deal d join d.hotel dh join d.dealAnalytics da where dh.name like :name and da.expired=false order by d.dealPrice ASC")
					.setParameter("name", '%'+name+'%');
				}
				else
				{	ArrayList<Long> id1 = new ArrayList<Long>();
					id1.add(id);
					return entityManager
							.createQuery(
									"select d from Deal d join d.dealCategories dc join d.hotel dh join d.dealAnalytics da where  dc.id in :id and dh.name like :name and da.expired=false order by d.dealPrice ASC")
							.setParameter("id", id1).setParameter("name", '%'+name+'%');
				}
			}
			else
			{
				if (id == 0) {
					return entityManager
					.createQuery(
							"select d from Deal d join d.hotel dh join d.dealAnalytics da where d.dealPrice<=:dealPrice and dh.name like :name and da.expired=false order by d.dealPrice ASC")
					.setParameter("dealPrice", price).setParameter("name", '%'+name+'%');
				}
				else
				{	ArrayList<Long> id1 = new ArrayList<Long>();
					id1.add(id);
					return entityManager
							.createQuery(
									"select d from Deal d join d.dealCategories dc join d.hotel dh join d.dealAnalytics da where  dc.id in :id and d.dealPrice<=:dealPrice and dh.name like :name and da.expired=false order by d.dealPrice ASC")
							.setParameter("id", id1).setParameter("dealPrice", price).setParameter("name", '%'+name+'%');
				}
			}
		}
	}

	private Query createQueryCount(EntityManager entityManager, String name, double price, Long id) {
		if(name.equals("")) {
			if(price==0) {
				if (id == 0) {
					return entityManager.createQuery("select count(d.id) from Deal d");
				}
				else
				{
					ArrayList<Long> id1 = new ArrayList<Long>();
					id1.add(id);
					return entityManager
							.createQuery(
									"select count(d.id) from Deal d join d.dealCategories dc where  dc.id in :id")
							.setParameter("id", id1);
				}
			}
			else
			{
				if (id == 0) {
					return entityManager
					.createQuery(
							"select count(d.id) from Deal d where dealPrice<=:dealPrice")
					.setParameter("dealPrice", price);
				}
				else
				{	ArrayList<Long> id1 = new ArrayList<Long>();
					id1.add(id);
					return entityManager
							.createQuery(
									"select count(d.id) from Deal d join d.dealCategories dc where dc.id in :id and d.dealPrice<=:dealPrice")
							.setParameter("id", id1).setParameter("dealPrice", price);
				}
			}
		}
		else {
			
			if(price==0) {
				if (id == 0) {
					
					return entityManager
					.createQuery(
							"select count(d.id) from Deal d join d.hotel dh where dh.name like :name ")
					.setParameter("name", '%'+name+'%');
				}
				else
				{	ArrayList<Long> id1 = new ArrayList<Long>();
					id1.add(id);
					return entityManager
							.createQuery(
									"select count(d.id) from Deal d join d.dealCategories dc join d.hotel dh where  dc.id in :id and dh.name like :name ")
							.setParameter("id", id1).setParameter("name", '%'+name+'%');
				}
			}
			else
			{
				if (id == 0) {
					return entityManager
					.createQuery(
							"select count(d.id) from Deal d join d.hotel dh where d.dealPrice<=:dealPrice and dh.name like :name ")
					.setParameter("dealPrice", price).setParameter("name", '%'+name+'%');
				}
				else
				{	ArrayList<Long> id1 = new ArrayList<Long>();
					id1.add(id);
					return entityManager
							.createQuery(
									"select count(d.id) from Deal d join d.dealCategories dc join d.hotel dh where  dc.id in :id and d.dealPrice<=:dealPrice and dh.name like :name ")
							.setParameter("id", id1).setParameter("dealPrice", price).setParameter("name", '%'+name+'%');
				}
			}
		}
	}
	
	public List<Deal> findAll(int pageNumber, int pageSize) {
		logger.info("DAO Layer findAll");
		try{
		@SuppressWarnings("unchecked")
		List<Deal> deals = getEntityManager()
				.createQuery("from Deal")
						.setFirstResult((pageNumber-1)*pageSize)
							.setMaxResults(pageSize)
							.getResultList();
		
		if(deals.size()==0){
			logger.info("Size of list is zero...returning null");
			return deals;
		}
		logger.info("Successfully returning deals");
			return deals;
		}catch (Exception e) {
			logger.error("some exception occured while fetching from DB ..returning null");
			return new ArrayList<Deal>();
		}
	}

	public int getDealCount() {

		logger.info("DAO Layer findAll");
		try{
		@SuppressWarnings("unchecked")
		long count = (Long)getEntityManager()
				.createQuery("select count(d.id) from Deal d")
				.getSingleResult();
		
		return (int)count;
		}catch (Exception e) {
			logger.error("some exception occured while fetching from DB ..returning null");
			return 0;
		}
	}

}
