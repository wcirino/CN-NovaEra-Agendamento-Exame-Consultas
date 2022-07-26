package com.clinica.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Service;

@Service
public class UtilService {

	public Date ConvertDate(String dt) throws Exception{
		
		dt = dt.replaceAll("-", "/");
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd"); 
		Date d = format.parse(dt);
		
		return d;
	}
	
}
