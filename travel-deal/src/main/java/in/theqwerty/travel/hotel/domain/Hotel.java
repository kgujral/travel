package in.theqwerty.travel.hotel.domain;

import java.io.Serializable;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Hotel implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String name;
	
	private String address;
	
	private String locality;
	
	private String city;
	
	private String state;
	
	private String country;
	
	private String countryCode;
	
	private String zip;
	
	private double highRate;
	
	private double lowRate;
	
	private String currency;
	
	private String rateDisclaimer;
	
	private ArrayList<String> phoneNumbers;
	
	private ArrayList<String> faxNumbers;
	
	private ArrayList<String> emails;
	
	private ArrayList<String> websites;
	
	private String chain;
	
	private String overview;
	
	private ArrayList<String> imageUrls;
	
	private String ratingAgency;
	
	private double rating;
	
	@Override
	public String toString() {
		return name.toString()+", "+country.toString();
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public double getHighRate() {
		return highRate;
	}

	public void setHighRate(double highRate) {
		this.highRate = highRate;
	}

	public double getLowRate() {
		return lowRate;
	}

	public void setLowRate(double lowRate) {
		this.lowRate = lowRate;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getRateDisclaimer() {
		return rateDisclaimer;
	}

	public void setRateDisclaimer(String rateDisclaimer) {
		this.rateDisclaimer = rateDisclaimer;
	}

	public String getChain() {
		return chain;
	}

	public void setChain(String chain) {
		this.chain = chain;
	}

	public String getOverview() {
		return overview;
	}

	public void setOverview(String overview) {
		this.overview = overview;
	}

	public String getRatingAgency() {
		return ratingAgency;
	}

	public void setRatingAgency(String ratingAgency) {
		this.ratingAgency = ratingAgency;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public ArrayList<String> getPhoneNumbers() {
		return phoneNumbers;
	}

	public void setPhoneNumbers(ArrayList<String> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}

	public ArrayList<String> getFaxNumbers() {
		return faxNumbers;
	}

	public void setFaxNumbers(ArrayList<String> faxNumbers) {
		this.faxNumbers = faxNumbers;
	}

	public ArrayList<String> getEmails() {
		return emails;
	}

	public void setEmails(ArrayList<String> emails) {
		this.emails = emails;
	}

	public ArrayList<String> getWebsites() {
		return websites;
	}

	public void setWebsites(ArrayList<String> websites) {
		this.websites = websites;
	}

	public ArrayList<String> getImageUrls() {
		return imageUrls;
	}

	public void setImageUrls(ArrayList<String> imageUrls) {
		this.imageUrls = imageUrls;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj==null)
			return false;
		if(!(obj instanceof Hotel))
			return false;
		if(id==((Hotel)obj).getId())
			return true;
		return true;
	}
}
