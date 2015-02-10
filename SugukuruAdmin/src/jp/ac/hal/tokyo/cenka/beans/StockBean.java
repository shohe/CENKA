package jp.ac.hal.tokyo.cenka.beans;

import java.sql.Date;

public class StockBean {

	//仕入テーブル
	//stock
	private String stock__id;
	private int stock__tootal_amount;
	private boolean stock_flg;
	private Date stock_day;
	private String supplier_id;
	public String getStock__id() {
		return stock__id;
	}
	public void setStock__id(String stock__id) {
		this.stock__id = stock__id;
	}
	public int getStock__tootal_amount() {
		return stock__tootal_amount;
	}
	public void setStock__tootal_amount(int stock__tootal_amount) {
		this.stock__tootal_amount = stock__tootal_amount;
	}
	public boolean isStock_flg() {
		return stock_flg;
	}
	public void setStock_flg(boolean stock_flg) {
		this.stock_flg = stock_flg;
	}
	public Date getStock_day() {
		return stock_day;
	}
	public void setStock_day(Date stock_day) {
		this.stock_day = stock_day;
	}
	public String getSupplier_id() {
		return supplier_id;
	}
	public void setSupplier_id(String supplier_id) {
		this.supplier_id = supplier_id;
	}


}
