package com.cognizant.portal.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Service;

@Service
public class DateUtil {
	public static Date convertToDate(String dateOfMeeting) {
		SimpleDateFormat dateFormatter = null;
		Date result = null;
		try {
			dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
			result = dateFormatter.parse(dateOfMeeting);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return result;
	}
}