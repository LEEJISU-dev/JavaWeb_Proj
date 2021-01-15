package com.team.controller.action;

import java.io.IOException;
import java.util.List;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team.dao.PageDAO;
import com.team.dto.PageVO;

public class DoJoinAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/page/Main.jsp";
		PageDAO pDao = PageDAO.getInstance();
		PageVO pVo = new PageVO();
		String i = "0";
		
		pVo.setUName(request.getParameter("UName"));
		pVo.setUserId(request.getParameter("UserId"));
		pVo.setUPw(request.getParameter("UPw"));
		pVo.setUEmail(request.getParameter("UEmail"));
		pVo.setUPhone(request.getParameter("UPhone"));
		pVo.setUAddr(request.getParameter("UAddr"));
		//Arraylist<PageVO> pageList = pDao.joinMemeber();
		
		if(pDao.joinMember(pVo)==false) {
			i = "1";
			url = "/page/Join.jsp";
		}		
		
		request.setAttribute("CID", i);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
