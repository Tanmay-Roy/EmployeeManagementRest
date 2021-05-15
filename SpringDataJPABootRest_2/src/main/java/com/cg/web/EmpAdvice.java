package com.cg.web;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.cg.dto.ErrorMessage;
import com.cg.exceptions.DeptException;
import com.cg.exceptions.EmpNotFoundException;
import com.cg.exceptions.ValidateEmpException;

@RestControllerAdvice
public class EmpAdvice {
	
	@ExceptionHandler(EmpNotFoundException.class)
	@ResponseStatus(code =HttpStatus.NOT_FOUND)
	public ErrorMessage handleExceptionEmpNotFound(EmpNotFoundException ex)
	{
		return new ErrorMessage(HttpStatus.NOT_FOUND.toString(), ex.getMessage());
	}
	
	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	@ResponseStatus(code= HttpStatus.BAD_REQUEST)
	public ErrorMessage handleExceptionForDate(MethodArgumentTypeMismatchException ex)
	{
		if (ex.getMessage().contains("LocalDate"))
					return new ErrorMessage(HttpStatus.BAD_REQUEST.toString(), "Invalid Date Pattern");
		 return new ErrorMessage(HttpStatus.BAD_REQUEST.toString(), "It must be numeric");
	}
	
	@ExceptionHandler(HttpMessageConversionException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ErrorMessage handleException3(HttpMessageConversionException ex) {
        if(ex.getMessage().contains("LocalDate"))
           return new ErrorMessage(HttpStatus.BAD_REQUEST.toString(), "Invalid Date Pattern , follow yyyy-M-d");
        return new ErrorMessage(HttpStatus.BAD_REQUEST.toString(), ex.getMessage());
    }
	
	@ExceptionHandler(ValidateEmpException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ErrorMessage handleException2(ValidateEmpException ex) {
        List<String> errors = ex.getErrors().stream()
                .map(err->err.getDefaultMessage()).collect(Collectors.toList());
        return new ErrorMessage(HttpStatus.BAD_REQUEST.toString(), errors);
    }
	
	@ExceptionHandler(DeptException.class)
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public ErrorMessage handleException2(DeptException ex) {
        return new ErrorMessage(HttpStatus.NOT_FOUND.toString(), ex.getMessage());
    }

}