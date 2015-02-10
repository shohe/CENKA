package jp.ac.hal.tokyo.cenka.beans;

import java.sql.Date;

public class LanguageBean {

	//従業員テーブル
	//(employees)
	private String employee_id;
	private String employee_name;
	private String employee_pass;

	//部署テーブル
	//(units)
	private String unit_id;
	private String unit_name;

	//仕入先テーブル
	//(supplier)
	private String supplier_id;
	private String supplier_name;
	private String supplier_iddress;
	private String supplier_tel;
	private String supplier_method;
	private String supplier_mail;
	private Date payday;

	//仕入テーブル
	//stock
	private String stock_id;
	private int stock_tootal_amount;
	private boolean stock_flg;
	private Date stock_day;

	//仕入詳細テーブル
	//(stock_details)
	private String stock_details_id;
	private int stock_details_quantity;
	private int cost_price;

	//商品テーブル
	//product
	private String product_id;
	private String product_name;
	private int taax_omission_price;

	//在庫テーブル
	//inventory
	private int schedule_quantity;
	private int invent_quantity;

	//顧客（個人）
	//customer_individual
	private String individual_id;
	private String individual_name;
	private String individual_tel;
	private String individual_address;
	private String individual_mail;

	//顧客（企業）
	//customer_company
	private String company_id;
	private String company_name;
	private String company_tel;
	private String company_address;
	private String company_mail;

	//与信限度額テーブル
	//credit_amount
	private int unpaid_price;
	private int sredid_price;

	//受注テーブル
	//order
	private String order_id;
	private Date order_day;
	private Date delivary_day;
	private int order_total_amount;

	//受注詳細テーブル
	//order_details
	private String order_details_id;
	private int price;
	private int order_detaails_quantity;

	//売上テーブル
	//sales
	private String sale_id;
	private Date sale_date;
	private int sale_total_amount;
	private Boolean sale_flg;
	private int sale_total_profits;

	//売上詳細テーブル
	//sales_details
	private String sale_details_id;
	private int sale_details_quantity;
	private int sale_details_tootal_amount;

	//=======================================
	//getter・setter
	public String getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(String employee_id) {
		this.employee_id = employee_id;
	}
	public String getEmployee_pass() {
		return employee_pass;
	}
	public void setEmployee_pass(String employee_pass) {
		this.employee_pass = employee_pass;
	}
	public String getUnit_id() {
		return unit_id;
	}
	public void setUnit_id(String unit_id) {
		this.unit_id = unit_id;
	}
	public String getUnit_name() {
		return unit_name;
	}
	public void setUnit_name(String unit_name) {
		this.unit_name = unit_name;
	}

	public String getSupplier_id() {
		return supplier_id;
	}
	public void setSupplier_id(String supplier_id) {
		this.supplier_id = supplier_id;
	}
	public String getSupplier_name() {
		return supplier_name;
	}
	public void setSupplier_name(String supplier_name) {
		this.supplier_name = supplier_name;
	}
	public String getSupplier_iddress() {
		return supplier_iddress;
	}
	public void setSupplier_iddress(String supplier_iddress) {
		this.supplier_iddress = supplier_iddress;
	}
	public String getSupplier_tel() {
		return supplier_tel;
	}
	public void setSupplier_tel(String supplier_tel) {
		this.supplier_tel = supplier_tel;
	}
	public String getSupplier_method() {
		return supplier_method;
	}
	public void setSupplier_method(String supplier_method) {
		this.supplier_method = supplier_method;
	}
	public String getSupplier_mail() {
		return supplier_mail;
	}
	public void setSupplier_mail(String supplier_mail) {
		this.supplier_mail = supplier_mail;
	}
	public Date getPayday() {
		return payday;
	}
	public void setPayday(Date payday) {
		this.payday = payday;
	}
	public String getStock_id() {
		return stock_id;
	}
	public void setStock_id(String stock_id) {
		this.stock_id = stock_id;
	}
	public int getStock_tootal_amount() {
		return stock_tootal_amount;
	}
	public void setStock_tootal_amount(int stock_tootal_amount) {
		this.stock_tootal_amount = stock_tootal_amount;
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
	public String getIndividual_id() {
		return individual_id;
	}
	public void setIndividual_id(String individual_id) {
		this.individual_id = individual_id;
	}
	public String getIndividual_name() {
		return individual_name;
	}
	public void setIndividual_name(String individual_name) {
		this.individual_name = individual_name;
	}
	public String getIndividual_tel() {
		return individual_tel;
	}
	public void setIndividual_tel(String individual_tel) {
		this.individual_tel = individual_tel;
	}
	public String getIndividual_address() {
		return individual_address;
	}
	public void setIndividual_address(String individual_address) {
		this.individual_address = individual_address;
	}
	public String getIndividual_mail() {
		return individual_mail;
	}
	public void setIndividual_mail(String individual_mail) {
		this.individual_mail = individual_mail;
	}
	public String getCompany_id() {
		return company_id;
	}
	public void setCompany_id(String company_id) {
		this.company_id = company_id;
	}
	public String getCompany_name() {
		return company_name;
	}
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
	public String getCompany_tel() {
		return company_tel;
	}
	public void setCompany_tel(String company_tel) {
		this.company_tel = company_tel;
	}
	public String getCompany_address() {
		return company_address;
	}
	public void setCompany_address(String company_address) {
		this.company_address = company_address;
	}
	public String getCompany_mail() {
		return company_mail;
	}
	public void setCompany_mail(String company_mail) {
		this.company_mail = company_mail;
	}
	public int getUnpaid_price() {
		return unpaid_price;
	}
	public void setUnpaid_price(int unpaid_price) {
		this.unpaid_price = unpaid_price;
	}
	public int getSredid_price() {
		return sredid_price;
	}
	public void setSredid_price(int sredid_price) {
		this.sredid_price = sredid_price;
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
	public int getOrder_detaails_quantity() {
		return order_detaails_quantity;
	}
	public void setOrder_detaails_quantity(int order_detaails_quantity) {
		this.order_detaails_quantity = order_detaails_quantity;
	}
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
	public String getEmployee_name() {
		return employee_name;
	}
	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}

}
