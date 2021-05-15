package com.cg.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.dto.EmpDto;
import com.cg.dto.SuccessMessage;
import com.cg.entity.Emp;
import com.cg.exceptions.DeptException;
import com.cg.exceptions.EmpNotFoundException;
import com.cg.service.IEmpService;

@RestController
public class ViewEmpService {
	
	@Autowired
	private IEmpService service;
	
	@GetMapping("viewbydept/{dname}")
	public List<Emp> viewEmployee(@PathVariable("dname") String dept)throws EmpNotFoundException
	{
	return service.viewEmployee(dept);
	}
	
	@GetMapping("viewbyid/{eid}")
	public Emp viewEmployeebyId(@PathVariable("eid") int empId)throws EmpNotFoundException
	{
		return service.viewEmployee(empId);
	}
	
	@GetMapping("viewallemployee")
	public List<Emp> viewAllEmployee()throws EmpNotFoundException
	{
	return service.viewEmployee();
	}
	
	
	
}