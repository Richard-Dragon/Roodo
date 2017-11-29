/**
 * JDBC模板类
 */
package com.xhhy.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Properties;

public class JdbcTemplate {
	// 连接参数
	private static String driver;
	private static String url;
	private static String user;
	private static String password ;

	// 连接 通道 结果集对象
	private static Connection conn = null;
	private static Statement st = null;
	private static PreparedStatement ps = null;
	private static ResultSet rs = null;

	// 注册驱动
	static {
		try {
			InputStream in = JdbcTemplate.class.getClassLoader().getResourceAsStream("jdbc.properties");
			Properties pro = new Properties();
			pro.load(in);
			driver = pro.getProperty("driver");
			user = pro.getProperty("user");
			password = pro.getProperty("password");
			url = pro.getProperty("url");
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("注册驱动失败!");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 获得连接
	 */
	public void getConnection() {
		try {
			conn = DriverManager.getConnection(url, user, password);
			conn.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("连接失败!");
			e.printStackTrace();
		}
	}

	/**
	 * 创建状态通道
	 */
	public void createStatement() {
		this.getConnection();
		try {
			st = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("创建状态通道失败!");
			e.printStackTrace();
		}
	}

	/**
	 * 创建预状态通道
	 * 
	 * @param sql
	 */
	public void prepareStatement(String sql) {
		this.getConnection();
		try {
			ps = conn.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("创建预状态通道失败!");
			e.printStackTrace();
		}
	}

	/**
	 * 基于状态通道的增删改 操作
	 * 
	 * @return
	 */
	public boolean updateSt(String sql) {
		boolean is = true;
		this.createStatement();
		try {
			st.executeUpdate(sql);
			this.myCommit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("基于状态通道的操作失败!");
			is = false;
			e.printStackTrace();
			this.myRollBack();
		}
		return is;
	}

	/**
	 * 基于状态通道的查询
	 * 
	 * @param sql
	 * @return
	 */
	public ResultSet querySt(String sql) {
		this.createStatement();
		try {
			rs = st.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("基于状态通道的查询失败!");
			e.printStackTrace();
		}
		return rs;
	}

	/**
	 * 绑定参数
	 * 
	 * @param params
	 * @throws SQLException
	 */
	private void bandle(String[] params) throws SQLException {
		if (params != null && params.length > 0) {
			for (int i = 0; i < params.length; i++) {
				ps.setString(i + 1, params[i]);
			}
		}
	}

	/**
	 * 基于预状态通道的操作
	 * 
	 * @param sql
	 * @param params
	 * @return
	 */
	public boolean updatePs(String sql, String[] params) {
		this.prepareStatement(sql);
		boolean is = true;
		try {
			this.bandle(params);
			ps.executeUpdate();
			this.myCommit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("基于预状态通道的操作失败!");
			is = false;
			e.printStackTrace();
			this.myRollBack();
		}
		return is;
	}

	/**
	 * 基于预状态通道的查询
	 * 
	 * @param sql
	 * @param params
	 * @return
	 */
	public ResultSet queryPs(String sql, String[] params) {
		this.prepareStatement(sql);
		try {
			this.bandle(params);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("基于预状态通道的查询失败!");
			e.printStackTrace();
		}
		return rs;
	}

	/**
	 * 基于状态通道的批处理
	 * @param sqls
	 * @return
	 */
	public boolean batchSt(List<String> sqls){
		boolean is = true;
		this.createStatement();
		try {
			for(int i =0;i<sqls.size();i++){
				st.addBatch(sqls.get(i));
			}
			st.executeBatch();
			this.myCommit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			is = false;
			this.myRollBack();
			System.out.println("基于状态通道的事务处理失败了!");
		}
		return is;
	}
	
	/**
	 * 基于预状态通道的批处理
	 * @param sql
	 * @param params
	 * @return
	 */
	public boolean batchPs(String sql,List<String[]> params){
		boolean is = true;
		this.prepareStatement(sql);
		try {
			for(int i=0;i<params.size();i++){
				String[] p = params.get(i);
				this.bandle(p);
				ps.addBatch();
			}
			ps.executeBatch();
			this.myCommit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			is = false;
			this.myRollBack();
			System.out.println("基于预状态通道的额批处理失败了!");
		}
		return is;
	}
	
	
	/**
	 * 提交
	 * 如果SQL语句操作成功 那么把操作结果更新到数据库中
	 */
	public void myCommit(){
		try {
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 回滚
	 * 如果多个SQL语句中有错误出现 那么这件事就没有成功  
	 * 需要把数据恢复到做这件事之前
	 */
	public void myRollBack(){
		try {
			conn.rollback();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 关闭资源
	 */
	public void close() {
		try {
			if (rs != null) {
				rs.close();
			}
			if(st != null){
				st.close();
			}
			if(ps != null){
				ps.close();
			}
			if(conn != null){
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
