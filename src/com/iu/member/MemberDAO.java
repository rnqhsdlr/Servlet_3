package com.iu.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.iu.util.DBConnect;

public class MemberDAO {
	
	public MemberDTO memberLogin(MemberDTO memberDTO) throws Exception{
	
		Connection con = DBConnect.getConnect();
		
		String sql = "select*from member where memberid=? and memberpw=?";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, memberDTO.getMemberId());
		st.setString(2, memberDTO.getMemberPw());
		
		ResultSet rs = st.executeQuery();
		if(rs.next()) {
			memberDTO.setName(rs.getString("name"));
			memberDTO.setMemberPhone(rs.getString("memberPhone"));
			memberDTO.setMemberEmail(rs.getString("memberEmail"));
			memberDTO.setMemberAge(rs.getInt("memberAge"));
		}else {
			memberDTO=null;
		}
		
		rs.close();
		st.close();
		con.close();
		
		return memberDTO;
	}
	
	
	public int memberJoin(MemberDTO memberDTO) throws Exception{
		int result=0;
		Connection con = DBConnect.getConnect();
		
		String sql = "insert into member values(?, ?, ?, ?, ?, ?)";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, memberDTO.getMemberId());
		st.setString(2, memberDTO.getMemberPw());
		st.setString(3, memberDTO.getName());
		st.setString(4, memberDTO.getMemberPhone());
		st.setString(5, memberDTO.getMemberEmail());
		st.setInt(6, memberDTO.getMemberAge());
		
		result = st.executeUpdate();
		
		st.close();
		con.close();
		
		return result;
	}

}