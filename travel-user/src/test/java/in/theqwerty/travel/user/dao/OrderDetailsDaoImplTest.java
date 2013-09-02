package in.theqwerty.travel.user.dao;

import in.theqwerty.travel.user.api.OrderDetailsDao;
import in.theqwerty.travel.user.api.UserDao;
import in.theqwerty.travel.user.domain.OrderDetails;
import in.theqwerty.travel.user.domain.User;
import in.theqwerty.travel.user.services.Constants;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import junit.framework.Assert;

import org.junit.Test;

public class OrderDetailsDaoImplTest extends AbstractUserTest{

	@Resource
	private OrderDetailsDao orderDetailsDao;
	
	@Resource
	private UserDao userDao;
	
	@Test
	public void shouldGetOrders() {
		List<User> users = createUsers();
		createOrders(users);
		List<OrderDetails> orderList = orderDetailsDao.getOrders(users.get(0));
		junit.framework.Assert.assertEquals(1, orderList.size());
		
		
	}
	
	private void createOrders(List<User> users) {
		OrderDetails orderDetails=null;
		for (User user : users) {
			orderDetails = new OrderDetails();
			orderDetails.setId(orderDetailsDao.getNextOrderId());
			orderDetails.setUser(user);
			orderDetails.setDate(new Date());
			orderDetailsDao.persist(orderDetails);
		}
	}

	private List<User> createUsers() {
		ArrayList<User> users = new ArrayList<User>();
		users.add(createUser("Vijay", "Vijay", "adminobviously"));
		users.add(createUser("Karan", "Karan", "adminobviously"));
		users.add(createUser("Lakshay", "Lakshay", "adminobviously"));
		users.add(createUser("Anand", "Anand", "adminobviously"));
		
		for (User user : users) 
			userDao.persist(user);
		
		return users;
	}
	
	private User createUser(String name,String password,String role) {
		User user = new User();
		user.setName(name);
		user.setPassword(password);
		user.setRole(role);
		return user;
	}
	
	@Test
	public void testGetMaxOrderId() {
		Assert.assertEquals(orderDetailsDao.getNextOrderId() ,orderDetailsDao.getNextOrderId());
		Assert.assertEquals(Constants.ORDER_OFFSET ,orderDetailsDao.getNextOrderId());
		createOrders(createUsers());
		Long temp = Constants.ORDER_OFFSET + 4L;
		Assert.assertEquals(temp ,orderDetailsDao.getNextOrderId());
	}
}
