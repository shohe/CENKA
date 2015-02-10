package jp.ac.hal.tokyo.cenka.beans;

public class EmployeesBean {

	//従業員テーブル
	//(employyes)
	private String employee_id;
	private String employee_name;
	private String employee_pass;
	private String unit_id;


	public String getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(String employee_id) {
		this.employee_id = employee_id;
	}
	public String getEmployee_name() {
		return employee_name;
	}
	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
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

}
