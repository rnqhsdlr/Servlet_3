package com.iu.notice;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.iu.member.MemberDTO;
import com.iu.point.PointDTO;

/**
 * Servlet implementation class NoticeController
 */
@WebServlet("/NoticeController")
public class NoticeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private NoticeService noticeService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeController() {
        super();
        noticeService = new NoticeService();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String command = request.getPathInfo();
		String method = request.getMethod();
		
		boolean check = true;
		
		String path="";
		try {
		if(command.equals("/noticeList")) {
			ArrayList<NoticeDTO> ar = noticeService.noticeList();
			
			request.setAttribute("list", ar);
			path = "../WEB-INF/views/notice/noticeList.jsp";
			
		} else if(command.equals("/noticeAdd")) {
			if(method.equals("POST")) {
				NoticeDTO noticeDTO = new NoticeDTO();
				HttpSession session = request.getSession();
				MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
				path="../WEB-INF/views/common/result.jsp";
				noticeDTO.setTitle(request.getParameter("title"));
				noticeDTO.setText(request.getParameter("text"));
				noticeDTO.setId(memberDTO.getMemberId());
				
				int result = noticeService.noticeAdd(noticeDTO);
				if (result>0) {
					session.setAttribute("result", "등록 성공");
					session.setAttribute("path", "./noticeList");
				}
				
			} else {
				HttpSession session = request.getSession();
				MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
				if (memberDTO.getMemberId().equals("admin")) {
					path="../WEB-INF/views/notice/noticeAdd.jsp";
				}
			} 
			
		} else if(command.equals("/noticeSelect")) {
			
			int num = Integer.parseInt(request.getParameter("num"));
			
			NoticeDTO noticeDTO=noticeService.noticeSelect(num);
			request.setAttribute("noticeDTO", noticeDTO);
			
			path="../WEB-INF/views/notice/noticeSelect.jsp";
			
		}
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		if(check) {
			RequestDispatcher view = request.getRequestDispatcher(path);
			view.forward(request, response);
		} else {
			response.sendRedirect(path);
		}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
