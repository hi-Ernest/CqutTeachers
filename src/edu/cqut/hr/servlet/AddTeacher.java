package edu.cqut.hr.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.cqut.hr.service.impl.TeacherServiceImpl;
import edu.cqut.hr.dao.impl.TeacherDaoImpl;
import edu.cqut.hr.entity.*;

/**
 * Servlet implementation class AddTeacher
 */
//@WebServlet("/AddTeacher")
public class AddTeacher extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTeacher() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String salary = request.getParameter("salary");
		String sex = request.getParameter("sex");
		String birthday = request.getParameter("birthday");
		String college = request.getParameter("college");
		String major = request.getParameter("major");
		
		Integer Id = null;
		if(id!=null){
		     Id = Integer.valueOf(id);
		}
		
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		Date date;
		try {
			date = sf.parse(birthday);
		} catch (ParseException e) {
			date=null;
			e.printStackTrace();
		}  
		 
		String warning;
		Teacher teacher = new Teacher(Id,name, Float.parseFloat(salary),sex,date,college,major);
		
		TeacherServiceImpl teacherService = new TeacherServiceImpl();
		if(teacherService.create(teacher))
		{
			warning = "成功";
			request.setAttribute("warning", warning);
			response.sendRedirect("TeacherServlet");
		}else {
			warning = "失败";
			request.setAttribute("warning", warning);
			request.getRequestDispatcher("/resourse/addTeacher.jsp").forward(request, response);
		}
	}
}
