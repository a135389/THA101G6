package courseCar.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import courseCar.service.CourseCarService;
import courseCar.service.CourseCarServiceImpl;

public class CourseCarServlet extends HttpServlet{
	private CourseCarService courseCarService;
	
	@Override
	public void init() throws ServletException{
		super.init();
		courseCarService=new CourseCarServiceImpl();
		
	}
	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException{
		doPost(req,res);
	}
	
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException{
		
	}
	
}
