package com.pmf.codejam.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public interface Constants {
	
	public final DateFormat COMMON_DATE_FORMAT = new SimpleDateFormat("MM/dd/yy"); // 10/22/84
	public final DateFormat COMMON_FULL_DATE_FORMAT = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	public final String GLOBAL_USER_SESSION_KEY = "USER";
}