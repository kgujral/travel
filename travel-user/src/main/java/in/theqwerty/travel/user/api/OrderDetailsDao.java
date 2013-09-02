package in.theqwerty.travel.user.api;

import java.util.List;

import in.theqwerty.travel.core.api.GenericDao;
import in.theqwerty.travel.user.domain.OrderDetails;
import in.theqwerty.travel.user.domain.User;

public interface OrderDetailsDao extends GenericDao<Long, OrderDetails>{

	List<OrderDetails> getOrders(User user);
	Long getNextOrderId ();
}
