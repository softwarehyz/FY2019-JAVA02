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
import com.hyz0408.service.UserService;
import com.hyz0408.service.impl.UserServiceImpl;


/**
 * Servlet implementation class SessionServlet
 */
@WebServlet("/session")
public class SessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SessionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//
		/*String _param=request.getParameter("parameter");
		if(_param.equals("1")) {
			System.out.println(request.hashCode());
			 request.setAttribute("token", System.currentTimeMillis());
		}else if(_param.equals("2")) {
			System.out.println(request.getAttribute("token"));
			System.out.println(request.hashCode());
		}
	 */
		//会话
		HttpSession session=request.getSession();
		String JESSIONID=session.getId(); //TOKEN
		//System.out.println("sessionServlet sessinid:"+JESSIONID);
		
		
		
		//判断用户是否登录过
		
		Object o=session.getAttribute("user");
		//System.out.println(o);
		
		
		Cookie[] cookies=request.getCookies();
		
		String username=null;
		String password=null;
		if(cookies!=null) {
			
			for(int i=0;i<cookies.length;i++) {
				Cookie cookie=cookies[i];
				String cookie_name=cookie.getName();
				String cookie_value=cookie.getValue();
				if(cookie_name.equals("username")) {
					username=cookie_value;
				}
				if(cookie_name.equals("password")) {
					password=cookie_value;
				}
				
			}
			
		}
		
		
		if(username!=null&&password!=null) {
			
			UserService service=UserServiceImpl.getInstance();
			ServerResponse serverResponse=service.login(username, password);
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