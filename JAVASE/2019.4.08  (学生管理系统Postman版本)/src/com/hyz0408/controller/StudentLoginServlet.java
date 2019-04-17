package com.hyz0408.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hyz0408.common.ServerResponse;
import com.hyz0408.pojo.Course;
import com.hyz0408.pojo.Student;
import com.hyz0408.pojo.User;
import com.hyz0408.service.impl.StudentServiceImpl;

/**
 * Servlet implementation class StudentLoginServlet
 */
@WebServlet("/StudentLoginServlet")
public class StudentLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		PrintWriter pw=response.getWriter();
		StudentServiceImpl stu=StudentServiceImpl.getInstance();
		//学生登陆
		String stuid=request.getParameter("username");
		String password=request.getParameter("password");
		ServerResponse<Student> severResponse=stu.Stulogin(Integer.parseInt(stuid), password);               //进行校验
		
		if(severResponse.isSucess()) {
			//在会话中保存学生信息
			session.setAttribute("student",severResponse.getData());
			//在会话中为学生创建购物车
			session.setAttribute("cart",new ArrayList<Course>());
			Student s = (Student)session.getAttribute("student");
			List<Course> c=(List<Course>)session.getAttribute("cart");
			//创建cookie
			Cookie stuname_cookie=new Cookie("stuID",stuid);
			stuname_cookie.setMaxAge(7*24*3600);
			response.addCookie(stuname_cookie);
			Cookie stupassword_cookie=new Cookie("stuPassword",password);  
			stupassword_cookie.setMaxAge(7*24*3600);
			response.addCookie(stupassword_cookie);
		}
		pw.write(severResponse.obj2str());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
