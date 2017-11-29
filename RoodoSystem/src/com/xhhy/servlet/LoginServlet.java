package com.xhhy.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xhhy.bean.UserBean;
import com.xhhy.service.UserService;
import com.xhhy.service.UserServiceImpl;
import com.xhhy.util.State;

public class LoginServlet extends HttpServlet {
   
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}
     UserService us=new UserServiceImpl();
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String loginName = request.getParameter("loginname");
		String password = request.getParameter("password");
		String remember =request.getParameter("remember");
		String vfCode=request.getParameter("yzm");
		String s=(String)request.getSession().getAttribute("number");
		UserBean ub=us.Index(loginName, password);
		ServletContext sc=request.getServletContext();
		if(vfCode.equalsIgnoreCase(s)){
			List<UserBean> userOnline=null;
			if(ub!=null){
				if(ub.getDel()==State.DELETE){
				request.setAttribute("msg", "该账号已被禁用。");
				request.getRequestDispatcher("login.jsp").forward(request, response);;
			}else{
					Object o=sc.getAttribute("uo");
					if(o==null){
						userOnline=new ArrayList<UserBean>();
					}else{
						userOnline=(List<UserBean>)o;
					}
					boolean is=true;
					for (int i = 0; i <userOnline.size(); i++) {
						UserBean u=userOnline.get(i);
						if(ub.getUserId()==u.getUserId()){
							is=false;
							break;
						}
					}
					if(is){
						userOnline.add(ub);
						sc.setAttribute("uo", userOnline);
						request.getSession().setAttribute("ub", ub);
						/*Cookie c1=new Cookie("loginname",loginName);
						Cookie c2=new Cookie("password",password);
						if(remember!=null){
							c1.setMaxAge(60*60*24*Integer.parseInt(remember));
							c2.setMaxAge(60*60*24*Integer.parseInt(remember));
						}else{
							c2.setMaxAge(0);
						}
						c1.setPath("/");
						c2.setPath("/");
						response.addCookie(c1);
						response.addCookie(c2);*/
						request.getRequestDispatcher("index.jsp").forward(request, response);
					}else{
//						System.out.println("yidenglu");
						request.setAttribute("msg", "该账号已登录。");
						request.getRequestDispatcher("login.jsp").forward(request, response);
					}
				}
			}else{
			request.setAttribute("msg", "账号或密码错误。");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		}else{
			request.setAttribute("vfmsg", "验证码错误!");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
	}

}
