package jp.ac.hal.tokyo.cenka.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import jp.ac.hal.tokyo.cenka.beans.EmployeesBean;



/**
 * 従業員 テーブルへのアクセスを行う DAO
 *
 * @author hal
 */
public class EmployeesDao {

	/** Connection */
	private Connection con;

	/**
	 * コンストラクタ
	 * @throws NamingException
	 * @throws SQLException
	 */
	public EmployeesDao() throws NamingException, SQLException {
		InitialContext context = new InitialContext();
		DataSource ds =
			(DataSource) context.lookup("java:comp/env/jdbc/sugukuru");
		con = ds.getConnection();
	}

	/**
	 *
	 * コンストラクタ
	 *
	 * @param con
	 */
	public EmployeesDao(Connection con){
		this.con = con;
	}

	/**
	 * ログイン処理
	 *
	 * @param employee_id , employee_pass
	 * @return record
	 * @throws SQLException
	 */
	public EmployeesBean Login(String employee_id,String employee_pass) throws SQLException {

		PreparedStatement select =
			con.prepareStatement("select * from t_employees where f_employee_id = ? and f_employee_pass = ?");

		select.setString(1, employee_id);
		select.setString(2, employee_pass);

		ResultSet result = select.executeQuery();

		EmployeesBean record = new EmployeesBean();

		if (result.next()) {
			record.setEmployee_id(result.getString("f_employee_id"));
			record.setEmployee_name(result.getString("f_employee_name"));
			record.setUnit_id(result.getString("f_unit_id"));
		}

		return record;

	}

	/**
	 * 新規従業員登録
	 *
	 * @param newRecord 保存データ
	 * @return 影響のあった行数
	 * @throws SQLException
	 */
	public int create(EmployeesBean newRecord) throws SQLException {

		PreparedStatement insert =
			con.prepareStatement("insert into t_employees (f_employee_id,f_employee_name,f_employee_pass,f_unit_id) values (?,?,?,?)");
		insert.setString(1, newRecord.getEmployee_id());
		insert.setString(2, newRecord.getEmployee_name());
		insert.setString(3, newRecord.getEmployee_pass());
		insert.setString(4, newRecord.getUnit_id());
		return insert.executeUpdate();
	}

	/**
	* 重複チェック
	*
	* @param employee_id
	* @return
	* @throws SQLException
	*/
	public int check(String employee_id) throws SQLException {

		PreparedStatement select =
			con.prepareStatement("select count(*) from t_employees where employee_id = ?");

		select.setString(1, employee_id);
		ResultSet result = select.executeQuery();

		return result.getInt("count(*)");
	}

	/**
	 * 接続を閉じる
	 *
	 * @throws SQLException
	 */
	public void close() throws SQLException {
		con.close();
	}

	/**
	 * コミット
	 *
	 * @throws SQLException
	 */
	public void commit() throws SQLException {
		con.commit();
	}

	/**
	 * ロールバック
	 *
	 * @throws SQLException
	 */
	public void rollback() throws SQLException {
		con.rollback();
	}
}
