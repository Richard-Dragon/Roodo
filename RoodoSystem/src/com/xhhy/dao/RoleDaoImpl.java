package com.xhhy.dao;

import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.xhhy.bean.RoleBean;
import com.xhhy.util.JdbcTemplate;

public class RoleDaoImpl extends JdbcTemplate implements RoleDao {

	@Override
	public List<RoleBean> getAllRoles() {
		// TODO Auto-generated method stub
		List<RoleBean> rl=new ArrayList<RoleBean>();
		String sql="select role_id,role_name,addtime,sort,remark,del from role_tb";
		ResultSet rs=this.querySt(sql);
		try {
			while(rs.next()){
				RoleBean rb=new RoleBean(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getInt(6));
				rl.add(rb);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.close();
		}
		return rl;
	}

}
