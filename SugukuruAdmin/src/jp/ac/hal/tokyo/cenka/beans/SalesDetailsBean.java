package jp.ac.hal.tokyo.cenka.beans;

public class SalesDetailsBean {


	//売上詳細テーブル
	//sales_details
	private String sale_details_id;
	private int sale_details_quantity;
	private int sale_details_tootal_amount;
	private String sale_id;
	private String product_id;

	public String getSale_details_id() {
		return sale_details_id;
	}
	public void setSale_details_id(String sale_details_id) {
		this.sale_details_id = sale_details_id;
	}
	public int getSale_details_quantity() {
		return sale_details_quantity;
	}
	public void setSale_details_quantity(int sale_details_quantity) {
		this.sale_details_quantity = sale_details_quantity;
	}
	public int getSale_details_tootal_amount() {
		return sale_details_tootal_amount;
	}
	public void setSale_details_tootal_amount(int sale_details_tootal_amount) {
		this.sale_details_tootal_amount = sale_details_tootal_amount;
	}
	public String getSale_id() {
		return sale_id;
	}
	public void setSale_id(String sale_id) {
		this.sale_id = sale_id;
	}
	public String getProduct_id() {
		return product_id;
	}
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}

}
