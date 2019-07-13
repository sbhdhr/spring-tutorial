package spring.security.db.auth.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import spring.security.db.auth.constants.UrlConstants;

public class SpringDispatcherInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {

		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {

		return new Class[] { SpringConfig.class };
	}

	@Override
	protected String[] getServletMappings() {

		return new String[] { UrlConstants.HOME_URL };
	}

}
