package in.theqwerty.travel.user.domain;

import in.theqwerty.travel.core.util.HashCodeUtil;
import in.theqwerty.travel.deal.domain.Deal;
import in.theqwerty.travel.user.services.Constants;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class OrderDetails {
	
	@Id
	private Long id;
	@OneToOne
	private Deal deal;
	private Date date; 
	
	// only values allowed are (pending, completed, batch, cancelled)
	private String status = Constants.ORDER_PENDING; //default value
	@ManyToOne
	private User user;
	
	private double amount;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Deal getDeal() {
		return deal;
	}

	public void setDeal(Deal deal) {
		this.deal = deal;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null) {
			return false;
		}
		if(! (obj instanceof OrderDetails)) {
			return false;
		}
		OrderDetails temp = (OrderDetails) obj;
		if( temp.getId().equals(this.getId()) )
			return true;
		
		return false;
	}
	
	@Override
	public int hashCode() {
		int result = HashCodeUtil.SEED;
		result = HashCodeUtil.hash(result, this.id);
		return result;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "OrderDetails [id=" + id + ", deal=" + deal + ", date=" + date
				+ ", status=" + status + ", user=" + user + ", amount="
				+ amount + "]";
	}
	
	
}
