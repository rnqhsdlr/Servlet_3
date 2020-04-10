package com.iu.notice;

import java.util.ArrayList;

public class NoticeService {
	
	private NoticeDAO noticeDAO;
	
	public NoticeService() {
	
		noticeDAO = new NoticeDAO();
		
		// TODO Auto-generated constructor stub
	}
	
	public NoticeDTO noticeSelect(int num) throws Exception {
		NoticeDTO noticeDTO = noticeDAO.noticeSelect(num);
		noticeDAO.hitUpdate(noticeDTO);
		
		return noticeDTO;
		
	}
	
	public int noticeAdd(NoticeDTO noticeDTO) throws Exception{
		
		int result = 0;
		result = noticeDAO.noticeAdd(noticeDTO);
		return result;
	}
	
	public ArrayList<NoticeDTO> noticeList() throws Exception{
		
		return noticeDAO.noticeList();
	}

}
