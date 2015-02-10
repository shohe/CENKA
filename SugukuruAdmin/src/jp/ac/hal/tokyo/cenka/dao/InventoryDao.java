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

import jp.ac.hal.tokyo.cenka.beans.InventoryBean;
import jp.ac.hal.tokyo.cenka.beans.ProductsBean;



public class InventoryDao {


	private Connection con;

	public InventoryDao() throws NamingException, SQLException {
		InitialContext context = new InitialContext();
		DataSource ds =
			(DataSource) context.lookup("java:comp/env/jdbc/sugukuru");
		con = ds.getConnection();
	}

	public InventoryDao(Connection con){
		this.con = con;
	}

	/**
	 * 全件取得する
	 *
	 * @return 全件
	 * @throws SQLException
	 */
	public List<InventoryBean> findAll() throws SQLException {

		PreparedStatement select = con.prepareStatement("select * from t_inventory");

		ResultSet result = select.executeQuery();

		ArrayList<InventoryBean> table = new ArrayList<InventoryBean>();
		while (result.next()) {

			InventoryBean record = new InventoryBean();
			record.setProduct_id(result.getString("f_inventory_id"));
			record.setInvent_quantity(result.getInt("f_invent_quantity"));
			record.setSchedule_quantity(result.getInt("f_schedule_quantity"));
			table.add(record);
		}
		return table;
	}

	/**
	 * 主キーで検索
	 *
	 * @param products_id
	 * @return
	 * @throws SQLException
	 */
	public ProductsBean findByLanguageId(int product_id) throws SQLException {

		PreparedStatement select = con.prepareStatement("select * from T_PRODUCTS where f_product_id = ?");

		select.setInt(1, product_id);
		ResultSet result = select.executeQuery();

		ProductsBean record = new ProductsBean();

		if (result.next()) {
			record.setProduct_id(result.getString("f_product_id"));
			record.setProduct_name(result.getString("f_product_name"));
			record.setTaax_omission_price(result.getInt("f_taax_omission_price"));
		}
		return record;
	}

	/**
	 * 更新処理
	 *
	 * @param updateRecord 更新データ
	 * @return 影響のあった行数
	 * @throws SQLException
	 */
	public int update(InventoryBean updateRecord) throws SQLException {

		PreparedStatement update =
			con.prepareStatement("update t_inventory set f_invent_quantity = ? where f_product_id = ?");

		update.setInt(1, updateRecord.getInvent_quantity());
		update.setString(2, updateRecord.getProduct_id());
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
