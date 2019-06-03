package com.woniu.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.woniu.bean.Dept;
import com.woniu.bean.PageBean;
import com.woniu.service.ServiceFactory;

/**
 * Servlet implementation class DeptServlet
 */
@WebServlet("/DeptServlet.do")
public class DeptServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeptServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String method = request.getParameter("method");
		if(method==null||"findAllByPage".equals(method)){
			findAllByPage(request,response);
		}else if("addDept".equals(method)){
			addDept(request,response);
		}else if("getDept".equals(method)){
			getDept(request,response);
		}else if("delDept".equals(method)){
			delDept(request,response);
		}else if("editDept".equals(method)){
			editDept(request,response);
		}
	}



	private void editDept(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String deptno = request.getParameter("deptno");
		String dname = request.getParameter("dname");
		String loc = request.getParameter("loc");
		Dept dept = new Dept();
		dept.setDeptno(Integer.parseInt(deptno));
		dept.setDname(dname);
		dept.setLoc(loc);
		
		ServiceFactory.getDeptService().editDept(dept);
		
		response.sendRedirect("DeptServlet.do");
	}

	private void delDept(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String deptno = request.getParameter("deptno");
		
		ServiceFactory.getDeptService().delDept(Integer.parseInt(deptno));
		
		response.sendRedirect("DeptServlet.do");
	}

	private void getDept(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String deptno = request.getParameter("deptno");
		
		Dept dept = ServiceFactory.getDeptService().getDept(Integer.parseInt(deptno));
		
		request.setAttribute("dept", dept);
		
		request.getRequestDispatcher("DeptEdit.jsp").forward(request, response);
	}

	private void addDept(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String deptno = request.getParameter("deptno");
		String dname = request.getParameter("dname");
		String loc = request.getParameter("loc");
		Dept dept = new Dept();
		dept.setDeptno(Integer.parseInt(deptno));
		dept.setDname(dname);
		dept.setLoc(loc);
		
		ServiceFactory.getDeptService().addDept(dept);
		
		response.sendRedirect("DeptServlet.do");
		
	}

	private void findAllByPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String pageNum = request.getParameter("pageNum");
		PageBean pb = new PageBean();
		if(pageNum==null){
			pb.setPageNum(1);
		}else{
			pb.setPageNum(Integer.parseInt(pageNum));
		}
		pb.setPageRow(5);
		List<Dept> depts = ServiceFactory.getDeptService().getAllDeptsByPageBean(pb);
		request.setAttribute("depts", depts);
		request.setAttribute("pb", pb);
		request.getRequestDispatcher("DeptList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
