package com.hyz0408.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hyz0408.common.ServerResponse;
import com.hyz0408.pojo.Student;
import com.hyz0408.service.StudentService;
import com.hyz0408.service.UserService;
import com.hyz0408.service.impl.StudentServiceImpl;
import com.hyz0408.service.impl.UserServiceImpl;

/**
 * Servlet implementation class StudentSession
 */
@WebServlet("/StudentSession")
public class StudentSession extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentSession() {
        super();
        // TODO Auto-generated constructor stub

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//System.out.println("sessionServlet sessinid:"+JESSIONID);
Cookie[] cookies=request.getCookies();
		
		String username=null;
		String password=null;
		if(cookies!=null) {
			
			for(int i=0;i<cookies.length;i++) {
				Cookie cookie=cookies[i];
				String cookie_name=cookie.getName();
				String cookie_value=cookie.getValue();
				if(cookie_name.equals("stuID")) {
					username=cookie_value;
				}
				if(cookie_name.equals("stuPassword")) {
					password=cookie_value;
				}
				
			}
			
		}
		
		
		if(username!=null&&password!=null) {
			
			StudentService service=StudentServiceImpl.getInstance();
			ServerResponse<Student> serverResponse=service.Stulogin(Integer.parseInt(username), password);
			response.getWriter().write(serverResponse.obj2str());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
