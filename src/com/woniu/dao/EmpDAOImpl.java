package com.woniu.dao;

import java.util.List;

import com.woniu.bean.Emp;
import com.woniu.bean.PageBean;
import com.woniu.util.BaseDAO;

public class EmpDAOImpl implements IEmpDAO {
	BaseDAO<Emp> bd =new BaseDAO<Emp>();
	@Override
	public void save(Emp emp) {
		String sql = "insert into emp values(?,?,?,?,?,?,?,?)";
		Object[] objs = {emp.getEmpno(),emp.getEname(),emp.getJob(),emp.getMgr(),emp.getHiredate(),emp.getSal(),emp.getComm(),emp.getDeptno()};
		bd.update(sql, objs);
	}

	@Override
	public void update(Emp emp) {
		String sql = "update emp set ename=?,job=?,mgr=?,hiredate=?,sal=?,comm=?,deptno=? where empno=?";
		Object[] objs = {emp.getEname(),emp.getJob(),emp.getMgr(),emp.getHiredate(),emp.getSal(),emp.getComm(),emp.getDeptno(),emp.getEmpno()};
		bd.update(sql, objs);

	}

	@Override
	public void delete(Integer empno) {
		// TODO Auto-generated method stub
		String sql = "delete from emp where empno=?";
		Object[] objs = {empno};
		bd.update(sql, objs);
	}

	@Override
	public Emp findOne(Integer empno) {
		String sql = "select * from emp where empno=?";
		Object[] objs = {empno};
		List<Emp> list = bd.select(sql, objs, Emp.class);
		return list.size()==0?null:list.get(0);
	}

	@Override
	public List<Emp> findAll() {
		String sql = "select * from emp";
		Object[] objs = {};
		List<Emp> list = bd.select(sql, objs, Emp.class);
		return list;
	}

	@Override
	public List<Emp> findByPage(PageBean pb) {
		String sql = "select * from emp limit ?,?";
		Object[] objs = {(pb.getPageNum()-1)*pb.getPageRow(),pb.getPageRow()};
		List<Emp> list = bd.select(sql, objs, Emp.class);
		return list;
	}

}
