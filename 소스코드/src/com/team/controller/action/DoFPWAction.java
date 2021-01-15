package com.team.controller.action;

import com.team.controller.action.*;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.team.dao.PageDAO;
import com.team.dto.PageVO;

public class DoFPWAction implements Action{

   @Override
   public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = "/page/Main.jsp";
         PageDAO pDao = PageDAO.getInstance();
         PageVO pVo = new PageVO();
         HttpSession session = request.getSession();
         String UPhone = request.getParameter("UPhone");
         String UEmail = request.getParameter("UEmail");
         String s = "0";
         
         boolean FindUInfo1 = pDao.FindUInfo1(UPhone, UEmail);
         
         
         if(FindUInfo1==false) {
        	 s = "0";
         }else {
        	 PageVO FindUInfo =  pDao.FindUInfo(UPhone, UEmail);
        	 String UserId = FindUInfo.getUserId();
             String UPw = FindUInfo.getUPw();
             
             MailSendComponent mail = new MailSendComponent();
             mail.connectSMTP();
             mail.createMail(UserId,UPw, UEmail);
             mail.sendMail();
             
             s = "1";
         }

         System.out.println("pwA:"+s);
         request.setAttribute("pwA", s);
         
        
         RequestDispatcher dispatcher = request.getRequestDispatcher(url);
         dispatcher.forward(request, response);
      
   }

}