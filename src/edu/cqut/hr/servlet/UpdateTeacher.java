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

/**
 * Servlet implementation class UpdateTeacher
 */
//@WebServlet("/UpdateTeacher")
public class UpdateTeacher extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateTeacher() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Integer oldId = Integer.parseInt(request.getParameter("oldId"));
		Integer newId = Integer.parseInt(request.getParameter("newId"));
		String name = request.getParameter("name");
		Float salary = Float.parseFloat(request.getParameter("salary"));
		String sex = request.getParameter("sex");
		
		String sdate = request.getParameter("birthday");  
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		Date birthday;
		try {
			birthday = sf.parse(sdate);
		} catch (ParseException e) {
			birthday=null;
			e.printStackTrace();
		}  
		
		String college = request.getParameter("college");
		String major = request.getParameter("major");

		
		System.out.println(oldId);
		
		TeacherServiceImpl teacherService = new TeacherServiceImpl();
		if(teacherService.update(oldId, newId, name, salary, sex, birthday, college, major))
		{
			response.sendRedirect("TeacherServlet");
		}else {
			request.getRequestDispatcher("/resourse/showAllTeachers.jsp").forward(request, response);
		}
		
	}

}
