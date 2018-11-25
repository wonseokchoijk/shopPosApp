package bean;

import java.sql.Date;

// 상품, 지출, 소득 등록 및 열람 테이블 표시용 빈
public class PeriodTotalBean {

	private Long no;
	private Integer bunryu;
	private String name;
	private String kind;
	private String color;
	private String memo;
	private Long buyPrice;
	private Long sellHopePrice;
	private Long sellPrice;
	private Character sellFlg;
	private String place;
	private Date date;

	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
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
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
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
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Integer getBunryu() {
		return bunryu;
	}
	public void setBunryu(Integer bunryu) {
		this.bunryu = bunryu;
	}
	public Character getSellFlg() {
		return sellFlg;
	}
	public void setSellFlg(Character sellFlg) {
		this.sellFlg = sellFlg;
	}
}
