package com.eshequ.msa.sso.config;

import javax.servlet.Filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.CharacterEncodingFilter;

import com.eshequ.msa.sso.filter.CrossDomainFilter;

public class FilterConfig {
	
	@Autowired
	private CrossDomainFilter crossDomainFilter;
	
	@Bean
    public FilterRegistrationBean<Filter> someFilterRegistration() {
        FilterRegistrationBean<Filter> registration = new FilterRegistrationBean<Filter>();
        registration.setFilter(new CharacterEncodingFilter());
        registration.addUrlPatterns("/*");
        registration.addInitParameter("encoding", "UTF-8");
        registration.addInitParameter("forceEncoding", "true");
        registration.setName("encodingFilter");
        return registration;
    }
	
	
	@Bean
	public FilterRegistrationBean<Filter> crossDomainFilterRegistration() {
		
		FilterRegistrationBean<Filter> registration = new FilterRegistrationBean<Filter>();
        registration.setFilter(crossDomainFilter);
        registration.addUrlPatterns("/*");
        return registration;
		
	}


}
