package jp.ac.hal.tokyo.cenka.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.naming.spi.DirStateFactory.Result;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.Request;

import jp.ac.hal.tokyo.cenka.beans.EmployeesBean;
import jp.ac.hal.tokyo.cenka.beans.UnitsBean;
import jp.ac.hal.tokyo.cenka.constant.SSCORE;
import jp.ac.hal.tokyo.cenka.dao.EmployeesDao;
import jp.ac.hal.tokyo.cenka.dao.UnitsDao;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login/*")
public class LoginController extends RootController {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// アクションを振り分ける
		this.action = sortingAction(request);
		if (this.action == null) {
			action_index(request, response);
		} else if (this.action.equals("logout")) {
			super.action_logout(request, response);
		} else if (this.action.equals("addUser")) {
			action_addUser();
		}
	}

	/**
	 * ログインボタンを押した時に呼ばれます。
	 *
	 * @throws SQLException
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		String pswd = request.getParameter("pswd");
		String unitName = "";

		// idとpswdをチェックしてリダイレクト
		try {
			unitName = chkLogin(id, pswd);
			if (!unitName.isEmpty()) {
				//* session処理
				SessionContoller sessionContoller = new SessionContoller();
				sessionContoller.setSession(id, request, response);
				
				if (unitName.equals("経理")) {
					this.jsp = SSCORE.SALE_CONTROLLER;
					response.sendRedirect(this.jsp);
				} else if (unitName.equals("商品管理")) {
					this.jsp = SSCORE.SALE_CONTROLLER;
					response.sendRedirect(this.jsp);
				} else if (unitName.equals("購買")) {
					this.jsp = SSCORE.SALE_CONTROLLER;
					response.sendRedirect(this.jsp);
				} else if (unitName.equals("販売")) {
					this.jsp = SSCORE.SALE_CONTROLLER;
					response.sendRedirect(this.jsp);
				}
			} else {
				this.jsp = ("/SugukuruAdmin/login/");
				response.sendRedirect(this.jsp);
			}

		} catch (NamingException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

	}

	/**
	 * ログインできるかをチェックする。 ログインした人によって部門名が戻り値として帰る。
	 *
	 * @param id
	 * @param pswd
	 * @return
	 * @throws SQLException
	 * @throws NamingException
	 */

	public String chkLogin(String id, String pswd) throws NamingException,
			SQLException {

		EmployeesDao employees = new EmployeesDao();
		UnitsDao unit = new UnitsDao();
		EmployeesBean employeeRecord = new EmployeesBean();
		UnitsBean unitRecord = new UnitsBean();

		String unitName = "";
		String unitId = "";

		employeeRecord = employees.Login(id, pswd);

		if (employeeRecord.getEmployee_id() != null) {
			unitId = employeeRecord.getUnit_id().toString();
			unitRecord = unit.findByUnitId(unitId);
			unitName = unitRecord.getUnit_name().toString();
		}

		employees.close();
		unit.close();
		return unitName;
	}

	/**
	 * ログイン画面に遷移
	 *
	 * @throws IOException
	 * @throws ServletException
	 */
	@Override
	public void action_index(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.action_index(request, response);

		this.jsp = SSCORE.LOGIN_JSP;
		RequestDispatcher dispatcher = request.getRequestDispatcher(this.jsp);
		dispatcher.forward(request, response);
	}

	/**
	 * ユーザー登録処理
	 */
	private void action_addUser() {
		System.out.println("ユーザー登録");
	}

}