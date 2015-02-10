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

import jp.ac.hal.tokyo.cenka.beans.StockDetailsBean;



/**
 * 仕入 テーブルへのアクセスを行う DAO
 *
 * @author hal
 */
public class StockDetailsDao {

	/** Connection */
	private Connection con;

	/**
	 * コンストラクタ
	 * @throws NamingException
	 * @throws SQLException
	 */
	public StockDetailsDao() throws NamingException, SQLException {
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
	public StockDetailsDao(Connection con){
		this.con = con;
	}

	/**
	 * 未発注詳細一覧
	 *

	 * @return record
	 * @throws SQLException
	 */
	public List<StockDetailsBean> findByStockList(String stock_id) throws SQLException {

		PreparedStatement select =
			con.prepareStatement("select * from t_stock_details where f_stock_id = ?");
		select.setString(1, stock_id);
		ResultSet result = select.executeQuery();

		StockDetailsBean record = new StockDetailsBean();
		ArrayList<StockDetailsBean> table = new ArrayList<StockDetailsBean>();

		if (result.next()) {
			record.setStock_details_id(result.getString("f_stock_details_id"));
			record.setProdect_id(result.getString("f_product_id"));
			record.setStock_details_quantity(result.getInt("f_stock_details_quantity"));
			record.setCost_price(result.getInt("f_cost_price"));
			table.add(record);
		}

		return table;
	}

	/**
	 * 新規発注詳細
	 *
	 * @param newRecord 保存データ
	 * @return 影響のあった行数
	 * @throws SQLException
	 */
	public int create(StockDetailsBean newRecord) throws SQLException {

		PreparedStatement insert =
			con.prepareStatement("insert into t_stock_daitals (f_stock_details_id,f_stock_id,f_product_id,f_stock_details_quantity,f_cost_price) values (?,?,?,?,?)");
		insert.setString(1, newRecord.getStock_details_id());
		insert.setString(2, newRecord.getStock_id());
		insert.setString(3, newRecord.getProdect_id());
		insert.setInt(4, newRecord.getStock_details_quantity());
		insert.setInt(5, newRecord.getCost_price());
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
