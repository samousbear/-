package com.woniu.service;
import java.util.List;

import com.woniu.bean.Dept;
import com.woniu.bean.PageBean;

public interface IDeptService {
	void addDept(Dept dept);
	void editDept(Dept dept);
	void delDept(Integer deptno);
	Dept getDept(Integer deptno);
	List<Dept> getAllDept();
	List<Dept> getAllDeptsByPageBean(PageBean pb);
}
