package com.hyz0408.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hyz0408.common.ServerResponse;
import com.hyz0408.common.StudentCourseOperation;
import com.hyz0408.pojo.Course;
import com.hyz0408.pojo.Student;
import com.hyz0408.service.impl.CourseServiceImpl;
import com.hyz0408.service.impl.StudentChooseCourseImpl;

/**
 * Servlet implementation class StudentChooseCourse
 */
@WebServlet("/StudentChooseCourse")
public class StudentChooseCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentChooseCourse() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//ѧ��ѡ�β���   ѧ����½�ɹ����½��Ự���������ﳵ���������ѧ��ѡ��Ŀγ���Ϣ
		//��ȡѧ���Ự
		HttpSession session=request.getSession();
//		Student s = (Student)session.getAttribute("student");
//		List<Course> c=(List<Course>)session.getAttribute("cart");
		CourseServiceImpl C1=CourseServiceImpl.getInstance();
		//��ȡ���ĿյĹ��ﳵ
		List<Course> course1=(List<Course>)session.getAttribute("cart");
		Student student=(Student)session.getAttribute("student");
		String CourseOperation=request.getParameter("CourseOperation");
		StudentChooseCourseImpl service=new StudentChooseCourseImpl();
		String cid=request.getParameter("Cid");
		int c1=Integer.parseInt(CourseOperation);
		if(c1==StudentCourseOperation.STUDENT_LOOK_COURSE.getOperation_type()) {
			ServerResponse serverResponse=service.LookCourse();
		    response.getWriter().write(serverResponse.obj2str());
		}else if(c1==StudentCourseOperation.STUDENT_ADD_COURSE.getOperation_type()) {
			//ѧ����ӿγ�
			ServerResponse serverResponse=service.chooseCourse(Integer.parseInt(cid), course1);
		    response.getWriter().write(serverResponse.obj2str());
		}else if(c1==StudentCourseOperation.STUDENT_DEL_COURSE.getOperation_type()) {
			 //ѧ��ɾ���γ�
			ServerResponse serverResponse=service.DelCourse(Integer.parseInt(cid), course1);
		    response.getWriter().write(serverResponse.obj2str());
		}else if(c1==StudentCourseOperation.STUDENT_CHOOSED_COURSE.getOperation_type()) {
			ServerResponse serverResponse=service.ChoosedCourse(course1);
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
