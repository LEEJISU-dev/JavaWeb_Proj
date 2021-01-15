package com.team.controller.action;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.team.dao.PageDAO;
import com.team.dto.PageVO;

public class DoCPWAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/page/CPW.jsp";
		String url2 = "/page/UIModify.jsp";
		PageDAO pDao = PageDAO.getInstance();
		PageVO pVo = new PageVO();
		String s = "0";
		HttpSession session = request.getSession();
		pVo.setUserId((String)session.getAttribute("UserId"));
		pVo.setUPw(request.getParameter("UPw"));
		
		if(pDao.checkPw(pVo)==true) {
			PageVO myInfo = pDao.myInfo(pVo);
		      System.out.println("주소"+myInfo.getUAddr());
		      request.setAttribute("myInfo", myInfo);
			RequestDispatcher dispatcher = request.getRequestDispatcher(url2);
			dispatcher.forward(request, response);			
		}else {
			
			s="1";
			request.setAttribute("LCK", s);
			RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			dispatcher.forward(request, response);
			
		}
	}

}
