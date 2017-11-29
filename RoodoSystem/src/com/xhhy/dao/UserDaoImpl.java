package com.xhhy.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xhhy.bean.UserBean;
import com.xhhy.bean.UserParam;
import com.xhhy.util.JdbcTemplate;
import com.xhhy.util.PageUtil;
import com.xhhy.util.State;

public class UserDaoImpl extends JdbcTemplate implements UserDao {

	@Override
	public UserBean Index(String loginName, String password) {
		UserBean ub = null;
		String sql = "select user_id,loginname,password,user_name,sex,id_card,phone,mobilephone,"
				+ "email,address,dept_id,role_id,remark,sort,addtime,del from user_tb"
				+ " where loginname=? and password=?";
		String[] params = { loginName, password };
		ResultSet rs = this.queryPs(sql, params);
		try {
			if (rs.next()) {
				ub = new UserBean(rs.getInt(1), rs.getString(2),
						rs.getString(3), rs.getString(4), rs.getInt(5),
						rs.getString(6), rs.getString(7), rs.getString(8),
						rs.getString(9), rs.getString(10), rs.getInt(11),
						rs.getInt(12), rs.getString(13), rs.getInt(14),
						rs.getString(15), rs.getInt(16));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.close();
		}
		return ub;
	}

	@Override
	public List<UserBean> show(PageUtil pu,UserParam up) {
		List<UserBean> l = new ArrayList<UserBean>();
		StringBuffer sql = new StringBuffer();
		sql.append("select u.user_id,u.loginname,u.password,u.user_name,u.sex,u.id_card,u.phone,u.mobilephone,u.email,");
		sql.append("u.address,u.dept_id,u.role_id,u.remark,u.sort,u.addtime,u.del,d.dept_name,r.role_name ");
		sql.append("from user_tb u,dept_tb d,role_tb r where u.dept_id=d.dept_id ");
		sql.append("and u.role_id=r.role_id and u.del="+State.UNDELETE );
		if(up!=null){
			if(up.getUserName()!=null && !"".equals(up.getUserName()) ){
			sql.append(" and u.user_name like '"+up.getUserName()+"%'");	
			}
			if(up.getSex()!=null && !"".equals(up.getSex())&& ! "999".equals(up.getSex())){
				sql.append(" and u.sex="+up.getSex());
			}
			if(up.getDeptId()!=null && !"".equals(up.getDeptId()) && !"999".equals(up.getDeptId())){
				sql.append(" and u.dept_id="+up.getDeptId());
			}
			if(up.getStartTime()!=null &&!"".equals(up.getStartTime()) ){
				sql.append(" and u.addtime >= '"+up.getStartTime()+"'");
			}
			if(up.getEndTime()!=null && !"".equals(up.getEndTime())){
				sql.append(" and u.addtime <= '"+up.getEndTime()+"'");
			}
		}
		sql.append(" order by u.sort,u.user_id ");
		if(pu!=null){
			sql.append("limit "+(pu.getPageNum()-1)*pu.getPageRows()+","+pu.getPageRows());
		}
		ResultSet rs = this.querySt(sql.toString());
		try {
			while (rs.next()) {
				UserBean ub = new UserBean(rs.getInt(1), rs.getString(2),
						rs.getString(3), rs.getString(4), rs.getInt(5),
						rs.getString(6), rs.getString(7), rs.getString(8),
						rs.getString(9), rs.getString(10), rs.getInt(11),
						rs.getInt(12), rs.getString(13), rs.getInt(14),
						rs.getString(15), rs.getInt(16), rs.getString(17),
						rs.getString(18));
				l.add(ub);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.close();
		}
		return l;
	}

	@Override
	public UserBean look(String userId) {
		UserBean ub = new UserBean();
		String sql = " select u.user_id,u.loginname,u.password,u.user_name,u.sex,u.id_card,u.phone,u.mobilephone,"
				+ "u.email,u.address,u.dept_id,u.role_id,u.remark,u.sort,u.addtime,u.del,d.dept_name,r.role_name "
				+ "from user_tb u,dept_tb d,role_tb r where u.dept_id=d.dept_id and u.role_id=r.role_id and u.user_id="+userId;
		ResultSet rs = this.querySt(sql);
		try {
			if (rs.next()) {
				ub = new UserBean(rs.getInt(1), rs.getString(2),
						rs.getString(3), rs.getString(4), rs.getInt(5),
						rs.getString(6), rs.getString(7), rs.getString(8),
						rs.getString(9), rs.getString(10), rs.getInt(11),
						rs.getInt(12), rs.getString(13), rs.getInt(14),
						rs.getString(15), rs.getInt(16), rs.getString(17),
						rs.getString(18));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.close();
		}
		return ub;
	}

	@Override
	public boolean deleteUser(String dus) {
		// TODO Auto-generated method stub
		List<String> sqls=new ArrayList();
		String[] userIds=dus.split(",");
		for (int i = 0; i < userIds.length; i++) {
			if(userIds[i] != null && !"".equals(userIds[i]) ){
				String sql="update user_tb set del="+State.DELETE+" where user_id="+userIds[i];
				sqls.add(sql);
			}
		}
		boolean is=this.batchSt(sqls);
		return is;
	}

	@Override
	public boolean edit(UserBean ub) {
		// TODO Auto-generated method stub
		String sql="update user_tb set sex=?,dept_id=?,role_id=? where user_id=?";
		String[] params={ub.getSex()+"",ub.getDeptId()+"",ub.getRoleId()+"",ub.getUserId()+""};
		boolean is=this.updatePs(sql, params);
		return is;
	}

	@Override
	public boolean addUser(UserBean ub) {
		// TODO Auto-generated method stub
		String sql="insert into user_tb value(null,?,?,?,?,?,?,?,?,?,?,?,?,?,now(),?)";
		String[] params={ub.getLoginName(),ub.getPassword(),ub.getUserName(),ub.getSex()+"",ub.getIdCard(),ub.getPhone(),
				ub.getMobilePhone(),ub.getEmail(),ub.getAddress(),ub.getDeptId()+"",ub.getRoleId()+"",ub.getRemark(),
				ub.getSort()+"",ub.getDel()+""};
		boolean is=this.updatePs(sql, params);
		return is;
	}

	@Override
	public int getCount(UserParam up) {
		// TODO Auto-generated method stub
		StringBuffer sql=new StringBuffer("select count(user_id) from user_tb where del="+State.UNDELETE);
		if(up!=null){
			if(up.getUserName()!=null && !"".equals(up.getUserName()) ){
			sql.append(" and user_name like '"+up.getUserName()+"%'");	
			}
			if(up.getSex()!=null && !"".equals(up.getSex())&& !"999".equals(up.getSex())){
				sql.append(" and sex="+up.getSex());
			}
			if(up.getDeptId()!=null && !"".equals(up.getDeptId()) && !"999".equals(up.getDeptId())){
				sql.append(" and dept_id="+up.getDeptId());
			}
			if(up.getStartTime()!=null &&!"".equals(up.getStartTime()) ){
				sql.append(" and addtime >= '"+up.getStartTime()+"'");
			}
			if(up.getEndTime()!=null && !"".equals(up.getEndTime())){
				sql.append(" and addtime <= '"+up.getEndTime()+"'");
			}
		}
		ResultSet rs=this.querySt(sql.toString());
		int count=0;
		try {
			if(rs.next()){
				count=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.close();
		}		
		return count;
	}
   public UserBean oneName(String loginName){
	   String sql="select user_id,loginname,user_name from user_tb where loginname='"+loginName+"'";
	   ResultSet rs=this.querySt(sql);
	   UserBean u=null;
	   try {
		if(rs.next()){
			u=new UserBean();
			   u.setUserId(rs.getInt(1));
			   u.setLoginName(rs.getString(2));
			   u.setUserName(rs.getString(3));
		   }
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		this.close();
	}
	   return u;
   }

@Override
public List<UserBean> autoComplete(String userName) {
	// TODO Auto-generated method stub
	List<UserBean> l=new ArrayList<UserBean>();
	UserBean u=null;
	String sql="select user_name from user_tb where user_name like '"+userName+"%'";
	ResultSet rs=this.querySt(sql);
	try {
		while(rs.next()){
			u=new UserBean();
			u.setUserName(rs.getString(1));
			l.add(u);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		this.close();
	}
	return l;
}
   
}
