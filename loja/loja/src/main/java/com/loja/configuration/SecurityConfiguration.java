package com.loja.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.loja.service.UserDetailsServiceImpl;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@RequiredArgsConstructor
public class SecurityConfiguration extends WebSecurityConfigurerAdapter  {
	
	@Autowired
	private UserDetailsServiceImpl userDetailsService;
	
	@Override 
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
		       .antMatchers("/resources/**","/css/**","/img/**", "/js/**","/error/**").permitAll()
		       .anyRequest().authenticated()
		       .and()
		      .formLogin()
		        .loginPage("/login")
		        .defaultSuccessUrl("/home")
		        .permitAll()
		        .and()
		      .logout()
		        .permitAll();	
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() { 
	        return new BCryptPasswordEncoder();       
	}
	
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
	    auth.userDetailsService(this.userDetailsService).passwordEncoder(passwordEncoder());
	}
	 
    @Override
    public void configure(WebSecurity web) throws Exception {
        web
            .ignoring()
            .antMatchers("/h2/**");   
    }

}
