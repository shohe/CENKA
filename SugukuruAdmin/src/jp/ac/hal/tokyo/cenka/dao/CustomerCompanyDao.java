package jp.ac.hal.tokyo.cenka.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import jp.ac.hal.tokyo.cenka.beans.CustomerCompanyBean;



/**
 * 仕入 テーブルへのアクセスを行う DAO
 *
 * @author hal
 */
public class CustomerCompanyDao {

	/** Connection */
	private Connection con;

	/**
	 * コンストラクタ
	 * @throws NamingException
	 * @throws SQLException
	 */
	public CustomerCompanyDao () throws NamingException, SQLException {
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
	public CustomerCompanyDao (Connection con){
		this.con = con;
	}

	/**
	* 一意検索
	*
	* @param individual_id
	* @return
	* @throws SQLException
	*/
	public CustomerCompanyBean findByCompanyId(String company_id) throws SQLException {

		PreparedStatement select =
			con.prepareStatement("select * from t_customer_company where f_company_id = ?");

		select.setString(1, company_id);
		ResultSet result = select.executeQuery();

		CustomerCompanyBean record = new CustomerCompanyBean();

		if (result.next()) {
			record.setCompany_id(result.getString("f_company_id"));
			record.setCompany_name(result.getString("f_company_name"));
			record.setCompany_tel(result.getString("f_company_tel"));
			record.setCompany_address(result.getString("f_company_address"));
			record.setCompany_mail(result.getString("f_company_mail"));
		}

		return record;
	}

	/**
	 * 新規顧客(企業)
	 *
	 * @param newRecord 保存データ
	 * @return 影響のあった行数
	 * @throws SQLException
	 */
	public int create(CustomerCompanyBean newRecord) throws SQLException {

		PreparedStatement insert =
			con.prepareStatement("insert into t_customer_company (f_company_id,f_company_name,f_company_tel,f_company_address,f_company_mail) values (?,?,?,?,?)");
		insert.setString(1, newRecord.getCompany_id());
		insert.setString(2, newRecord.getCompany_name());
		insert.setString(3, newRecord.getCompany_tel());
		insert.setString(4, newRecord.getCompany_address());
		insert.setString(5, newRecord.getCompany_mail());

		return insert.executeUpdate();
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
