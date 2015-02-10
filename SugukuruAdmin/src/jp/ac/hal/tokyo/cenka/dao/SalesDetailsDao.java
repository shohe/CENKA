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

import jp.ac.hal.tokyo.cenka.beans.SalesDetailsBean;



public class SalesDetailsDao {

	private Connection con;

	public SalesDetailsDao() throws NamingException, SQLException {
		InitialContext context = new InitialContext();
		DataSource ds =
			(DataSource) context.lookup("java:comp/env/jdbc/sugukuru");
		con = ds.getConnection();
	}

	public SalesDetailsDao(Connection con){
		this.con = con;
	}

	/**
	 * 全件取得する
	 *
	 * @return 全件
	 * @throws SQLException
	 */
	public List<SalesDetailsBean> findAll() throws SQLException {

		PreparedStatement select = con.prepareStatement("select * from T_SalesDetails");

		ResultSet result = select.executeQuery();

		ArrayList<SalesDetailsBean> table = new ArrayList<SalesDetailsBean>();
		while (result.next()) {
			SalesDetailsBean record = new SalesDetailsBean();
			record.setSale_details_id(result.getString("f_sale_details_id"));
			record.setProduct_id(result.getString("f_product_id"));
			record.setSale_id(result.getString("f_sale_id"));
			record.setSale_details_quantity(result.getInt("f_sale_details_quantity"));
			record.setSale_details_tootal_amount(result.getInt("f_sale_details_tootal_amount"));
			table.add(record);
		}
		return table;
	}

	/**
	 * 新規保存
	 *
	 * @param newRecord 保存データ
	 * @return 影響のあった行数
	 * @throws SQLException
	 */
	public int create(SalesDetailsBean newRecord) throws SQLException {

		PreparedStatement insert = con.prepareStatement("insert into T_SALESDETAILS (f_sale_details_id,"
				+ "															f_sale_id,"
				+ "															f_product_id,"
				+ "															f_sale_details_quantity,"
				+ "															f_sale_details_tootal_amount)"
				+ "															values (?,?,?,?,?,?)");
		insert.setString(1, newRecord.getSale_details_id());
		insert.setString(2, newRecord.getSale_id());
		insert.setString(3, newRecord.getProduct_id());
		insert.setInt(4, newRecord.getSale_details_quantity());
		insert.setInt(5, newRecord.getSale_details_tootal_amount());
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
