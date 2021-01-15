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

public class DoPAddAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "PageServlet?command=PView";
		HttpSession session = request.getSession();
		String PNo = null;
		String PSId = (String)session.getAttribute("UserId");
		PageDAO pDao = PageDAO.getInstance();
				
		PageVO pVo = new PageVO();
		
		
		ServletContext context = session.getServletContext();
		String path = "upload";
		String uploadFilePath = context.getRealPath(path);
		int sizeLimit = 20 * 1024 * 1024;
		
		MultipartRequest multi = new MultipartRequest(request, uploadFilePath, sizeLimit, "UTF-8", new DefaultFileRenamePolicy());
		
		System.out.println(uploadFilePath);
		
	
	
		System.out.println(session.getAttribute("UserId"));
		
		pVo.setPName(multi.getParameter("PName"));
		pVo.setPPrice(multi.getParameter("PPrice"));
		pVo.setPClass1(multi.getParameter("PClass1"));
		pVo.setPClass2(multi.getParameter("PClass2"));
		pVo.setPDetail(multi.getParameter("PDetail"));
		pVo.setPPhoto(multi.getFilesystemName("PPhoto"));
		System.out.println(multi.getFilesystemName("PPhoto"));
		pVo.setPSId(PSId);
		pDao.productAdd(pVo);
		PNo = pDao.RProduct();
		
		request.setAttribute("PNo", PNo);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}


	
}
