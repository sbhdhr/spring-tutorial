package spring.security.db.auth.config;

import java.beans.PropertyVetoException;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import spring.security.db.auth.constants.UrlConstants;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "spring.security.db.auth")
@PropertySource("classpath:persistence-mysql.properties")
public class SpringConfig implements WebMvcConfigurer {

	
	// Setup var to hold properties file
	@Autowired
	private Environment env;
	
	//Set logger for diagnostics
	
	Logger logger = Logger.getLogger(SpringConfig.class.getName());
	

	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();

		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");

		return viewResolver;

	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler(UrlConstants.RESOURCES_URL+"/**").addResourceLocations(UrlConstants.RESOURCES_URL+"/");
	}
	
	@Bean
	public DataSource securityDataSource() {

		//create connection pool 
		
		ComboPooledDataSource securityDataSource = new ComboPooledDataSource();
		
		
		//set the jdbc driver class 
		try {
			securityDataSource.setDriverClass(env.getProperty("jdbc.driver"));
		} catch (PropertyVetoException e) {
			
			e.printStackTrace();
		}
		
		//log the connection props 
		logger.info("======>>>  jdbc.url: "+env.getProperty("jdbc.url"));
		logger.info("======>>>  jdbc.user: "+env.getProperty("jdbc.user"));
		
		
		//set database connection props 
		securityDataSource.setJdbcUrl(env.getProperty("jdbc.url"));
		securityDataSource.setUser(env.getProperty("jdbc.user"));
		securityDataSource.setPassword(env.getProperty("jdbc.password"));
		
		
		//set connection pool props
		 
		securityDataSource.setInitialPoolSize(
								getIntegerProperty("connection.pool.initialPoolSize"));
		
		securityDataSource.setMinPoolSize(
				getIntegerProperty("connection.pool.minPoolSize"));

		securityDataSource.setMaxPoolSize(
				getIntegerProperty("connection.pool.maxPoolSize"));
		
		securityDataSource.setMaxIdleTime(
				getIntegerProperty("connection.pool.maxIdleTime"));
		
		
		return securityDataSource;
	}
	
	//helper method
	private int getIntegerProperty(String propName) {
		String propValue = env.getProperty(propName);
		
		return Integer.parseInt(propValue);
	}

}
