package com.woniu.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.woniu.bean.Dept;
import com.woniu.bean.Emp;
import com.woniu.bean.PageBean;
import com.woniu.service.ServiceFactory;

/**
 * Servlet implementation class EmpServlet
 */
@WebServlet("/EmpAjax.do")
public class EmpAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpAjax() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter("method");
		if(method==null||method.equals("list")){
			findAll(request,response);
		}
	}

	
	private void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PageBean pb = new PageBean();
		String pageNum = request.getParameter("pageNum");
		if(pageNum==null){
			pageNum="1";
		}
		pb.setPageNum(Integer.parseInt(pageNum));
		pb.setPageRow(5);
		
		List<Emp> emps = ServiceFactory.getEmpService().getEmpsByPage(pb);
		
		List<Dept> depts = ServiceFactory.getDeptService().getAllDept();
		String content = "";
		for(int i=0;i<emps.size();i++){
			Emp e = emps.get(i);
			content += "<tr>";
			content += "<td>"+(i+1)+"</td>";
			content += "<td>"+e.getEname()+"</td>";
			content += "</tr>";
		}
		response.getWriter().write(content);
	}
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
