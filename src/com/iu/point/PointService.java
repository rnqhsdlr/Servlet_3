package com.iu.point;

import java.util.ArrayList;

public class PointService {
	
	private PointDAO pointDAO;
	
	public PointService() {
		this.pointDAO = new PointDAO();
	
	}
	
	public int pointDelete(int num) throws Exception{
		return pointDAO.pointDelete(num);
	}
	public PointDTO pointSelect(int num) throws Exception{
		
		return pointDAO.pointSelect(num);
		
	}
	
	//1. List
	public ArrayList<PointDTO> pointList() throws Exception{
		return pointDAO.pointList();
		
	}
	

}
