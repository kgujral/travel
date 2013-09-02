package in.theqwerty.travel.deal.domain;

import in.theqwerty.travel.hotel.domain.Hotel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Deal implements Serializable {
	

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String name;
	
	@Column(length=10000)
	private String shortDescription;
	
	@Column(length=10000)
	private String longDescription;
	
	@Column(length=10000)
	private String inclusions;
	
	@Column(length=10000)
	private String exclusions;
	
	private double dealPrice;
	
	private double oldPrice;
	
	private ArrayList<String> imageUrls;
	
	@ManyToMany(fetch=FetchType.EAGER)
	private List<DealCategory> dealCategories;

	@OneToOne
	private Hotel hotel;
	
	@OneToOne(cascade=CascadeType.ALL)
	private DealAnalytics dealAnalytics;
	
	
	public DealAnalytics getDealAnalytics() {
		return dealAnalytics;
	}

	public void setDealAnalytics(DealAnalytics dealAnalytics) {
		this.dealAnalytics = dealAnalytics;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getDealPrice() {
		return dealPrice;
	}

	public void setDealPrice(double dealPrice) {
		this.dealPrice = dealPrice;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	
	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getLongDescription() {
		return longDescription;
	}

	public void setLongDescription(String longDescription) {
		this.longDescription = longDescription;
	}

	public String getInclusions() {
		return inclusions;
	}

	public void setInclusions(String inclusions) {
		this.inclusions = inclusions;
	}

	public String getExclusions() {
		return exclusions;
	}

	public void setExclusions(String exclusions) {
		this.exclusions = exclusions;
	}

	public ArrayList<String> getImageUrls() {
		return imageUrls;
	}

	public void setImageUrls(ArrayList<String> imageUrls) {
		this.imageUrls = imageUrls;
	}

	public List<DealCategory> getDealCategories() {
		return dealCategories;
	}

	public void setDealCategories(List<DealCategory> dealCategories) {
		this.dealCategories = dealCategories;
	}
	
	public double getOldPrice() {
		return oldPrice;
	}

	public void setOldPrice(double oldPrice) {
		this.oldPrice = oldPrice;
	}

	@Override
	public boolean equals(Object o){
		if(o == null)
			return false;
		if(!(o instanceof Deal))
			return false;
		Deal obj=(Deal)o;
		if(!(hotel==obj.getHotel()))
			return false;
		for(int i=0;i<dealCategories.size();i++)
			if(!(dealCategories.get(i)==obj.getDealCategories().get(i)))
				return false;
		return true;
	}

	@Override
	public String toString() {
		return "Deal [id=" + id + ", name=" + name + ", shortDescription="
				+ shortDescription + ", longDescription=" + longDescription
				+ ", inclusions=" + inclusions + ", exclusions=" + exclusions
				+ ", dealPrice=" + dealPrice + ", oldPrice=" + oldPrice
				+ ", imageUrls=" + imageUrls + ", dealCategories="
				+ dealCategories + ", hotel=" + hotel + ", dealAnalytics="
				+ dealAnalytics + "]";
	}
}
