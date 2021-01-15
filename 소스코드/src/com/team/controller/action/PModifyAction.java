package com.team.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import com.team.controller.action.Action;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import com.team.dao.PageDAO;
import com.team.dto.PageVO;

public class PModifyAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/page/PModify.jsp";
		String PNo = request.getParameter("PNo");
		request.setAttribute("PNo", request.getParameter("PNo"));
		PageDAO pDao = PageDAO.getInstance();
		PageVO PView = pDao.selectProductByPno(PNo);
	    request.setAttribute("PView", PView);
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
