package jp.ac.hal.tokyo.cenka.beans;

public class ProductsBean {

	//商品テーブル
	//product
	private String product_id;
	private String product_name;
	private int taax_omission_price;

	public String getProduct_id() {
		return product_id;
	}
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public int getTaax_omission_price() {
		return taax_omission_price;
	}
	public void setTaax_omission_price(int taax_omission_price) {
		this.taax_omission_price = taax_omission_price;
	}

}
