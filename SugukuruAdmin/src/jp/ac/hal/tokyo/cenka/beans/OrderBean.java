package jp.ac.hal.tokyo.cenka.beans;

import java.sql.Date;

public class OrderBean {

	//受注テーブル
	//order
	private String order_id;
	private Date order_day;
	private Date delivary_day;
	private int order_total_amount;
	private String company_id;
	private String individual_id;
	private String company_name;
	
	public String getCompany_name() {
		return company_name;
	}
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	public Date getOrder_day() {
		return order_day;
	}
	public void setOrder_day(Date order_day) {
		this.order_day = order_day;
	}
	public Date getDelivary_day() {
		return delivary_day;
	}
	public void setDelivary_day(Date delivary_day) {
		this.delivary_day = delivary_day;
	}
	public int getOrder_total_amount() {
		return order_total_amount;
	}
	public void setOrder_total_amount(int order_total_amount) {
		this.order_total_amount = order_total_amount;
	}
	public String getCompany_id() {
		return company_id;
	}
	public void setCompany_id(String company_id) {
		this.company_id = company_id;
	}
	public String getIndividual_id() {
		return individual_id;
	}
	public void setIndividual_id(String individual_id) {
		this.individual_id = individual_id;
	}

}
