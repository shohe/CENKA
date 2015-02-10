package jp.ac.hal.tokyo.cenka.beans;

public class InventoryBean {

	//在庫テーブル
	//inventory
	private int schedule_quantity;
	private int invent_quantity;
	private String product_id;

	public int getSchedule_quantity() {
		return schedule_quantity;
	}

	public void setSchedule_quantity(int schedule_quantity) {
		this.schedule_quantity = schedule_quantity;
	}

	public int getInvent_quantity() {
		return invent_quantity;
	}

	public void setInvent_quantity(int invent_quantity) {
		this.invent_quantity = invent_quantity;
	}

	public String getProduct_id() {
		return product_id;
	}

	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}
}
