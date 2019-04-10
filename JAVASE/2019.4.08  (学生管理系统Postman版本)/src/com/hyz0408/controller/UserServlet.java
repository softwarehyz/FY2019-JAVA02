package com.hyz0408.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hyz0408.common.BookOperation;
import com.hyz0408.common.ServerResponse;
import com.hyz0408.common.UserChoice;
import com.hyz0408.common.UserOperation;
import com.hyz0408.pojo.Student;
import com.hyz0408.service.impl.CourseServiceImpl;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 ServletContext servletContext=request.getServletContext();
		 PrintWriter pw=response.getWriter();
		 CourseServiceImpl C2=CourseServiceImpl.getInstance();
		String userchoice=request.getParameter("UserChoice");
 		String bookoperation=request.getParameter("BookOperation");
 		String ID=request.getParameter("ID");
 		String cname=request.getParameter("Cname");
 		int o1=Integer.parseInt(userchoice);
		if(o1==UserChoice.ONLINE_BUM.getChoose_type()) {
        	Integer total=(Integer)servletContext.getAttribute("total");
        	ServerResponse responseText=ServerResponse.createServerResponseBySucess("查看成功", total);
        	pw.write(responseText.obj2str());
        }else if(o1==UserChoice.BOOK_OPERATION.getChoose_type()) {
        	int o2=Integer.parseInt(bookoperation);
        	if(o2==BookOperation.BOOK_LOOK.getOperation_type()) {
        		ServerResponse responseText1=C2.ViewCourse();
   			 pw.write(responseText1.obj2str()); 
   			 pw.close(); 
        	}else if(o2==BookOperation.BOOK_LOOKBYID.getOperation_type()) {
        		int id=Integer.parseInt(ID);
    			ServerResponse<Student> responseText1=C2.ViewCourseByID(id);
    			pw.write(responseText1.obj2str());
    			pw.close();
        	}else if(o2==BookOperation.BOOK_ADD.getOperation_type()) {
        		int id=Integer.parseInt(ID);
    			ServerResponse<Student> responseText1=C2.AddCourse(id,cname);
    			pw.write(responseText1.obj2str());
    			pw.close();
        	}else if(o2==BookOperation.BOOK_ALTER.getOperation_type()) {
        		int id=Integer.parseInt(ID);
    			ServerResponse<Student> responseText1=C2.AlterCourse(id,cname);
    			pw.write(responseText1.obj2str());
    			pw.close();
        	}else if(o2==BookOperation.BOOK_DEL.getOperation_type()) {
        		int id=Integer.parseInt(ID);
    			ServerResponse<Student> responseText1=C2.DelCourse(id);
    			pw.write(responseText1.obj2str());
    			pw.close();
        	}
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
