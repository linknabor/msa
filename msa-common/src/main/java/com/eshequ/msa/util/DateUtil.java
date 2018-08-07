/**
 * 
 */
package com.eshequ.msa.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @author davidhardson
 *
 */
public class DateUtil {

	public static String getSysDate() {
		
		SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyyMMdd");
		String s = simpledateformat.format(Calendar.getInstance().getTime());
		return s;
	}
	
	public static String getSysTime() {
		
		SimpleDateFormat simpledateformat = new SimpleDateFormat("HHmmss");
		String s = simpledateformat.format(Calendar.getInstance().getTime());
		return s;
	}
	
	/**
	 * time with yyyyMMddHHmmss format
	 * @return
	 */
	public static String getSysDateTime() {
		
		SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyyMMddHHmmss");
		String s = simpledateformat.format(Calendar.getInstance().getTime());
		return s;
	}
	
	
}
