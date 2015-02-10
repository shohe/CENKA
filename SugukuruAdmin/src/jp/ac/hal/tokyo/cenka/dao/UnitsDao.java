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

import jp.ac.hal.tokyo.cenka.beans.UnitsBean;

public class UnitsDao {

	private Connection con;

	public UnitsDao() throws NamingException, SQLException {
		InitialContext context = new InitialContext();
		DataSource ds =
			(DataSource) context.lookup("java:comp/env/jdbc/sugukuru");
		con = ds.getConnection();
	}

	public UnitsDao(Connection con){
		this.con = con;
	}

	/**
	 * 全件取得する
	 *
	 * @return 全件
	 * @throws SQLException
	 */
	public List<UnitsBean> findAll() throws SQLException {

		PreparedStatement select = con.prepareStatement("select * from T_UNITS");

		ResultSet result = select.executeQuery();

		ArrayList<UnitsBean> table = new ArrayList<UnitsBean>();
		while (result.next()) {

			UnitsBean record = new UnitsBean();
			record.setUnit_id(result.getString("f_unit_id"));
			record.setUnit_name(result.getString("f_unit_name"));

			table.add(record);
		}

		return table;
	}

	/**
	 * 主キーで検索
	 *
	 * @param languageId
	 * @return
	 * @throws SQLException
	 */
	public UnitsBean findByUnitId(String unit_id) throws SQLException {

		PreparedStatement select = con.prepareStatement("select * from T_UNITS where f_unit_id = ?");

		select.setString(1, unit_id);
		ResultSet result = select.executeQuery();

		UnitsBean record = new UnitsBean();

		if (result.next()) {
			record.setUnit_id(result.getString("f_unit_id"));
			record.setUnit_name(result.getString("f_unit_name"));
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
