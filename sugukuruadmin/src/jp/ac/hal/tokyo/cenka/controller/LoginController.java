package jp.ac.hal.tokyo.cenka.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
			action_index();
		} else if(this.action.equals("logout")) {
			action_logout();
		} else if(this.action.equals("addUser")) {
			action_addUser();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * ログイン処理
	 */
	@Override
	public void action_index() {
		// TODO Auto-generated method stub
		super.action_index();
		System.out.println("ログイン");
	}
	
	/**
	 * ログアウト処理
	 */
	private void action_logout() {
		System.out.println("ログアウト");
	}
	
	/**
	 * ユーザー登録処理
	 */
	private void action_addUser() {
		System.out.println("ユーザー登録");
	}

}
