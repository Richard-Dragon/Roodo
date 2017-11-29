package com.xhhy.listener;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.xhhy.bean.UserBean;

public class LoginListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
	HttpSession session=arg0.getSession();
	ServletContext sc=session.getServletContext();
	UserBean ub=(UserBean)session.getAttribute("ub");
	List<UserBean> uo=(List)sc.getAttribute("uo");
	if(ub!=null && uo!=null){
		for (int i = 0; i < uo.size(); i++) {
			UserBean u=uo.get(i);
			if(u!=null && ub.getUserId()==u.getUserId()){
				uo.remove(i);
				break;
			}
		}
	}
	sc.setAttribute("uo", uo);
	}

}
