package com.woniu.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.woniu.bean.Dept;
import com.woniu.service.ServiceFactory;

/**
 * Servlet implementation class Excel2
 */
@WebServlet("/Excel2.do")
public class Excel2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Excel2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Dept> dept = ServiceFactory.getDeptService().getAllDept();
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet("≤ø√≈±Ì");
		for(int i=0;i<dept.size();i++){
			Dept depts = dept.get(i);
		HSSFRow row = sheet.createRow(i+1);
		HSSFCell cell1 = row.createCell((short)0);
		cell1.setCellValue(depts.getDeptno());
		
		HSSFCell cell2 = row.createCell((short)1);
		cell2.setCellValue(depts.getDname());
		
		HSSFCell cell3 = row.createCell((short)2);
		cell3.setCellValue(depts.getLoc());
	}
		File dir = new File(request.getServletContext().getRealPath("/excelTemp"));
		File file = new File(dir,new Date().getTime()+".xls");
		FileOutputStream out = new FileOutputStream(file);
		wb.write(out);
		response.sendRedirect("excelList.do");
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
