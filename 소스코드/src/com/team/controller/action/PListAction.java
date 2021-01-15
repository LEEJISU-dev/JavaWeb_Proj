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

public class PListAction implements Action {

   @Override
   public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String url = "/page/PList.jsp";
      String PClass1 = request.getParameter("PClass1");
      String PClass2 = request.getParameter("PClass2");
      String search1 = request.getParameter("search1");
      String opt = request.getParameter("opt");
      HttpSession session = request.getSession();
      PageDAO pDao = PageDAO.getInstance();
      PageVO pVo = new PageVO();
      
      
     
      
      
      System.out.println("opt:" + opt);
      System.out.println("pclass1: " + PClass1);
      System.out.println("PClass2:" + PClass2);
      System.out.println("search1:" + search1);
      
      
      if (opt != null) {

          List<PageVO> PList = pDao.PListOpt(opt, PClass1, PClass2, search1);
          request.setAttribute("PList", PList);
          request.setAttribute("opt", opt);
          request.setAttribute("PClass1", PClass1);
          request.setAttribute("PClass2", PClass2);
          request.setAttribute("search1", search1);
          

          RequestDispatcher dispatcher = request.getRequestDispatcher(url);
          dispatcher.forward(request, response);
       }else if (PClass2 != null) {

           List<PageVO> PList = pDao.PListClass2(PClass2);
           request.setAttribute("PList", PList);
           request.setAttribute("opt", opt);
           request.setAttribute("PClass1", PClass1);
           request.setAttribute("PClass2", PClass2);
           request.setAttribute("search1", search1);

           RequestDispatcher dispatcher = request.getRequestDispatcher(url);
           dispatcher.forward(request, response);

        }
      else if(PClass1 != null) {
         
          List<PageVO> PList = pDao.PListClass1(PClass1);
          request.setAttribute("PList", PList);
          request.setAttribute("opt", opt);
          request.setAttribute("PClass1", PClass1);
          request.setAttribute("PClass2", PClass2);
          request.setAttribute("search1", search1);
          
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