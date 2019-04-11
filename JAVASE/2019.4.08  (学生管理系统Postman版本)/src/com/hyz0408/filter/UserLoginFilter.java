package com.hyz0408.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hyz0408.common.Constant;
import com.hyz0408.common.ServerResponse;
import com.hyz0408.pojo.User;

/**
 * Servlet Filter implementation class UserLoginFilter
 */
@WebFilter({"/UserServlet","/StudentServlet"})
public class UserLoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public UserLoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		HttpServletRequest _request=(HttpServletRequest) request;
		@SuppressWarnings("unused")
		HttpServletResponse _response=(HttpServletResponse) response;
         HttpSession session=_request.getSession();
         User user=(User)session.getAttribute("user");
		if(user==null) {
			PrintWriter pw=response.getWriter();
			ServerResponse responseText=ServerResponse.createServerResponseByFail(Constant.USER_NOT_LOGIN, "Î´µÇÂ½");
            pw.write(responseText.obj2str());
            pw.close();
            return;
		}
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
