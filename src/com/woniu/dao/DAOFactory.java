package com.woniu.dao;

public class DAOFactory {
	public static IDeptDAO getDeptDAO(){
		return new DeptDAOImpl();
	}
	public static IEmpDAO getEmpDAO(){
		return new EmpDAOImpl();
	}
}
