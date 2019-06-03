package com.woniu.service;

import java.util.List;

import com.woniu.bean.Dept;
import com.woniu.bean.Emp;
import com.woniu.bean.PageBean;
import com.woniu.dao.DAOFactory;

public class DeptServiceImpl implements IDeptService {

	@Override
	public void addDept(Dept dept) {
		DAOFactory.getDeptDAO().save(dept);

	}

	@Override
	public void editDept(Dept dept) {
		// TODO Auto-generated method stub
		DAOFactory.getDeptDAO().update(dept);
	}

	@Override
	public void delDept(Integer deptno) {
		List<Emp> emps = DAOFactory.getEmpDAO().findAll();
		for(Emp emp:emps){
			if(emp.getDeptno()==deptno){
				emp.setDeptno(0);
				DAOFactory.getEmpDAO().update(emp);
			}
		}
		DAOFactory.getDeptDAO().delete(deptno);
	}

	@Override
	public Dept getDept(Integer deptno) {
		// TODO Auto-generated method stub
		return DAOFactory.getDeptDAO().findOne(deptno);
	}

	@Override
	public List<Dept> getAllDept() {
		// TODO Auto-generated method stub
		return DAOFactory.getDeptDAO().findAll();
	}

	@Override
	public List<Dept> getAllDeptsByPageBean(PageBean pb) {
		List<Dept> allDepts = DAOFactory.getDeptDAO().findAll();
		Integer countRow = allDepts.size();
		pb.setCountRow(countRow);
		Integer countPage = countRow%pb.getPageRow()==0?countRow/pb.getPageRow():countRow/pb.getPageRow()+1;
		pb.setCountPage(countPage);
		List<Dept> pageDepts = DAOFactory.getDeptDAO().findAllByPage(pb);
		return pageDepts;
	}

}
