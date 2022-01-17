package com.rajiv.spring.security.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.rajiv.spring.security.demo.service.CustomUserDetailService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SpringConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private CustomUserDetailService customUserDetailService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable() // this is done to hit request from postman otherwise we will not be able to
								// create a resource
				.authorizeRequests().antMatchers("/signin").permitAll().antMatchers("/public/**").hasRole("NORMAL")
				.antMatchers("/users/**").hasRole("ADMIN").anyRequest().authenticated().and().formLogin()
				.loginPage("/signin");
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// auth.inMemoryAuthentication().withUser("world").password("india").roles("ADMIN");
		// auth.inMemoryAuthentication().withUser("world").password("usa").roles("NORMAL");
		// auth.inMemoryAuthentication().withUser("arun").password(this.passwordEncoder().encode("india")).roles("ADMIN");
		// auth.inMemoryAuthentication().withUser("john").password(this.passwordEncoder().encode("usa")).roles("NORMAL");

		auth.userDetailsService(customUserDetailService).passwordEncoder(passwordEncoder());
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		// return NoOpPasswordEncoder.getInstance(); //this mean we want to use plain
		// text as password
		return new BCryptPasswordEncoder(10);
	}

}
