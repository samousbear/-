package com.woniu.dao;

import java.util.List;

import com.woniu.bean.Dept;
import com.woniu.bean.PageBean;
import com.woniu.util.BaseDAO;

public class DeptDAOImpl implements IDeptDAO {
	BaseDAO<Dept> bd = new BaseDAO<Dept>();
	@Override
	public void save(Dept dept) {
		String sql = "insert into dept values(?,?,?)";
		Object[] objs = {dept.getDeptno(),dept.getDname(),dept.getLoc()};
		bd.update(sql, objs);
	}

	@Override
	public void update(Dept dept) {
		// TODO Auto-generated method stub
		String sql = "update dept set dname=?,loc=? where deptno=?";
		Object[] objs = {dept.getDname(),dept.getLoc(),dept.getDeptno()};
		bd.update(sql, objs);
	}

	@Override
	public void delete(Integer deptno) {
		// TODO Auto-generated method stub
		String sql = "delete from dept where deptno=?";
		Object[] objs = {deptno};
		bd.update(sql, objs);
	}

	@Override
	public Dept findOne(Integer deptno) {
		// TODO Auto-generated method stub
		String sql = "select * from dept where deptno=?";
		Object[] objs = {deptno};
		List<Dept> list = bd.select(sql, objs,Dept.class);
		return list.size()==0?null:list.get(0);
	}

	@Override
	public List<Dept> findAll() {
		// TODO Auto-generated method stub
		String sql = "select * from dept";
		Object[] objs = {};
		List<Dept> list = bd.select(sql, objs,Dept.class);
		return list;
	}

	@Override
	public List<Dept> findAllByPage(PageBean pb) {
		String sql = "select * from dept limit ?,?";
		Object[] objs = {(pb.getPageNum()-1)*pb.getPageRow(),pb.getPageRow()};
		List<Dept> list = bd.select(sql, objs,Dept.class);
		return list;
	}

}
