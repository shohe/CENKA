package jp.ac.hal.tokyo.cenka.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import jp.ac.hal.tokyo.cenka.beans.OrderBean;



/**
 * 仕入 テーブルへのアクセスを行う DAO
 *
 * @author hal
 */
public class OrderDao {

	/** Connection */
	private Connection con;

	/**
	 * コンストラクタ
	 * @throws NamingException
	 * @throws SQLException
	 */
	public OrderDao() throws NamingException, SQLException {
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
	public OrderDao(Connection con){
		this.con = con;
	}

	/**
	 * 受注一覧処理
	 *

	 * @return record
	 * @throws SQLException
	 */
	public List<OrderBean> findAll() throws SQLException {

		PreparedStatement select =
			con.prepareStatement("select * from t_order");

		ResultSet result = select.executeQuery();

		OrderBean record = new OrderBean();
		ArrayList<OrderBean> table = new ArrayList<OrderBean>();

		if (result.next()) {
			record.setOrder_id(result.getString("f_order_id"));
			record.setCompany_id(result.getString("f_company_id"));
			record.setIndividual_id(result.getString("f_individual_id"));
			record.setOrder_day(result.getDate("f_order_day"));
			record.setDelivary_day(result.getDate("f_delivary_day"));
			record.setOrder_total_amount(result.getInt("f_order_total_amount"));
			table.add(record);
		}

		return table;
	}

	/**
	 * 新規発注
	 *
	 * @param newRecord 保存データ
	 * @return 影響のあった行数
	 * @throws SQLException
	 */
	public int create(OrderBean newRecord) throws SQLException {

		PreparedStatement insert =
			con.prepareStatement("insert into t_order(f_order_id,f_company_id,f_individual_id,f_order_day,f_order_total_amount) values (?,?,?,?,?)");
		insert.setString(1, newRecord.getOrder_id());
		insert.setString(2, newRecord.getCompany_id());
		insert.setString(3, newRecord.getIndividual_id());
		insert.setString(4, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		insert.setInt(5, newRecord.getOrder_total_amount());
		return insert.executeUpdate();
	}

	/**
	 * 更新処理
	 *
	 * @param updateRecord 更新データ
	 * @return 影響のあった行数
	 * @throws SQLException
	 */
	public int update(OrderBean updateRecord) throws SQLException {

		PreparedStatement update =
			con.prepareStatement("update t_order set f_delivary_day = ? where f_order_id = ?");

		update.setString(1, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		update.setString(2, updateRecord.getOrder_id());

		return update.executeUpdate();
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
