package com.woniu.service;

public class ServiceFactory {
	public static IDeptService getDeptService(){
		return new DeptServiceImpl();
	}
	public static IEmpService getEmpService(){
		return new EmpServiceImpl();
	}
}
