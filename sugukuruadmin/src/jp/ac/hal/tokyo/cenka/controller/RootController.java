package jp.ac.hal.tokyo.cenka.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RootController
 */
@WebServlet("/root/*")
public class RootController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public String action;
       
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
	public void action_index() {
		
	}

}
