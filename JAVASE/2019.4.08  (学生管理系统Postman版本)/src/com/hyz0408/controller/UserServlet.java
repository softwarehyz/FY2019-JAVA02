package com.hyz0408.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hyz0408.common.ServerResponse;
import com.hyz0408.common.UserOperation;
import com.hyz0408.common.StudentOperation;
import com.hyz0408.pojo.Student;
import com.hyz0408.pojo.User;
import com.hyz0408.service.impl.StudentServiceImpl;
import com.hyz0408.service.impl.UserServiceImpl;

/**
 * Servlet implementation class Application
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	StudentServiceImpl F2=StudentServiceImpl.getInstance();
    /**
     * Default constructor. 
     */
    public UserServlet() {
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
		//  1.��½     2.�˳� 
		request.setCharacterEncoding("utf-8");
		response.setContentType("test/html;charset=utf-8");
		String operation=request.getParameter("operation");//ѡ���½�����˳�
		UserServiceImpl oper=UserServiceImpl.getInstance();
		PrintWriter pw=response.getWriter();
        if(operation==null) {                                         //ѡ���½�����˳�
        	//���ؿͻ���  ��ʾ��operation���봫����
        }
        	int o1=Integer.parseInt(operation);
        	if(o1==UserOperation.USER_LOGIN.getOperation_type()) {
        		//���е�½����
        		String username=request.getParameter("username");
        		String password=request.getParameter("password");
        		ServerResponse<User> severResponse=oper.login(username, password);               //����У��
        		if(severResponse.isSucess()) {
        			//����cookie
        			Cookie username_cookie=new Cookie("username",username);
        			username_cookie.setMaxAge(7*24*3600);
        			response.addCookie(username_cookie);
        			Cookie password_cookie=new Cookie("password",password);  
        			password_cookie.setMaxAge(7*24*3600);
        			response.addCookie(password_cookie);
        		}
        		pw.write(severResponse.obj2str());
        }else if(o1==UserOperation.USER_EXITS.getOperation_type()) {
        	                             //�˳�����
        }
    }
}