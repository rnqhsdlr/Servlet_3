package com.iu.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MemberController
 */
@WebServlet("/MemberController")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberService memberService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberController() {
        super();
        // TODO Auto-generated constructor stub
        memberService = new MemberService();
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
		String path = "";
		try {
		if(command.equals("/memberJoin")) {
			
			if(method.equals("POST")) {
				
				
				MemberDTO memberDTO = new MemberDTO();
				
				memberDTO.setMemberId(request.getParameter("memberId"));
				memberDTO.setMemberPw(request.getParameter("memberPw"));
				memberDTO.setName(request.getParameter("name"));
				memberDTO.setMemberPhone(request.getParameter("memberPhone"));
				memberDTO.setMemberEmail(request.getParameter("memberEmail"));
				memberDTO.setMemberAge(Integer.parseInt(request.getParameter("memberAge")));
				
				int result=0;
				
				result = memberService.memberJoin(memberDTO);
				
				String msg = "회원가입 실패";
				if(result>0) {
					msg="회원가입 성공";
					request.setAttribute("path", "../");
				}else {
					System.out.println("success");
					request.setAttribute("path", "./memberJoin");
				}
				request.setAttribute("result", msg);
				path="../WEB-INF/views/common/result.jsp";
					
			} else {
				path="../WEB-INF/views/member/memberJoin.jsp";
				
			}
			
		} else if (command.equals("/memberLogin")) {
			
			if(method.equals("POST")) {
				MemberDTO memberDTO = new MemberDTO();
				memberDTO.setMemberId(request.getParameter("memberId"));
				memberDTO.setMemberPw(request.getParameter("memberPw"));
				
				memberDTO=memberService.memberLogin(memberDTO);
				
				if(memberDTO!=null) {
					HttpSession session = request.getSession();
					session.setAttribute("member", memberDTO);
					check=false;
					path="../";
				}else {
					
					request.setAttribute("path", "./memberLogin");
					request.setAttribute("result", "로그인 실패");
					path="../WEB-INF/views/common/result.jsp";
				}
				
				
			} else {
				path="../WEB-INF/views/member/memberLogin.jsp";
						
			}
		}else if(command.equals("/memberLogout")) {
			HttpSession session = request.getSession();
//			session.removeAttribute("member");
			session.invalidate();
			check=false;
			path="../";
			
		} else if (command.equals("/memberPage")) {
			
			path="../WEB-INF/views/member/memberPage.jsp";
			
		} else if (command.equals("/memberDelete")) {
			HttpSession session = request.getSession();
			int result=0;
			MemberDTO memberDTO = new MemberDTO();
			
			memberDTO=(MemberDTO) session.getAttribute("member");
			
			path="../WEB-INF/views/member/memberPage.jsp";
			
			result = memberService.memberDelete(memberDTO);
			
			
			if(result>0) {
				session.invalidate();
				check=false;
				path="../";	
			}	
			
		} else if (command.equals("/memberUpdate")) {
			if(method.equals("POST")) {
				HttpSession session = request.getSession();
				MemberDTO memberDTO = new MemberDTO();
				memberDTO.setMemberId(request.getParameter("memberId"));
				memberDTO.setName(request.getParameter("name"));
				memberDTO.setMemberPhone(request.getParameter("memberPhone"));
				memberDTO.setMemberEmail(request.getParameter("memberEmail"));
				memberDTO.setMemberAge(Integer.parseInt(request.getParameter("memberAge")));
				System.out.println(memberDTO.getMemberAge());
				int result = memberService.memberUpdate(memberDTO);
				if(result>0) {
					session.setAttribute("member", memberDTO);
				}
				check=false;
				path="../";
			}else {
				
				path="../WEB-INF/views/member/memberUpdate.jsp";
			}
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
