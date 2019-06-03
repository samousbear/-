package com.woniu.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BaseDAO<T> {
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;
	public void update(String sql,Object[] objs){
		try {
			conn = JdbcUtils.getConn();
			ps = conn.prepareStatement(sql);
			for(int i=0;i<objs.length;i++){
				ps.setObject(i+1, objs[i]);
			}
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			JdbcUtils.closeConn(null, ps, conn);
		}
	}
	public List<T> select(String sql,Object[] objs,Class<T> c){
		List<T> list = new ArrayList<T>();
		try {
			conn = JdbcUtils.getConn();
			ps = conn.prepareStatement(sql);
			for(int i=0;i<objs.length;i++){
				ps.setObject(i+1, objs[i]);
			}
			rs = ps.executeQuery();
			while(rs.next()){
				//Course course = new Course();
				T t = (T) c.newInstance();
				//获得Course类中所有的方法
				Method[] methods = c.getMethods();
				for(int i=0;i<methods.length;i++){
					//取出每个方法对象
					Method m = methods[i];
					//取出方法名
					String mName = m.getName();
					//获得所有的set方法  setCname
					if(mName.startsWith("set")){
						//cname cno tno 获得列名
						String fieldName = mName.substring(3);
						//获得方法的参数列表类型  setUid(Integer uid); {Integer.class}
						Class[] cs = m.getParameterTypes();
						if(cs[0]==Integer.class){
							m.invoke(t, rs.getInt(fieldName));
						}else if(cs[0]==String.class){
							//调用自己  course.setCno(rs.getString("cno"));
							m.invoke(t, rs.getString(fieldName));
						}else if(cs[0]==Date.class){
							//调用自己  course.setCno(rs.getString("cno"));
							m.invoke(t, rs.getDate(fieldName));
						}else if(cs[0]==Double.class){
							//调用自己  course.setCno(rs.getString("cno"));
							m.invoke(t, rs.getDouble(fieldName));
						}else if(cs[0]==Float.class){
							//调用自己  course.setCno(rs.getString("cno"));
							m.invoke(t, rs.getFloat(fieldName));
						}
					}
				}
				list.add(t);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			JdbcUtils.closeConn(rs, ps, conn);
		}
		return list;
	}
}
