package edu.cqut.hr.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.cqut.hr.service.impl.TeacherServiceImpl;

/**
 * Servlet implementation class DeleteTeacher
 */
//@WebServlet("/DeleteTeacher")
public class DeleteTeacher extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteTeacher() {
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
		Integer id = Integer.parseInt(request.getParameter("deleteId"));
	
		PrintWriter out = response.getWriter();
		
		TeacherServiceImpl teacherService = new TeacherServiceImpl();
		if(teacherService.remove(id))
		{
			out.println("<script type='text/javascript'> alert('成功')</script>");
			response.sendRedirect("TeacherServlet");
		}else{
			out.println("<script type='text/javascript'> alert('失败')</script>");
			request.getRequestDispatcher("/resourse/showAllTeachers.jsp").forward(request, response);
		}
	}

}
