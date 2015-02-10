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

import jp.ac.hal.tokyo.cenka.beans.StockBean;


/**
 * 仕入 テーブルへのアクセスを行う DAO
 *
 * @author hal
 */
public class StockDao {

	/** Connection */
	private Connection con;

	/**
	 * コンストラクタ
	 * @throws NamingException
	 * @throws SQLException
	 */
	public StockDao() throws NamingException, SQLException {
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
	public StockDao(Connection con){
		this.con = con;
	}

	/**
	 * 未発注一覧処理
	 *

	 * @return record
	 * @throws SQLException
	 */
	public List<StockBean> findAll() throws SQLException {

		PreparedStatement select =
			con.prepareStatement("select * from t_stock where f_stock_flg = false");

		ResultSet result = select.executeQuery();

		StockBean record = new StockBean();
		ArrayList<StockBean> table = new ArrayList<StockBean>();

		if (result.next()) {
			record.setSupplier_id(result.getString("f_supplier_id"));
			record.setStock_day(result.getDate("f_stock_day"));
			record.setStock__tootal_amount(result.getInt("f_stock_total_amount"));
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
	public int create(StockBean newRecord) throws SQLException {

		PreparedStatement insert =
			con.prepareStatement("insert into t_stock(f_stock_id,f_supplier_id,f_stock_day,f_stock_total_amount,f_stock_flg) values (?,?,?,?,?)");
		insert.setString(1, newRecord.getStock__id());
		insert.setString(2, newRecord.getSupplier_id());
		insert.setString(3, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		insert.setInt(4, newRecord.getStock__tootal_amount());
		insert.setBoolean(5,false);
		return insert.executeUpdate();
	}

	/**
	* 一意検索
	*
	* @param stock_id
	* @return
	* @throws SQLException
	*/
	public StockBean findByStockId(String stock_id) throws SQLException {

		PreparedStatement select =
			con.prepareStatement("select f_supplier_id,f_stock_day,f_total_amount,f_stock_flg from t_stock where f_stock_id = ?");

		select.setString(1, stock_id);
		ResultSet result = select.executeQuery();

		StockBean record = new StockBean();

		if (result.next()) {
			record.setSupplier_id(result.getString("f_supplier_id"));
			record.setStock__id(result.getString("f_stock_id"));
			record.setStock__tootal_amount(result.getInt("f_total_amount"));
			record.setStock_flg(result.getBoolean("f_stock_flg"));
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
