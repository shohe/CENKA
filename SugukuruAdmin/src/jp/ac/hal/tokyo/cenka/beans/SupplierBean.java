package jp.ac.hal.tokyo.cenka.beans;

import java.sql.Date;

public class SupplierBean {
	//仕入先テーブル
		//(supplier)
		private String supplier_id;
		private String supplier_name;
		private String supplier_address;
		private String supplier_tel;
		private String payday_method;
		private String supplier_mail;
		private Date payday;

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

		public String getSupplier_tel() {
			return supplier_tel;
		}
		public void setSupplier_tel(String supplier_tel) {
			this.supplier_tel = supplier_tel;
		}
		public String getPayday_method() {
			return payday_method;
		}
		public void setPayday_method(String payday_method) {
			this.payday_method = payday_method;
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
		public String getSupplier_address() {
			return supplier_address;
		}
		public void setSupplier_address(String supplier_address) {
			this.supplier_address = supplier_address;
		}

}
