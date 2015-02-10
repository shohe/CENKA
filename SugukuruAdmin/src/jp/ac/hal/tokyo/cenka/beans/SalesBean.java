package jp.ac.hal.tokyo.cenka.beans;

import java.sql.Date;

public class SalesBean {

	//売上テーブル
	//sales
	private String sale_id;
	private Date sale_date;
	private int sale_total_amount;
	private Boolean sale_flg;
	private int sale_total_profits;
	private String order_id;

	public String getSale_id() {
		return sale_id;
	}
	public void setSale_id(String sale_id) {
		this.sale_id = sale_id;
	}
	public Date getSale_date() {
		return sale_date;
	}
	public void setSale_date(Date sale_date) {
		this.sale_date = sale_date;
	}
	public int getSale_total_amount() {
		return sale_total_amount;
	}
	public void setSale_total_amount(int sale_total_amount) {
		this.sale_total_amount = sale_total_amount;
	}
	public Boolean getSale_flg() {
		return sale_flg;
	}
	public void setSale_flg(Boolean sale_flg) {
		this.sale_flg = sale_flg;
	}
	public int getSale_total_profits() {
		return sale_total_profits;
	}
	public void setSale_total_profits(int sale_total_profits) {
		this.sale_total_profits = sale_total_profits;
	}
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}


}
