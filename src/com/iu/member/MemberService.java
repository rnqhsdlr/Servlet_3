package com.iu.member;

public class MemberService {
	
	private MemberDAO memberDAO;
	
	public MemberService() {
	
		memberDAO= new MemberDAO();
		// TODO Auto-generated constructor stub
	}
	
	public int memberUpdate(MemberDTO memberDTO) throws Exception{
		int result=0;
		result = memberDAO.memberUpdate(memberDTO);
		return result;
		
	}
	
	public int memberDelete(MemberDTO memberDTO) throws Exception{
		int result =0;
		result = memberDAO.memberDelete(memberDTO);
		return result;
	}
	
	public MemberDTO memberLogin(MemberDTO memberDTO) throws Exception{
		
		return memberDAO.memberLogin(memberDTO);
	}
	
	public int memberJoin(MemberDTO memberDTO) throws Exception{
		int  result=0;
		result = memberDAO.memberJoin(memberDTO);
		
		return result;
		
	}
	

}
