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

public class MInfoAction implements Action {
   
   @Override
   public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String url = "/page/MInfo.jsp";
      PageDAO pDao = PageDAO.getInstance();
      PageVO pVo = new PageVO();
      HttpSession session = request.getSession();
      String UserId = (String)session.getAttribute("UserId");
      pVo.setUserId(UserId);
      PageVO myInfo = pDao.myInfo(pVo);
      
      System.out.println(myInfo.getUName());
      
      request.setAttribute("myInfo", myInfo);
      RequestDispatcher dispatcher = request.getRequestDispatcher(url);
      dispatcher.forward(request, response);
   }
}