package com.weyinmi.isack.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class SpringSecurityConfiguration_InMemory extends WebSecurityConfigurerAdapter{
	@Autowired
	protected void configureGlobal(AuthenticationManagerBuilder auth)
		throws Exception{ auth.inMemoryAuthentication().withUser("user").password("password").roles("USER");
		auth.inMemoryAuthentication().withUser("admin").password("password").roles("USER", "ADMIN");
		
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.httpBasic().and().authorizeRequests()
		.antMatchers(HttpMethod.GET, "/app/user").hasRole("USER")
		.antMatchers(HttpMethod.POST, "/app/user").hasRole("USER")
		.antMatchers(HttpMethod.PUT, "/app/user/**").hasRole("USER")
		.antMatchers(HttpMethod.DELETE, "/app/user**").hasRole("ADMIN")
		.and().csrf().disable();
	}

}
