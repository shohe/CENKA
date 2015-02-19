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
 * Servlet implementation class RootController
 */
@WebServlet("/root/*")
public class RootController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public String action;
	public String jsp;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RootController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// セッションget
		SessionContoller sessionContoller = new SessionContoller();
		String id = sessionContoller.getSession(request, response);
		// セッションチェック
		sessionContoller.checkSession(id, request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
	/**
	 * URLから呼び出したいアクションを振り分ける。
	 * URLの形式は
	 * 【 http://localhost:8080/SugukuruAdmin/ [controller] / [action] / [argument,...] 】
	 * @param request
	 * @return
	 */
	public String sortingAction(HttpServletRequest request) {
		String action = request.getRequestURI();
		String[] actionAry = action.split("/");
		action = (actionAry.length > 3) ? actionAry[3] : null;
		return action;
	}
	
	/**
	 * 呼び出したアクションがnullの時に呼ばれるメソッド
	 * （URLのaction名が入力されてない時に呼ばれます。）
	 * オーバーライドして使って下さい。
	 */
	public void action_index(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
	}
	
	/**
	 * ログアウト
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void action_logout(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		this.jsp = SSCORE.LOGIN_CONTROLLER;
		response.sendRedirect(this.jsp);
	}
}
