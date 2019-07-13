package spring.security.db.auth.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

import spring.security.db.auth.constants.Roles;
import spring.security.db.auth.constants.UrlConstants;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	
	//add reference to security datasource
	@Autowired
	private DataSource securityDataSource;
	

	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//add jdbc authentication
		
		auth.jdbcAuthentication().dataSource(securityDataSource);
		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		
		http.authorizeRequests()			
		.antMatchers(UrlConstants.RESOURCES_URL+"/**").permitAll()
		.antMatchers(UrlConstants.HOME_URL).hasRole(Roles.EMPLOYEE)
		.antMatchers(UrlConstants.MANAGER_PAGE_URL+"/**").hasRole(Roles.MANAGER)
		.antMatchers(UrlConstants.ADMIN_PAGE_URL+"/**").hasRole(Roles.ADMIN)
					.and()
						.formLogin()
						.loginPage(UrlConstants.LOGIN_PAGE_URL)
						.loginProcessingUrl(UrlConstants.AUTHENTICATE_USER_URL)
						.permitAll()
					.and()
		            	.logout().permitAll()
		            	.and()
		            	.exceptionHandling().accessDeniedPage(UrlConstants.ACCESS_DENIED_URL);
		      
	}

}
