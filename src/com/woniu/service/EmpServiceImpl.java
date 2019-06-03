package com.woniu.service;

import java.util.List;

import com.woniu.bean.Emp;
import com.woniu.bean.PageBean;
import com.woniu.dao.DAOFactory;

public class EmpServiceImpl implements IEmpService {

	@Override
	public void addEmp(Emp emp) {
		// TODO Auto-generated method stub
		DAOFactory.getEmpDAO().save(emp);
	}

	@Override
	public void editEmp(Emp emp) {
		// TODO Auto-generated method stub
		DAOFactory.getEmpDAO().update(emp);
	}

	@Override
	public void delEmp(Integer empno) {
		// TODO Auto-generated method stub
		DAOFactory.getEmpDAO().delete(empno);
	}

	@Override
	public Emp getEmp(Integer empno) {
		// TODO Auto-generated method stub
		return DAOFactory.getEmpDAO().findOne(empno);
	}

	@Override
	public List<Emp> getAllEmp() {
		// TODO Auto-generated method stub
		return DAOFactory.getEmpDAO().findAll();
	}

	@Override
	public void turnDept(int empno, int deptno) {
		Emp emp = DAOFactory.getEmpDAO().findOne(empno);
		emp.setDeptno(deptno);
		DAOFactory.getEmpDAO().update(emp);
	}

	@Override
	public List<Emp> getEmpsByPage(PageBean pb) {
		List<Emp> allEmps = DAOFactory.getEmpDAO().findAll();
		pb.setList(allEmps);
		pb.setCountRow(allEmps.size());
		pb.setCountPage(allEmps.size()%pb.getPageRow()==0?allEmps.size()/pb.getPageRow():allEmps.size()/pb.getPageRow()+1);
		List<Emp> empsPage = DAOFactory.getEmpDAO().findByPage(pb);
		return empsPage;
	}

}
