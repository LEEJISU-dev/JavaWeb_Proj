package com.team.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.team.dao.PageDAO;
import com.team.dto.PageVO;

public class LoginAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/page/Main.jsp";
		PageDAO pDao = PageDAO.getInstance();
		PageVO pVo = new PageVO();
		String s = "0";
		HttpSession session = request.getSession();
			
		if(request.getParameter("ma").equals("user")) {
			pVo.setUserId(request.getParameter("UserId"));
			pVo.setUPw(request.getParameter("UPw"));
			if(pDao.checkPw(pVo)==true) {
				session.setAttribute("UserId", pVo.getUserId());			
			}else {
				s="1";
				request.setAttribute("LCK", s);
			}
		}else if(request.getParameter("ma").equals("admin")) {
			System.out.println(request.getParameter("UserId"));
			System.out.println(request.getParameter("UPw"));
			
			pVo.setAId(request.getParameter("UserId"));
			pVo.setAPw(request.getParameter("UPw"));
			
			if(pDao.checkMPw(pVo)==true) {
				System.out.println(pVo.getAId());
				session.setAttribute("AId", pVo.getAId());			
			}else {
				s="1";
				request.setAttribute("LCK", s);
			}
		}
		
		
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}


