package in.theqwerty.travel.deal.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DealCategory implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String dealType;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDealType() {
		return dealType;
	}

	public void setDealType(String dealType) {
		this.dealType = dealType;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj==null)
			return false;
		if(!(obj instanceof DealCategory))
			return false;
		DealCategory dealCategory = (DealCategory)obj;
		if(!(dealType.equals(dealCategory.getDealType())))
			return false;
		
		return true;
	}

	@Override
	public String toString() {
		return "DealCategory [id=" + id + ", dealType=" + dealType + "]";
	}
}
