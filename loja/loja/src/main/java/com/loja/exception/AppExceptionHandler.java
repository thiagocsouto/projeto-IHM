package com.loja.exception;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.HttpClientErrorException.Forbidden;

@ControllerAdvice 
public class AppExceptionHandler {
	 
	
	@ExceptionHandler(NotFoundException.class)
	public String erroPage404() {
		return "error"; 
	}
	
	@ExceptionHandler(Forbidden.class)
	public String erroPage403() {
		return "error403"; 
	} 

}
