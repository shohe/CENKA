package jp.ac.hal.tokyo.cenka.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



public class SessionContoller {

	public void setSession(String id,HttpServletRequest request,
			HttpServletResponse response){
		HttpSession session = request.getSession(true);
		session.setAttribute("ID",id);
	}

	public void getSession(HttpServletRequest request,
			HttpServletResponse response){
		HttpSession session = request.getSession(true);
		session.getAttribute("ID");
	}
}
