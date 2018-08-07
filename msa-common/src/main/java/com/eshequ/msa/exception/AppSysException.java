/**
 * 
 */
package com.eshequ.msa.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author huym
 *
 */
public class AppSysException extends RuntimeException {
	
	private static Logger logger = LoggerFactory.getLogger(AppSysException.class);

	/**
	 * 
	 */
	private static final long serialVersionUID = -8531279862043501712L;

	public AppSysException(String message, Throwable cause) {
		super(message, cause);
		logger.error(message, cause);
	}

	public AppSysException(Throwable cause) {
		super(cause);
		logger.error(cause.getMessage(), cause);
	}
	
	

}
