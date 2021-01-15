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

public class PViewAction implements Action {

   @Override
   public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String url = "/page/PView.jsp";
      PageDAO pDao = PageDAO.getInstance();
      PageVO pVo = new PageVO();
      HttpSession session = request.getSession();
      String PNo = (String)request.getAttribute("PNo");
      if(request.getParameter("PNo")!=null) {
    	  PNo = request.getParameter("PNo");
    	  System.out.println("sssss"+request.getParameter("PNo"));
      }
      String PS = "0";
      
      //PageVO PView = pDao.PViewSelect(PNo);
      
      
      PageVO PView = pDao.selectProductByPno(PNo);
      PS = String.valueOf(pDao.checkSelled(PNo));
      
      System.out.println(PView.getPPhoto());
      
      request.setAttribute("PView", PView);
      request.setAttribute("SID", PView.getPSId());
      request.setAttribute("PNo", PNo);
      request.setAttribute("PS", PS);
      System.out.println(PS);
      
      System.out.println(PNo);
      
      RequestDispatcher dispatcher = request.getRequestDispatcher(url);
      dispatcher.forward(request, response);
   }

}