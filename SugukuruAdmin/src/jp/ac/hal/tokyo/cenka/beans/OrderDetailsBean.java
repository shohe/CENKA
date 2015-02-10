package jp.ac.hal.tokyo.cenka.beans;

public class OrderDetailsBean {

	//受注詳細テーブル
	//order_details
	private String order_details_id;
	private int price;
	private int order_details_quantity;
	private String order_id;
	private String product_id;


	public String getOrder_details_id() {
		return order_details_id;
	}
	public void setOrder_details_id(String order_details_id) {
		this.order_details_id = order_details_id;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getOrder_details_quantity() {
		return order_details_quantity;
	}
	public void setOrder_details_quantity(int order_details_quantity) {
		this.order_details_quantity = order_details_quantity;
	}
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	public String getProduct_id() {
		return product_id;
	}
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}


}
