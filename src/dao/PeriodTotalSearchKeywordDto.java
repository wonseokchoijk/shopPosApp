package dao;

public class PeriodTotalSearchKeywordDto {

	private String buyDateFromYear;
	
	private String buyDateFromMonth;
	
	private String buyDateFromDay;
	
	private String buyDateToYear;
	
	private String buyDateToMonth;
	
	private String buyDateToDay;
	
	private String goodsNo;
	
	private String kind;
	
	private String memo;
	
	private String goodsName;
	
	private String color;
	
	private boolean buyFlag = false;
	
	private boolean sellFlag = false;
	
	private boolean inFlag = false;
	
	private boolean outFlag = false;

	public String getBuyDateFromYear() {
		return buyDateFromYear != null ? buyDateFromYear : "";
	}

	public void setBuyDateFromYear(String buyDateFromYear) {
		this.buyDateFromYear = buyDateFromYear;
	}

	public String getBuyDateFromMonth() {
		return buyDateFromMonth != null ? buyDateFromMonth : "";
	}

	public void setBuyDateFromMonth(String buyDateFromMonth) {
		this.buyDateFromMonth = buyDateFromMonth;
	}

	public String getBuyDateFromDay() {
		return buyDateFromDay != null ? buyDateFromDay : "";
	}

	public void setBuyDateFromDay(String buyDateFromDay) {
		this.buyDateFromDay = buyDateFromDay;
	}

	public String getBuyDateToYear() {
		return buyDateToYear != null ? buyDateToYear : "";
	}

	public void setBuyDateToYear(String buyDateToYear) {
		this.buyDateToYear = buyDateToYear;
	}

	public String getBuyDateToMonth() {
		return buyDateToMonth != null ? buyDateToMonth : "";
	}

	public void setBuyDateToMonth(String buyDateToMonth) {
		this.buyDateToMonth = buyDateToMonth;
	}

	public String getBuyDateToDay() {
		return buyDateToDay != null ? buyDateToDay : "";
	}

	public void setBuyDateToDay(String buyDateToDay) {
		this.buyDateToDay = buyDateToDay;
	}

	public String getGoodsNo() {
		return goodsNo != null ? goodsNo : "";
	}

	public void setGoodsNo(String goodsNo) {
		this.goodsNo = goodsNo;
	}

	public String getKind() {
		return kind != null ? kind : "";
	}

	public void setKind(String kind) {
		this.kind = kind;
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

	public String getColor() {
		return color != null ? color : "";
	}

	public void setColor(String color) {
		this.color = color;
	}

	public boolean isBuyFlag() {
		return buyFlag;
	}

	public void setBuyFlag(boolean buyFlag) {
		this.buyFlag = buyFlag;
	}

	public boolean isSellFlag() {
		return sellFlag;
	}

	public void setSellFlag(boolean sellFlag) {
		this.sellFlag = sellFlag;
	}

	public boolean isInFlag() {
		return inFlag;
	}

	public void setInFlag(boolean inFlag) {
		this.inFlag = inFlag;
	}

	public boolean isOutFlag() {
		return outFlag;
	}

	public void setOutFlag(boolean outFlag) {
		this.outFlag = outFlag;
	}
}
