package jp.ac.hal.tokyo.cenka.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.ac.hal.tokyo.cenka.constant.SSCORE;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// アクションを振り分ける
		this.action = sortingAction(request);
		if(this.action == null) {
			action_index(request, response);
		} else if(this.action.equals("logout")) {
			super.action_logout(request, response);
		} else if(this.action.equals("addUser")) {
			action_addUser();
		}
	}

	/**
	 * ログインボタンを押した時に呼ばれます。
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		String pswd = request.getParameter("pswd");
		
		// idとpswdをチェックしてリダイレクト
		if (chkLogin(id, pswd).equals("SALE_CONTROLLER")) {
			this.jsp = SSCORE.SALE_CONTROLLER;
		}
		response.sendRedirect(this.jsp);
	}
	
	/**
	 * ログインできるかをチェックする。
	 * ログインした人によって部門名が戻り値として帰る。
	 * 
	 * @param id
	 * @param pswd
	 * @return
	 */
	public String chkLogin(String id, String pswd) {
		// debug用
		System.out.println("id: "+id+" pswd: "+pswd);
		return "SALE_CONTROLLER";
	}
	
	/**
	 * ログイン画面に遷移
	 * @throws IOException 
	 * @throws ServletException 
	 */
	@Override
	public void action_index(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
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
