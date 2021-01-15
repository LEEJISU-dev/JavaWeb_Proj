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

public class SearchAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/page/PList.jsp";
	      String search = request.getParameter("search");
	      HttpSession session = request.getSession();
	      PageDAO pDao = PageDAO.getInstance();
	      PageVO pVo = new PageVO();
	      
	      System.out.println("서치"+search);
	      
	      if(search != null) {
	    	  List<PageVO> PList = pDao.PListSearch(search);
	          request.setAttribute("PList", PList);
	          request.setAttribute("search1", search);
	          RequestDispatcher dispatcher = request.getRequestDispatcher(url);
	          dispatcher.forward(request, response);
	      }else {
	    	  List<PageVO> PList = pDao.PListSelect(pVo);
	          request.setAttribute("PList", PList);
	          
	          RequestDispatcher dispatcher = request.getRequestDispatcher(url);
	          dispatcher.forward(request, response);
	      }
	}

}
