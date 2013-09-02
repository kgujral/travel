package in.theqwerty.travel.webapp.actions;

import java.util.Date;

import javax.annotation.Resource;

import in.theqwerty.travel.deal.domain.Deal;
import in.theqwerty.travel.user.api.OrderDetailsDao;
import in.theqwerty.travel.user.domain.OrderDetails;
import in.theqwerty.travel.user.domain.User;
import in.theqwerty.travel.user.services.Constants;
import in.theqwerty.travel.webapp.cache.PaymentConstants;
import in.theqwerty.travel.webapp.service.CheckSum;


@SuppressWarnings("serial")
public class ReturnAction extends ActionSupport {

	//Parameter list Returned by CCAvenue
	private String Order_Id;
	private String Amount;
	private String Merchant_Id;
	private String AuthDesc;
	private String Checksum;
	//End of parameter list returned by CCAvenue	
	
	@Resource
	private OrderDetailsDao orderDetailsDao;
	

	public String execute() throws Exception {
		trimAll();
		Checksum = CheckSum.verifyChecksum(Merchant_Id, Order_Id , Amount,AuthDesc,PaymentConstants.WORKING_KEY,Checksum);

		if(Checksum.equals("true") && AuthDesc.equals("Y")) {
			//Here you need to put in the routines for a successful 
			//transaction such as sending an email to customer,
			//setting database status etc.
			
			OrderDetails order = createOrder(Constants.ORDER_COMPLETED);
			orderDetailsDao.merge(order);
			return SUCCESS;
			
		}
		else if(Checksum.equals("true") && AuthDesc.equals("B")) {
			
			//Here you need to put in the routines/e-mail for a  "Batch Processing" order
			//This is only if payment for this transaction has been made by an American Express Card
			//since American Express authorisation status is available only after 5-6 hours by mail from ccavenue and at the "View Pending Orders"
			OrderDetails order = createOrder(Constants.ORDER_BATCH);
			orderDetailsDao.merge(order);
			return SUCCESS;
		}
		else if(Checksum.equals("true") && AuthDesc.equals("N")) {
			//Here you need to put in the routines for a failed
			//transaction such as sending an email to customer
			//setting database status etc etc
			OrderDetails order = createOrder(Constants.ORDER_CANCELLED);
			orderDetailsDao.merge(order);
			return ERROR;
		}

		return INPUT;
	}
	public String getOrder_Id() {
		return Order_Id;
	}
	public void setOrder_Id(String order_Id) {
		Order_Id = order_Id;
	}
	public String getAmount() {
		return Amount;
	}
	public void setAmount(String amount) {
		Amount = amount;
	}
	public String getMerchant_Id() {
		return Merchant_Id;
	}
	public void setMerchant_Id(String merchant_Id) {
		Merchant_Id = merchant_Id;
	}
	public String getAuthDesc() {
		return AuthDesc;
	}
	public void setAuthDesc(String authDesc) {
		AuthDesc = authDesc;
	}
	public String getChecksum() {
		return Checksum;
	}
	public void setChecksum(String checksum) {
		Checksum = checksum;
	}
	private void trimAll() {
		Order_Id = Order_Id.trim();
		Amount = Amount.trim();
		Merchant_Id = Merchant_Id.trim();
		AuthDesc = AuthDesc.trim();
		Checksum = Checksum.trim();		
	}
	private OrderDetails createOrder(String status) {
		User user = (User)session.get("user");
		Deal deal = (Deal)session.get("deal");
		OrderDetails temp = new OrderDetails();
		temp.setAmount(Double.valueOf(Amount));
		temp.setDate(new Date());
		temp.setDeal(deal);
		temp.setId(Long.valueOf(Order_Id));
		temp.setUser(user);
		temp.setStatus(status);
		return temp;
	}
}
