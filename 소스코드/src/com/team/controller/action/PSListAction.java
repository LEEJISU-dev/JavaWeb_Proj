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

public class PSListAction implements Action{
   
   @Override
   public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String url = "/page/PSList.jsp";
      
      HttpSession session = request.getSession();
      
      PageDAO pDao = PageDAO.getInstance();
      
      PageVO pVo = new PageVO();
      
      String UserId = (String)session.getAttribute("UserId");
      
      pVo.setUserId(UserId);
      
      List<PageVO> PSList = pDao.MyProduct(pVo); 
      request.setAttribute("PSList", PSList);
      
      RequestDispatcher dispatcher = request.getRequestDispatcher(url);
      dispatcher.forward(request, response);

   }
   
}