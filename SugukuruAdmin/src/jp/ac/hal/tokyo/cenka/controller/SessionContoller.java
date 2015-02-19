package jp.ac.hal.tokyo.cenka.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.ac.hal.tokyo.cenka.constant.SSCORE;



public class SessionContoller extends RootController {

	public void setSession(String id, HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession(true);
		session.setAttribute("ID", id);
	}

	public String getSession(HttpServletRequest request,
			HttpServletResponse response) {
		String id;

		HttpSession session = request.getSession(true);

		id = (String) session.getAttribute("ID");

		return id;
	}

	public void checkSession(String id, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		if (id == null || id.isEmpty()) {
			this.jsp = SSCORE.LOGIN_CONTROLLER;
			response.sendRedirect(this.jsp);
		}
	}

}
