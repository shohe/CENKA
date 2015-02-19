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

import jp.ac.hal.tokyo.cenka.beans.CustomerIndividualBeanl;



/**
 * 仕入 テーブルへのアクセスを行う DAO
 *
 * @author hal
 */
public class CustomerIndividualDao {

	/** Connection */
	private Connection con;

	/**
	 * コンストラクタ
	 * @throws NamingException
	 * @throws SQLException
	 */
	public CustomerIndividualDao () throws NamingException, SQLException {
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
	public CustomerIndividualDao (Connection con){
		this.con = con;
	}

	/**
	* 一意検索
	*
	* @param individual_id
	* @return
	* @throws SQLException
	*/
	public CustomerIndividualBeanl findByIndividualId(String individual_id) throws SQLException {

		PreparedStatement select =
			con.prepareStatement("select * from t_individual where f_individual_id = ?");

		select.setString(1, individual_id);
		ResultSet result = select.executeQuery();

		CustomerIndividualBeanl record = new CustomerIndividualBeanl();

		if (result.next()) {
			record.setIndividual_id(result.getString("f_individual_id"));
			record.setIndividual_name(result.getString("f_individual_name"));
			record.setIndividual_tel(result.getString("f_individual_tel"));
			record.setIndividual_address(result.getString("f_individual_address"));
			record.setIndividual_mail(result.getString("f_individual_mail"));
		}

		return record;
	}

	/**
	 * 新規顧客(個人)
	 *
	 * @param newRecord 保存データ
	 * @return 影響のあった行数
	 * @throws SQLException
	 */
	public int create(CustomerIndividualBeanl newRecord) throws SQLException {

		PreparedStatement insert =
			con.prepareStatement("insert into t_customer_indidual (f_individual_id,f_individual_name,f_individual_tel,f_individual_address,f_individual_mail) values (?,?,?,?,?)");
		insert.setString(1, newRecord.getIndividual_id());
		insert.setString(2, newRecord.getIndividual_name());
		insert.setString(3, newRecord.getIndividual_tel());
		insert.setString(4, newRecord.getIndividual_address());
		insert.setString(5, newRecord.getIndividual_mail());

		return insert.executeUpdate();
	}

	/**
	 * 削除処理
	 *
	 * @param languageId 削除対象
	 * @return 影響のあった行数
	 * @throws SQLException
	 */
	public int delete(String individual_id) throws SQLException {

		PreparedStatement delete = con.prepareStatement("delete from t_individual where individual_id = ?");
		delete.setString(1, individual_id);
		return delete.executeUpdate();
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
