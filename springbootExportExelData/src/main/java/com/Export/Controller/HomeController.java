package com.Export.Controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.Export.Entity.User;
import com.Export.Repositories.UserRepository;
import com.Export.Service.ExelExporter;


@Controller
public class HomeController {
	@Autowired
	UserRepository userrepository;
	@GetMapping("/export")
	public void exportToExcel(HttpServletResponse response) throws IOException {
		response.setContentType("application/octet-stream");
		DateFormat dateformate=new SimpleDateFormat();
		String CurrentDateandTime = dateformate.format(new Date()  );
		String header = "content-Disposition";
		
		String headerValue = "attachment; filename = alluser_" +CurrentDateandTime+".xlsx";
		response.setHeader(header, headerValue);
		
		//get date to list 
		 List<User> listUsers = userrepository.findAll();
		 
		 ExelExporter excelexporter = new ExelExporter(listUsers);
		 
		 excelexporter.exportData(response);
	}

}
