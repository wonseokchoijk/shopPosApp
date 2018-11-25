package bean;

import java.sql.Date;

public class GoodsListBean {

	private Long id;
	private Integer bunryu;
	private String name;
	private String kind;
	private String color;
	private Long buyPrice;
	private Long sellHopePrice;
	private Long sellPrice;
	private String place;
	private String barcode;
	private String memo;
	private Character sellFlg;
	private Character delFlg;
	private Date buyDate;
	private Date sellDate;
	private Date updated;
	private Date inserted;

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
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Long getBuyPrice() {
		return buyPrice;
	}
	public void setBuyPrice(Long buyPrice) {
		this.buyPrice = buyPrice;
	}
	public Long getSellHopePrice() {
		return sellHopePrice;
	}
	public void setSellHopePrice(Long sellHopePrice) {
		this.sellHopePrice = sellHopePrice;
	}
	public Long getSellPrice() {
		return sellPrice;
	}
	public void setSellPrice(Long sellPrice) {
		this.sellPrice = sellPrice;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getBarcode() {
		return barcode;
	}
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public Character getSellFlg() {
		return sellFlg;
	}
	public void setSellFlg(Character sellFlg) {
		this.sellFlg = sellFlg;
	}
	public Character getDelFlg() {
		return delFlg;
	}
	public void setDelFlg(Character delFlg) {
		this.delFlg = delFlg;
	}
	public Date getBuyDate() {
		return buyDate;
	}
	public void setBuyDate(Date buyDate) {
		this.buyDate = buyDate;
	}
	public Date getSellDate() {
		return sellDate;
	}
	public void setSellDate(Date sellDate) {
		this.sellDate = sellDate;
	}
	public Date getUpdated() {
		return updated;
	}
	public void setUpdated(Date updated) {
		this.updated = updated;
	}
	public Date getInserted() {
		return inserted;
	}
	public void setInserted(Date inserted) {
		this.inserted = inserted;
	}
	public Integer getBunryu() {
		return bunryu;
	}
	public void setBunryu(Integer bunryu) {
		this.bunryu = bunryu;
	}


}
