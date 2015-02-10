package jp.ac.hal.tokyo.cenka.beans;

public class CreditAmountBean {

	//与信限度額テーブル
	//credit_amount
	private int unpaid_price;
	private int sredid_price;
	private String conpany_id;

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
	public String getConpany_id() {
		return conpany_id;
	}
	public void setConpany_id(String conpany_id) {
		this.conpany_id = conpany_id;
	}


}
