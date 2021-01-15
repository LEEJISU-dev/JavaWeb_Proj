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

public class UIModifyAction implements Action {

   @Override
   public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String url = "/page/MInfo.jsp";
      String url2 = "PageServlet?command=MInfo";
      
      PageDAO pDao = PageDAO.getInstance();
      PageVO pVo = new PageVO();
      HttpSession session = request.getSession();
      
      pVo.setUserId((String)session.getAttribute("UserId"));
      pVo.setUPw(request.getParameter("UPw"));
      pVo.setUEmail(request.getParameter("UEmail"));
      pVo.setUPhone(request.getParameter("UPhone"));
      pVo.setUAddr(request.getParameter("UAddr"));       
      
      pDao.modifyMInfo(pVo);         
      
      PageVO myInfo = pDao.myInfo(pVo);
      System.out.println("주소"+myInfo.getUAddr());
      request.setAttribute("myInfo", myInfo);
      
      
      
      RequestDispatcher dispatcher = request.getRequestDispatcher(url2);
      dispatcher.forward(request, response);
      
   }

}