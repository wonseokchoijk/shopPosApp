package dao;

public class GoodsListSearchKeywordsDto {

	private String goodsNo;
	
	private String color;
	
	private String memo;
	
	private String goodsName;
	
	private String fromYear;
	
	private String fromMonth;
	
	private String fromDay;
	
	private String toYear;
	
	private String toMonth;
	
	private String toDay;
	
	private String kind;

	public String getGoodsNo() {
		return goodsNo != null ? goodsNo : "";
	}

	public void setGoodsNo(String goodsNo) {
		this.goodsNo = goodsNo;
	}

	public String getColor() {
		return color != null ? color : "";
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getMemo() {
		return memo != null ? memo : "";
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getGoodsName() {
		return goodsName != null ? goodsName : "";
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getFromYear() {
		return fromYear != null ? fromYear : "";
	}

	public void setFromYear(String fromYear) {
		this.fromYear = fromYear;
	}

	public String getFromMonth() {
		return fromMonth != null ? fromMonth : "";
	}

	public void setFromMonth(String fromMonth) {
		this.fromMonth = fromMonth;
	}

	public String getFromDay() {
		return fromDay != null ? fromDay : "";
	}

	public void setFromDay(String fromDay) {
		this.fromDay = fromDay;
	}

	public String getToYear() {
		return toYear != null ? toYear : "";
	}

	public void setToYear(String toYear) {
		this.toYear = toYear;
	}

	public String getToMonth() {
		return toMonth != null ? toMonth : "";
	}

	public void setToMonth(String toMonth) {
		this.toMonth = toMonth;
	}

	public String getToDay() {
		return toDay != null ? toDay : "";
	}

	public void setToDay(String toDay) {
		this.toDay = toDay;
	}

	public String getKind() {
		return kind != null ? kind : "";
	}

	public void setKind(String kind) {
		this.kind = kind;
	}
}
