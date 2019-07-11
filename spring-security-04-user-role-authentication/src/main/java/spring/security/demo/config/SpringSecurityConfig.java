package spring.security.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

import spring.security.demo.constants.Roles.Role;
import spring.security.demo.controller.HomeController;
import spring.security.demo.controller.LoginController;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//add our users for in-memory authentication
		
		UserBuilder users = User.withDefaultPasswordEncoder();
		
		auth.inMemoryAuthentication()
			.withUser(users.username("john").password("test123").roles(Role.EMPLOYEE.toString()))
			.withUser(users.username("mary").password("test123").roles(Role.EMPLOYEE.toString(),Role.MANAGER.toString()))
			.withUser(users.username("susan").password("test123").roles(Role.EMPLOYEE.toString(),Role.ADMIN.toString()));
		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		
		http.authorizeRequests()			
		.antMatchers("/resources/**").permitAll()
		.antMatchers("/").hasRole(Role.EMPLOYEE.toString())
		.antMatchers(HomeController.MANAGER_PAGE_URL+"/**").hasRole(Role.MANAGER.toString())
		.antMatchers(HomeController.ADMIN_PAGE_URL+"/**").hasRole(Role.ADMIN.toString())
					.and()
						.formLogin()
						.loginPage(LoginController.LOGIN_PAGE_URL)
						.loginProcessingUrl("/authenticateUser")
						.permitAll()
					.and()
		            	.logout().permitAll()
		            	.and()
		            	.exceptionHandling().accessDeniedPage(LoginController.ACCESS_DENIED_URL);
		      
	}

	
	
}
