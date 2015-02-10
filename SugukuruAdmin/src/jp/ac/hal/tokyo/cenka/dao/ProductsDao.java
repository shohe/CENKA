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

import jp.ac.hal.tokyo.cenka.beans.ProductsBean;



public class ProductsDao {


	private Connection con;

	public ProductsDao() throws NamingException, SQLException {
		InitialContext context = new InitialContext();
		DataSource ds =
			(DataSource) context.lookup("java:comp/env/jdbc/sugukuru");
		con = ds.getConnection();
	}

	public ProductsDao(Connection con){
		this.con = con;
	}

	/**
	 * 全件取得する
	 *
	 * @return 全件
	 * @throws SQLException
	 */
	public List<ProductsBean> findAll() throws SQLException {

		PreparedStatement select = con.prepareStatement("select * from T_products");

		ResultSet result = select.executeQuery();

		ArrayList<ProductsBean> table = new ArrayList<ProductsBean>();
		while (result.next()) {

			ProductsBean record = new ProductsBean();
			record.setProduct_id(result.getString("f_products_id"));
			record.setProduct_name(result.getString("f_products_name"));
			record.setTaax_omission_price(result.getInt("f_tasx_omission_price"));
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
