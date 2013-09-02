package in.theqwerty.travel.webapp.actions;

import in.theqwerty.travel.core.services.MailService;
import in.theqwerty.travel.core.services.Random;
import in.theqwerty.travel.deal.domain.Deal;
import in.theqwerty.travel.user.api.OrderDetailsDao;
import in.theqwerty.travel.user.api.UserDao;
import in.theqwerty.travel.user.domain.OrderDetails;
import in.theqwerty.travel.user.domain.User;
import in.theqwerty.travel.user.services.Constants;
import in.theqwerty.travel.webapp.cache.PaymentConstants;
import in.theqwerty.travel.webapp.service.CheckSum;

import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;

@SuppressWarnings("serial")
public class CheckoutAction extends ActionSupport {

	private User user;
	
	private String quantity;
	private Deal deal;
	@Resource
	private OrderDetailsDao orderDetailsDao;
	
	@Resource
	private MailService mailService;
	
	@Resource
	private UserDao userDao;
	
	private String Order_Id;
	private String Checksum;
	private String Redirect_Url;
	private String Merchant_Id;
	private String billing_cust_name;
	private String amount;
	private String billing_cust_tel;
	private String billing_cust_email;
	
	public String getQuantity() {
		return quantity;
	}
	public Deal getDeal() {
		return deal;
	}
	public void setDeal(Deal deal) {
		this.deal = deal;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getOrder_Id() {
		return Order_Id;
	}
	public void setOrder_Id(String order_Id) {
		Order_Id = order_Id;
	}
	public String getChecksum() {
		return Checksum;
	}
	public void setChecksum(String checksum) {
		Checksum = checksum;
	}
	public String getRedirect_Url() {
		return Redirect_Url;
	}
	public void setRedirect_Url(String redirect_Url) {
		Redirect_Url = redirect_Url;
	}
	public String getMerchant_Id() {
		return Merchant_Id;
	}
	public void setMerchant_Id(String merchant_Id) {
		Merchant_Id = merchant_Id;
	}
	public String getBilling_cust_name() {
		return billing_cust_name;
	}
	public void setBilling_cust_name(String billing_cust_name) {
		this.billing_cust_name = billing_cust_name;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getBilling_cust_tel() {
		return billing_cust_tel;
	}
	public void setBilling_cust_tel(String billing_cust_tel) {
		this.billing_cust_tel = billing_cust_tel;
	}
	public String getBilling_cust_email() {
		return billing_cust_email;
	}
	public void setBilling_cust_email(String billing_cust_email) {
		this.billing_cust_email = billing_cust_email;
	}
	@Override
	public String execute() throws Exception {
		staticCode();
		OrderDetails order = createOrder(Constants.ORDER_PENDING);
		orderDetailsDao.persist(order);
 		return SUCCESS;
	}

	private void staticCode() {
		go();
		deal = (Deal)session.get("deal");
		user();
		amount = String.valueOf(deal.getDealPrice() * Integer.parseInt(quantity));
		billing_cust_name = user.getFirstName() + " " + user.getLastName();
		billing_cust_tel = user.getPhoneNumber();
		billing_cust_email = user.getEmail();
		Merchant_Id = PaymentConstants.MERCHANT_ID;
		Redirect_Url = PaymentConstants.REDIRECT_URL;
		Order_Id = orderDetailsDao.getNextOrderId().toString();
		Checksum = CheckSum.getChecksum(Merchant_Id, Order_Id, amount, Redirect_Url, PaymentConstants.WORKING_KEY);
	}
	
	private OrderDetails createOrder(String status) {
		OrderDetails temp = new OrderDetails();
		temp.setAmount(Double.valueOf(amount));
		temp.setDate(new Date());
		temp.setDeal(deal);
		temp.setId(Long.valueOf(Order_Id));
		temp.setUser(user);
		temp.setStatus(status);
		return temp;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	private void user() {
		if(session.containsKey("user")) {
			user = (User)session.get("user");
		}
		else if(user != null && user.getEmail() != null) {
			persistUser();
			session.put("user", user);
		}
		else {
			user = null;
		}
	}
	private void persistUser() {
		if(user.getName() == null || user.getName().isEmpty()) {
			user.setName(user.getEmail());
			String pass = String.valueOf(Random.rChar()) + String.valueOf(Random.rChar()) + String.valueOf(Random.rChar()) +String.valueOf(Random.rChar())+String.valueOf(Random.rChar());
			user.setPassword(pass);
			user.setRole("user");
			if(userDao.findById(user.getName()) == null) {
				userDao.persist(user);
				String text = 	"Dear "+user.getFirstName()+", \nThank you for using www.tripexotica.com!\n"+
								"Your login credentials for all furthur transactions are as follows:\n\n\n"+
								"User ID: "+user.getName()+"\n"+
								"Password: "+user.getPassword()+"\n\n"+
								"Regards\nTeam TripExotica\nwww.tripexotica.com";
				mailService.sendMail(user.getEmail(), "Welcome to tripexotica!", text, "TripExotica Team");
			}
		}
	}
}
