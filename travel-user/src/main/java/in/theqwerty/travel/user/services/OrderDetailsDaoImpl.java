package in.theqwerty.travel.user.services;

import in.theqwerty.travel.core.services.GenericDaoImpl;
import in.theqwerty.travel.user.api.OrderDetailsDao;
import in.theqwerty.travel.user.domain.OrderDetails;
import in.theqwerty.travel.user.domain.User;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository("orderDetailsDao")
public class OrderDetailsDaoImpl extends GenericDaoImpl<Long, OrderDetails> implements OrderDetailsDao {

	private static Logger logger = LoggerFactory.getLogger("OrderDetailsDaoImpl");
	
	public List<OrderDetails> getOrders(User user) {
		logger.info("DAO Layer getOrders");
		try{
		@SuppressWarnings("unchecked")
		List<OrderDetails> orderList = getEntityManager()
				.createQuery("from OrderDetails where user=:user")
				.setParameter("user", user).getResultList();

		if(orderList==null || orderList.size()==0){
			System.out.println("Size of list is zero...returning empty list");
			logger.info("Size of list is zero...returning empty list");
			return new ArrayList<OrderDetails>();
		}
		logger.info("Successfully returning deals");
			return orderList;
		}catch (Exception e) {
			System.out.println("some exception occured while fetching from DB ..returning null");
			logger.error("some exception occured while fetching from DB ..returning null");
			return new ArrayList<OrderDetails>();
		}
	}

	public Long getNextOrderId() {
		logger.info("DAO Layer getNextOrderId");
		try{
		Long result = (Long) getEntityManager()
				.createQuery("select max(id) from OrderDetails")
				.getSingleResult();
				

		if(result == null || result == 0){
			return Constants.ORDER_OFFSET;
		}
		logger.info("Successfully returning max order");
			return 1L + result;
		}catch (Exception e) {
			System.out.println("some exception occured while fetching from DB ..returning null");
			logger.error("some exception occured while fetching from DB ..returning null");
			return Constants.ORDER_OFFSET;
		}
	}
}
