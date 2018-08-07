/**
 * 
 */
package com.eshequ.msa.http;

/**
 * @author davidhardson
 *
 */
public class HttpConfig {
	
	private String requestEncoding;
	private String responseEncoding;
	
	public HttpConfig() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public HttpConfig(String encoding) {
		super();
		this.requestEncoding = encoding;
		this.responseEncoding = encoding;
	}

	public HttpConfig(String requestEncoding, String responseEncoding) {
		super();
		this.requestEncoding = requestEncoding;
		this.responseEncoding = responseEncoding;
	}
	
	public String getRequestEncoding() {
		return requestEncoding;
	}
	public void setRequestEncoding(String requestEncoding) {
		this.requestEncoding = requestEncoding;
	}
	public String getResponseEncoding() {
		return responseEncoding;
	}
	public void setResponseEncoding(String responseEncoding) {
		this.responseEncoding = responseEncoding;
	}
	
	

}
