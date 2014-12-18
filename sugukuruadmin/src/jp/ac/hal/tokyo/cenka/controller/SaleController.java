package jp.ac.hal.tokyo.cenka.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.ac.hal.tokyo.cenka.constant.SSCORE;

/**
 * Servlet implementation class SaleController
 */
@WebServlet("/sale/*")
public class SaleController extends RootController {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see RootController#RootController()
     */
    public SaleController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// アクションを振り分ける
		this.action = sortingAction(request);
		if(this.action == null) {
			action_index(request, response);
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
	 * @throws IOException 
	 * @throws ServletException 
	 */
	@Override
	public void action_index(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.action_index(request, response);
		
		this.jsp = SSCORE.SALE_INDEX_JSP;
		RequestDispatcher dispatcher = request.getRequestDispatcher(this.jsp);
		dispatcher.forward(request, response);
	}

}
