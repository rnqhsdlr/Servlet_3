package com.iu.notice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.iu.util.DBConnect;

public class NoticeDAO {
	
	public NoticeDTO noticeSelect(int num) throws Exception{
		Connection con = DBConnect.getConnect();
		String sql = "select * from notice where num=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, num);
		ResultSet rs = st.executeQuery();
		
		NoticeDTO noticeDTO = null;
		if(rs.next()) {
			noticeDTO = new NoticeDTO();
			noticeDTO.setNum(rs.getInt("num"));
			noticeDTO.setTitle(rs.getString("title"));
			noticeDTO.setId(rs.getString("id"));
			noticeDTO.setDay(rs.getDate("day"));
			noticeDTO.setHit(rs.getInt("hit"));
			noticeDTO.setText(rs.getString("text"));
		}
		
		rs.close();
		st.close();
		con.close();
		
		return noticeDTO;
		
		
	}
	
	
	public int hitUpdate(NoticeDTO noticeDTO) throws Exception{
		Connection con = DBConnect.getConnect();
		String sql = "update notice set hit=? where num=?";
		PreparedStatement st = con.prepareStatement(sql);

		st.setInt(1, noticeDTO.getHit()+1);
		st.setInt(2, noticeDTO.getNum());
		
		
		int result = st.executeUpdate();
		
		
		st.close();
		con.close();
		return result;
		
	}
	
	public int noticeAdd(NoticeDTO noticeDTO) throws Exception{
		Connection con = DBConnect.getConnect();
		int result = 0;
		String sql = "insert into notice values(auto_num.nextval, ?, ?, sysdate, 0, ?)";
		
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, noticeDTO.getTitle());
		st.setString(2, noticeDTO.getId());
		st.setString(3, noticeDTO.getText());
		
		result=st.executeUpdate();
		
		st.close();
		con.close();
		return result;
		
		
	}
	
	public ArrayList<NoticeDTO> noticeList() throws Exception{
		
		ArrayList<NoticeDTO> ar = new ArrayList<NoticeDTO>();
		
		Connection con = DBConnect.getConnect();
		
		String sql = "select*from notice order by num desc";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			NoticeDTO noticeDTO = new NoticeDTO();
			noticeDTO.setNum(rs.getInt("num"));
			noticeDTO.setTitle(rs.getString("title"));
			noticeDTO.setId(rs.getString("id"));
			noticeDTO.setDay(rs.getDate("day"));
			noticeDTO.setHit(rs.getInt("hit"));
			ar.add(noticeDTO);
			
		}
		
		rs.close();
		st.close();
		con.close();
		
		return ar;
		
	}

}
