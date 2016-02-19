package com.demoapp.configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class DemoAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{
	
	 @Override
	    protected Class<?>[] getRootConfigClasses() {
	        return new Class[] { DemoAppConfiguration.class,RepositoryConfiguration.class };
	    }
	  
	    @Override
	    protected Class<?>[] getServletConfigClasses() {
	        return null;
	    }
	  
	    @Override
	    protected String[] getServletMappings() {
	        return new String[] { "/" };
	    }

}
