package com.woniu.service;
import java.util.List;

import com.woniu.bean.Emp;
import com.woniu.bean.PageBean;

public interface IEmpService {
	void addEmp(Emp emp);
	void editEmp(Emp emp);
	void delEmp(Integer empno);
	Emp getEmp(Integer empno);
	List<Emp> getAllEmp();
	void turnDept(int parseInt, int parseInt2);
	List<Emp> getEmpsByPage(PageBean pb);
}
