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

public class DoPModifyAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "PageServlet?command=PView";
		HttpSession session = request.getSession();
		
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
		
		String PNo = multi.getParameter("PNo");
		System.out.println("dopmodify"+PNo);
		
		pVo.setPName(multi.getParameter("PName"));
		System.out.println("dopmodify"+pVo.getPName());
		pVo.setPPrice(multi.getParameter("PPrice"));
		pVo.setPDetail(multi.getParameter("PDetail"));
		pVo.setPPhoto(multi.getFilesystemName("PPhoto"));
		pVo.setPNo(Integer.parseInt(PNo));
		System.out.println(multi.getFilesystemName("PPhoto"));
		pVo.setPSId(PSId);
		
		pDao.productModify(pVo);
		request.setAttribute("PNo", PNo);
		request.setAttribute("pVo", pVo);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);		
	}

}
