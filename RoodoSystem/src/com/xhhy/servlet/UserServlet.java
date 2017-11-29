package com.xhhy.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.xhhy.bean.DeptBean;
import com.xhhy.bean.RoleBean;
import com.xhhy.bean.UserBean;
import com.xhhy.bean.UserParam;
import com.xhhy.service.DeptService;
import com.xhhy.service.DeptServiceImpl;
import com.xhhy.service.RoleService;
import com.xhhy.service.RoleServiceImpl;
import com.xhhy.service.UserService;
import com.xhhy.service.UserServiceImpl;
import com.xhhy.util.PageUtil;
import com.xhhy.util.State;

public class UserServlet extends HttpServlet {

	private UserService us=new UserServiceImpl();
	private DeptService ds=new DeptServiceImpl();
	private RoleService rs=new RoleServiceImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
       this.doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String method=request.getParameter("method");
		if("look".equals(method)){
			look(request,response);
		}else if("delete".equals(method)){
			deleteUser(request,response);
			
		}else if("pedit".equals(method)){
			peditUser(request,response);
		}else if("edit".equals(method)){
			editUser(request,response);
		}else if("padd".equals(method)){
			paddUser(request,response);
		}else if("add".equals(method)){
			addUser(request,response);
		}else if("onename".equals(method)){
			oneName(request,response);
		}else if("auto".equals(method)){
			autoComplete(request,response);
		}else{
			info(request,response);
		}
		
	}
    //展示所有用户信息。
	public void info(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session=request.getSession();
		String flag=request.getParameter("flag");
		if(flag!=null && !"".equals(flag)){
			session.removeAttribute("up");
		}
		UserParam up=null;
		Object obj=session.getAttribute("up");
		if(obj==null){
			String userName=request.getParameter("username");
			String sex=request.getParameter("sex");
			String deptId=request.getParameter("dept");
			String startTime=request.getParameter("starttime");
			String endTime=request.getParameter("endtime");
			up=new UserParam(userName,sex,deptId,startTime,endTime);
			
		}else{
			up=(UserParam)obj;
		}
		int pageNum=1;//页码。
		String pn=request.getParameter("pageNum");
		if(pn!=null){
			pageNum=Integer.parseInt(pn);
		}
		PageUtil pu=new PageUtil(pageNum,State.PAGEROWS,us.getCount(up));
		List<UserBean> l=us.show(pu,up);
		request.setAttribute("list", l);
		//查询所有的部门。
		List<DeptBean> dl=ds.getAllDepts();
		request.setAttribute("dl", dl);
		request.setAttribute("pu", pu);
		session.setAttribute("up", up);
		request.getRequestDispatcher("sys/employee/list.jsp").forward(request,response);
	}
	//根据用户编号查看用户信息
	public void look(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String userId=request.getParameter("userid");
		UserBean ub=us.look(userId);
		request.setAttribute("ub", ub);
		request.getRequestDispatcher("sys/employee/view.jsp").forward(request, response);
	}
	//根据选中的用户编号状态删除
	public void deleteUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String dus=request.getParameter("dus");
		boolean is=us.deleteUser(dus);
		if(is){
			request.setAttribute("msg", "删除成功.");
		/*	request.getRequestDispatcher("UserServlet.do").forward(request, response);*/
		}else{
			request.setAttribute("msg", "删除失败。");
		/*	request.getRequestDispatcher("UserServlet.do").forward(request, response);*/
		}
		info(request,response);
	}
	//根据用户编号修改用户信息。
	public void peditUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String userId=request.getParameter("userid");
		UserBean ub=us.look(userId);//借用查看方法拿到用户所有信息
		request.setAttribute("ub", ub);
		List<DeptBean> dl=ds.getAllDepts();
		request.setAttribute("dl", dl);
		List<RoleBean> rl=rs.getAllRoles();
		request.setAttribute("rl", rl);
		request.getRequestDispatcher("sys/employee/edit.jsp").forward(request, response);
	}
	public void editUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String userId=request.getParameter("userid");
		String sex=request.getParameter("sex");
		String deptId=request.getParameter("dept");
		String roleId=request.getParameter("role");
		UserBean ub=new UserBean();
		ub.setUserId(Integer.parseInt(userId));
		ub.setSex(Integer.parseInt(sex));
		ub.setDeptId(Integer.parseInt(deptId));
		ub.setRoldId(Integer.parseInt(roleId));
		boolean is=us.edit(ub);
		if(!is){
			request.setAttribute("msg", "修改失败。");
		}		
		info(request,response);
		}
	public void paddUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		List<DeptBean> dl=ds.getAllDepts();
		request.setAttribute("dl", dl);
		List<RoleBean> rl=rs.getAllRoles();
		request.setAttribute("rl", rl);
		request.getRequestDispatcher("sys/employee/add.jsp").forward(request, response);
	}
	public void addUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String userName=request.getParameter("username");
		String sex=request.getParameter("sex");
		String loginName=request.getParameter("loginname");
		String password=request.getParameter("password");
		String idCard=request.getParameter("idcard");
		String phone=request.getParameter("phone");
		String mobilePhone=request.getParameter("mobilephone");
		String email=request.getParameter("email");
		String address=request.getParameter("address");
		String deptId=request.getParameter("dept");
		String roleId=request.getParameter("role");
		String remark=request.getParameter("remark");
		int sort=ds.getSort(deptId);
		UserBean ub=new UserBean(0,loginName, password,userName,Integer.parseInt(sex),
				idCard,phone,mobilePhone,email,address,Integer.parseInt(deptId),
				Integer.parseInt(roleId), remark,sort,null, State.UNDELETE);
		boolean is=us.addUser(ub);	
		if(is){
			request.setAttribute("msg", "添加成功");
		}else{
			request.setAttribute("msg", "添加失败");
		}
		info(request,response);
	}
	public void oneName(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
	   String loginName=request.getParameter("loginname");
	   response.setContentType("text/html;charset=utf-8");
	   PrintWriter out= response.getWriter();
	   UserBean u=us.oneName(loginName);
	   if(u!=null){
		   //账号存在
		   out.write("0");
	   }else{
		   //账号不存在
		   out.write("1");
	   }
	   out.flush();
	   out.close();
	}
	public void autoComplete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
	   String userName=request.getParameter("username");
	   List<UserBean> l=us.autoComplete(userName);
	   Gson g=new Gson();
	   String s=g.toJson(l);
//	   System.out.println(s);
	   response.setContentType("text/html;charset=utf-8");
	   PrintWriter out=response.getWriter();
	   out.write(s);
	   out.flush();
	   out.close();
	}
}
