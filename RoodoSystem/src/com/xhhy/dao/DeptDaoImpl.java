package com.xhhy.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xhhy.bean.DeptBean;
import com.xhhy.util.JdbcTemplate;

public class DeptDaoImpl extends JdbcTemplate implements DeptDao {

	@Override
	public List<DeptBean> getAllDepts() {
		// TODO Auto-generated method stub
		List<DeptBean> dl=new ArrayList<DeptBean>();
		String sql="select dept_id,dept_name,up_dept,addtime,sort,remark,del from dept_tb";
		ResultSet rs=this.querySt(sql);
		try {
			while(rs.next()){
				DeptBean db=new DeptBean(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getString(6),rs.getInt(7));
				dl.add(db);	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.close();
		}
		return dl;
	}

	@Override
	public int getSort(String deptId) {
		// TODO Auto-generated method stub
		String sql="select sort from dept_tb where dept_id="+Integer.parseInt(deptId);
		ResultSet rs=this.querySt(sql);	
		int sort=-1;
        	 try {
        		 if(rs.next()){
				sort=rs.getInt(1);
        		 }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
        }finally{
        	this.close();
        }
		return sort;
	}

}
