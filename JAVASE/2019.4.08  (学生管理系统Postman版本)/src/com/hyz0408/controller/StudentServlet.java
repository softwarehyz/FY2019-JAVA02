package com.hyz0408.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.hyz0408.common.Rise_Down;
import com.hyz0408.common.ServerResponse;
import com.hyz0408.common.StudentOperation;
import com.hyz0408.pojo.Student;
import com.hyz0408.service.impl.StudentServiceImpl;
import com.hyz0408.service.impl.UserServiceImpl;

/**
 * Servlet implementation class StudentServlet
 */
@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	StudentServiceImpl F2=StudentServiceImpl.getInstance();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		 String view=request.getParameter("ViewWay");//查看学生信息
		 String look=request.getParameter("Look");//选择查看方式
		 String ID=request.getParameter("ID");
		 String stuid=request.getParameter("stuid");
		 String name=request.getParameter("name");
		 String sex=request.getParameter("sex"); 
		 String score=request.getParameter("score");  
		 String age=request.getParameter("age"); 
		 String grade=request.getParameter("grade"); 
		 String addr=request.getParameter("addr"); 
		 String phone=request.getParameter("phone"); 
		 String email=request.getParameter("email"); 
		 String delID=request.getParameter("delID"); 
		 String altID=request.getParameter("altID"); 
		 UserServiceImpl oper=UserServiceImpl.getInstance();
		 
		PrintWriter pw=response.getWriter();
		
		int viewway=Integer.parseInt(view);
		if(viewway==StudentOperation.VIEW_ALL.getViewWay_type()) {
			/*
			 * int lookstyle=Integer.parseInt(look);
			 * if(lookstyle==Rise_Down.RISE_LOOK.getLook_type()) { ServerResponse<Student>
			 * responseText1=F2.ScoreRise(); pw.write(responseText1.obj2str()); pw.close();
			 * }else if(lookstyle==Rise_Down.DOWN_LOOK.getLook_type()) {
			 * ServerResponse<Student> responseText1=F2.ScoreDown();
			 * pw.write(responseText1.obj2str()); pw.close(); }
			 */
			ServerResponse<Student> responseText1=F2.ViewInfo();
			 pw.write(responseText1.obj2str()); 
			 pw.close(); 
		}else if(viewway==StudentOperation.VIEW_ID.getViewWay_type()) {
			 int _ID=Integer.parseInt(ID);
			ServerResponse<Student> responseText1=F2.ViewByID(_ID);
			pw.write(responseText1.obj2str());
			pw.close();
		}else if(viewway==StudentOperation.ADD_STUDENT.getViewWay_type()) {
			int _stuid=Integer.parseInt(stuid);
			int _age=Integer.parseInt(age);
			int _score=Integer.parseInt(score);
			ServerResponse<Student> responseText1=F2.addStudent(_stuid,name,sex,_score,_age,grade,addr,phone,email);
			pw.write(responseText1.obj2str());
			pw.close();
		}else if(viewway==StudentOperation.DEL_STUDENT.getViewWay_type()) {
			int _delID=Integer.parseInt(delID);
			ServerResponse<Student> responseText1=F2.delStudent(_delID);
			pw.write(responseText1.obj2str());
			pw.close();
		}else if(viewway==StudentOperation.ALTER_STUDENT.getViewWay_type()) {
			int _age=Integer.parseInt(age);
			int _score=Integer.parseInt(score);
			int _altID=Integer.parseInt(altID);
			ServerResponse<Student> responseText1=F2.alterStudent(_altID,name,sex,_score,_age,grade,addr,phone,email);
			pw.write(responseText1.obj2str());
			pw.close();
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
