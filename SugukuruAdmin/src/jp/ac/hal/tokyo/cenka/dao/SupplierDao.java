package jp.ac.hal.tokyo.cenka.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import jp.ac.hal.tokyo.cenka.beans.SupplierBean;


public class SupplierDao {


	private Connection con;

	public SupplierDao() throws NamingException, SQLException {
		InitialContext context = new InitialContext();
		DataSource ds =
			(DataSource) context.lookup("java:comp/env/jdbc/sugukuru");
		con = ds.getConnection();
	}

	public SupplierDao(Connection con){
		this.con = con;
	}

	/**
	 * 主キーで検索
	 *
	 * @param languageId
	 * @return
	 * @throws SQLException
	 */
	public SupplierBean findByLanguageId(String supplier_id ) throws SQLException {

		PreparedStatement select = con.prepareStatement("select * from t_supplier where supplier_id = ?");

		select.setString(1, supplier_id);
		ResultSet result = select.executeQuery();

		SupplierBean record = new SupplierBean();

		if (result.next()) {
			record.setSupplier_id(result.getString("supplier_id"));
			record.setSupplier_name(result.getString("name"));
			record.setSupplier_address(result.getNString("supplier_address"));
			record.setSupplier_tel(result.getString("supplier_tel"));
			record.setPayday(result.getDate("last_update"));
		}
		return record;
	}

}
