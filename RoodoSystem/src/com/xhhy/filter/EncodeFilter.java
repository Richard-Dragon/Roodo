package com.xhhy.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EncodeFilter implements Filter {
   private String encode=null;
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest request=(HttpServletRequest)arg0;
		HttpServletResponse response=(HttpServletResponse)arg1;
		if(encode !=null && !"".equals(encode)){
			request.setCharacterEncoding(encode);
			response.setCharacterEncoding(encode);
		}else{
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
		}
		arg2.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		 encode=arg0.getInitParameter("encode");
		System.out.println(encode);

	}

}
