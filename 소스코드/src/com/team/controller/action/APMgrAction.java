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

public class APMgrAction implements Action {

   @Override
   public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String url = "/page/APMgr.jsp";
      HttpSession session = request.getSession();
      String PNo[] = request.getParameterValues("PNo");
      PageDAO pDao = PageDAO.getInstance();
      PageVO pVo = new PageVO();
      if(PNo !=null) {
		  for(String pno:PNo) {
		  System.out.println(pno);
		  pDao.deleteProduct(pno);
	      }
	  }
      List<PageVO> PList = pDao.PListSelect(pVo);
      request.setAttribute("PList", PList);
      
      RequestDispatcher dispatcher = request.getRequestDispatcher(url);
      dispatcher.forward(request, response);
      


   }

}