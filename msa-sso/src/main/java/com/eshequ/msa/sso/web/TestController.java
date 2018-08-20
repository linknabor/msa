package com.eshequ.msa.sso.web;

import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.eshequ.msa.sso.service.TestService;
import com.eshequ.msa.util.vericode.VeriCodeUtil;
import com.eshequ.msa.util.vericode.VeriCodeVO;

@RestController
public class TestController extends BaseController{

	private static final Logger logger = LoggerFactory.getLogger(TestController.class);
	
	@Autowired
	private TestService testService;
	
	@RequestMapping(value = "/testQuery/{num}", method = RequestMethod.GET)
	public String testQuery(@PathVariable String num) {
		
		logger.info("num is : " + num);
		return testService.testQuery(num);
	}
	
	@RequestMapping(value = "/testKeyGen", method = RequestMethod.GET)
	public long testQuery() {
		
		return testService.testKeyGen();
	}
	
	@RequestMapping(value = "/testHttp", method = RequestMethod.GET)
	public String testHttp() {
		
		return testService.testHttp();
	}
	
	@RequestMapping(value = "/testVeriCode", method = RequestMethod.GET)
	public void testVeriCode(HttpServletResponse response) throws IOException {
		
		OutputStream os = response.getOutputStream();
		VeriCodeVO vo = VeriCodeUtil.generateVeriCode();
		
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		response.setContentType("image/jpeg");
		ImageIO.write(vo.getBufferedImage(), "jpeg", os);
		
	}
	
}
