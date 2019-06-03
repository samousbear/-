package com.woniu.dao;

import java.util.List;

import com.woniu.bean.Dept;
import com.woniu.bean.PageBean;

public interface IDeptDAO {
	void save(Dept dept);
	void update(Dept dept);
	void delete(Integer deptno);
	Dept findOne(Integer deptno);
	List<Dept> findAll();
	List<Dept> findAllByPage(PageBean pb);
}
