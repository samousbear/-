package com.woniu.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import com.sun.xml.internal.ws.util.ServiceFinder;
import com.woniu.bean.Dept;
import com.woniu.service.ServiceFactory;

/**
 * Servlet implementation class Excel
 */
@WebServlet("/Excel.do")
public class Excel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Excel() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 上传文件
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		List<FileItem> list;
		try {
			list = upload.parseRequest(request);
			for(FileItem item:list){
				String fileName = item.getName();
				fileName= fileName.substring(fileName.lastIndexOf("\\")+1);
				String excelTemp = request.getServletContext().getRealPath("/excelTemp");
				File dir = new File(excelTemp);
				if(!dir.exists()){
					dir.mkdirs();
				}
				//将文件写入临时文件夹
				File target = new File(dir,fileName);
				item.write(target);
			}
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	//读取文件
		
		String path = request.getServletContext().getRealPath("/excelTemp/dept.xls");
		File file = new File(path);
		FileInputStream in = new FileInputStream(file);
		POIFSFileSystem poi = new POIFSFileSystem(in);
		HSSFWorkbook wb = new HSSFWorkbook(poi);
		HSSFSheet sheet=wb.getSheetAt(0);
		for(int i=sheet.getFirstRowNum()+1;i<=sheet.getLastRowNum();i++){
			HSSFRow row = sheet.getRow(i);
			if(row==null){
				continue;
			}
			Dept dept = new Dept();
			HSSFCell cell1 = row.getCell((short) 0);
			dept.setDeptno((int) cell1.getNumericCellValue());
			
			HSSFCell cell2 = row.getCell((short) 1);
			dept.setDname( cell2.getStringCellValue());
			
			HSSFCell cell3 = row.getCell((short) 2);
			dept.setLoc(cell3.getStringCellValue());
			ServiceFactory.getDeptService().addDept(dept);
		}
		response.sendRedirect("DeptServlet.do?method=findAllByPage");
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
