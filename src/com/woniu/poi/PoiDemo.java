package com.woniu.poi;

import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

public class PoiDemo {

	public static void main(String[] args) {
		try {
			POIFSFileSystem poi = new POIFSFileSystem(PoiDemo.class.getResourceAsStream("dept.xls"));
			HSSFWorkbook workbook = new HSSFWorkbook(poi);
			for(int i=0;i<workbook.getNumberOfSheets();i++){
				HSSFSheet sheet = workbook.getSheetAt(i);
				if(sheet!=null&&sheet.getLastRowNum()!=0){
					for(int j=sheet.getFirstRowNum();j<=sheet.getLastRowNum();j++){
						HSSFRow row = sheet.getRow(j);
						for(int k=row.getFirstCellNum();k<row.getLastCellNum();k++){
							HSSFCell cell = row.getCell((short) k);
							Object obj = null;
							switch(cell.getCellType()){
							case 0:
								obj = cell.getNumericCellValue();
								break;
							case 1:
								obj = cell.getStringCellValue();
								break;
							}
							System.out.println(j+":"+obj+":"+cell.getCellType());
						}
					}
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
