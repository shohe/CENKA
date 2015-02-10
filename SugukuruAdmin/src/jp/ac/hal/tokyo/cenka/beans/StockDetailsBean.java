package jp.ac.hal.tokyo.cenka.beans;

public class StockDetailsBean {

	//仕入詳細テーブル
	//(stock_details)
	private String stock_details_id;
	private int stock_details_quantity;
	private int cost_price;
	private String stock_id;
	private String prodect_id;
	public String getStock_details_id() {
		return stock_details_id;
	}
	public void setStock_details_id(String stock_details_id) {
		this.stock_details_id = stock_details_id;
	}
	public int getStock_details_quantity() {
		return stock_details_quantity;
	}
	public void setStock_details_quantity(int stock_details_quantity) {
		this.stock_details_quantity = stock_details_quantity;
	}
	public int getCost_price() {
		return cost_price;
	}
	public void setCost_price(int cost_price) {
		this.cost_price = cost_price;
	}
	public String getStock_id() {
		return stock_id;
	}
	public void setStock_id(String stock_id) {
		this.stock_id = stock_id;
	}
	public String getProdect_id() {
		return prodect_id;
	}
	public void setProdect_id(String prodect_id) {
		this.prodect_id = prodect_id;
	}

}
