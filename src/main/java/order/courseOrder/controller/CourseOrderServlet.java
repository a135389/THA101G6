package order.courseOrder.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import order.courseOrder.service.CourseOrderService;
import order.courseOrder.service.CourseOrderServiceImpl;

@WebServlet("/web/order/CourseOrderServlet")
public class CourseOrderServlet extends HttpServlet{
	private CourseOrderService courseOrderService;
	
	@Override
	public void init() throws ServletException {
		super.init();
		courseOrderService=new CourseOrderServiceImpl();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req,res);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
	
	

}
