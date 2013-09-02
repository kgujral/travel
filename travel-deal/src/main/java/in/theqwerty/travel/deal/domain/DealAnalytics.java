package in.theqwerty.travel.deal.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DealAnalytics implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private boolean featured;
	
	private boolean slider;
	
	private Date dateAdded;
	
	private Date dateDeleted;
	
	private boolean expired;
	
	private int boughtCount;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isFeatured() {
		return featured;
	}

	public void setFeatured(boolean featured) {
		this.featured = featured;
	}

	public boolean isSlider() {
		return slider;
	}

	public void setSlider(boolean slider) {
		this.slider = slider;
	}

	public Date getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}

	public Date getDateDeleted() {
		return dateDeleted;
	}

	public void setDateDeleted(Date dateDeleted) {
		this.dateDeleted = dateDeleted;
	}

	public boolean isExpired() {
		return expired;
	}

	public void setExpired(boolean expired) {
		this.expired = expired;
	}

	public int getBoughtCount() {
		return boughtCount;
	}

	public void setBoughtCount(int boughtCount) {
		this.boughtCount = boughtCount;
	}
	public void setBoughtCount(String boughtCount) {
		this.boughtCount = boughtCount.length() == 0 ? 0:Integer.parseInt(boughtCount);
	}
	
	/**
	 * Default contructor to set the dateAdded to current 
	 * SERVER time.
	 */
	public DealAnalytics() {
		dateAdded = new Date();
	}

	@Override
	public String toString() {
		return "DealAnalytics [id=" + id + ", featured=" + featured
				+ ", slider=" + slider + ", dateAdded=" + dateAdded
				+ ", dateDeleted=" + dateDeleted + ", expired=" + expired
				+ ", boughtCount=" + boughtCount + "]";
	}
	
}
