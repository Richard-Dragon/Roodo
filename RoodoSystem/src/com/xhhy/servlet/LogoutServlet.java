/**
 * 安全退出
 */
package com.xhhy.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.xhhy.bean.UserBean;

public class LogoutServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/**
		 * 退出，1 在线列表删除，2 销毁session对象。 3 转到登录页面。
		 */
    request.setCharacterEncoding("utf-8");
     ServletContext sc=this.getServletContext();
     HttpSession session=request.getSession();
     UserBean ub=(UserBean)session.getAttribute("ub");
     List<UserBean> l=(List)sc.getAttribute("uo");
     for (int i = 0; i < l.size(); i++) {
		UserBean u=l.get(i);
		if(u!=null && u.getUserId()==ub.getUserId()){
			l.remove(i);
			break;
		}
	}
     sc.setAttribute("uo", l);
     session.invalidate();
     response.sendRedirect("login.jsp");
	}

}
