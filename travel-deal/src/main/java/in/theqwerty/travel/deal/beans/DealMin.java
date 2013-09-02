package in.theqwerty.travel.deal.beans;

public class DealMin {
	
	private String id;
	private String name;
	private String imgUrl;
	private String shortDesc;
	private String longDesc;
	private String oldPrice;
	private String dealPrice;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public String getShortDesc() {
		return shortDesc;
	}
	public void setShortDesc(String shortDesc) {
		this.shortDesc = shortDesc;
	}
	public String getLongDesc() {
		return longDesc;
	}
	public void setLongDesc(String longDesc) {
		this.longDesc = longDesc;
	}
	public String getOldPrice() {
		return oldPrice;
	}
	public void setOldPrice(String oldPrice) {
		this.oldPrice = oldPrice;
	}
	public String getDealPrice() {
		return dealPrice;
	}
	public void setDealPrice(String dealPrice) {
		this.dealPrice = dealPrice;
	}
	@Override
	public String toString() {
		return "DealMin [id=" + id + ", name=" + name + ", imgUrl=" + imgUrl
				+ ", shortDesc=" + shortDesc + ", longDesc=" + longDesc
				+ ", oldPrice=" + oldPrice + ", dealPrice=" + dealPrice + "]";
	}

}
