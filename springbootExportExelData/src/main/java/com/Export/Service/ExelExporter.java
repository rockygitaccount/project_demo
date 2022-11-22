package com.Export.Service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import com.Export.Entity.User;


import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

public class ExelExporter {
	
	private Workbook workbook;
	private Sheet sheet;
	private List<User> list;
	private void headerLine() {
		sheet = workbook.createSheet("All user details");
		CellStyle cellstyle = workbook.createCellStyle();
		Row row = sheet.createRow(0);
		Font font = workbook.createFont();
		font.setBold(true);
		font.setFontHeight((short) 16);
		cellstyle.setFont(font);
		createCell(row,0,"Id",cellstyle);
		createCell(row,1,"Name",cellstyle);
		createCell(row,2,"Adress",cellstyle);
		createCell(row,3,"Email",cellstyle);
		createCell(row,4,"Record 1",cellstyle);
		createCell(row,5,"Recoed 2",cellstyle);
		createCell(row,6,"Recoed 3",cellstyle);



	}
	private void createCell(Row row, int countColumn, Object value, CellStyle cellstyle) {
		
		sheet.autoSizeColumn(countColumn);
		Cell cell = row.createCell(countColumn);
		if(value instanceof Integer) {
			cell.setCellValue((Integer) value);
		}
		else if(value instanceof Boolean) {
			cell.setCellValue((Boolean) value);
			
		}
		else {
			cell.setCellValue((String) value);
		}
		cell.setCellStyle(cellstyle);
		
	}
	
	//create data which comes from DB
	private void WriteDataLines() {
		int rowCount = 1;
		CellStyle style = workbook.createCellStyle();
		Font font = workbook.createFont();
		font.setFontHeight((short) 18);
		style.setFont(font);
		for(User user : list) {
			Row row = sheet.createRow(rowCount++);
			int CountColumn = 0;
			createCell(row, CountColumn++,user.getUser_id(),style);
			createCell(row, CountColumn++,user.getUser_name(),style);
			createCell(row, CountColumn++,user.getUser_adress(),style);
			createCell(row, CountColumn++,user.getUser_email(),style);
			createCell(row, CountColumn++,user.getRecord_1(),style);
			createCell(row, CountColumn++,user.getRecord_2(),style);
			createCell(row, CountColumn++,user.getRecord_3(),style);



			
		}
	}
	
	public ExelExporter(List<User>list) {
		this.list = list;
		workbook = new HSSFWorkbook();
	}
	public void exportData(HttpServletResponse response)throws IOException{
		headerLine();
		WriteDataLines();
		ServletOutputStream outputstream = response.getOutputStream();
		workbook.write(outputstream);
		workbook.close();
		outputstream.close();
		
	}
	



}
