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

public class AUMgrAction implements Action {

   @Override
   public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String url = "/page/AUMgr.jsp";
      HttpSession session = request.getSession();
      String uid[] = request.getParameterValues("userid");
      PageDAO pDao = PageDAO.getInstance();
      PageVO pVo = new PageVO();
      
      if(uid !=null) {
		  for(String UID:uid) {
		  System.out.println(UID);
		  pDao.deleteMember(UID);
	      }
	  }
      List<PageVO> userInfo = pDao.userInfo(pVo);
      request.setAttribute("userInfo", userInfo);
      
      RequestDispatcher dispatcher = request.getRequestDispatcher(url);
      dispatcher.forward(request, response);
      


   }

}