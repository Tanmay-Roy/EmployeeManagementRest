package com.cg.web;

import java.util.List;

import javax.validation.Valid;
import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.dto.EmpDto;
import com.cg.dto.SuccessMessage;
import com.cg.entity.Emp;
import com.cg.exceptions.DeptException;
import com.cg.exceptions.EmpNotFoundException;
import com.cg.exceptions.ValidateEmpException;
import com.cg.service.IEmpService;

@RestController
public class EmpCrudRestService {
	
	@Autowired
	private IEmpService service;
	
	//@PostMapping("addemployee")
	@RequestMapping(value="addemployee", method=RequestMethod.POST)
	public SuccessMessage addEmployee(@Valid @RequestBody EmpDto empdto, BindingResult br) throws DeptException, ValidateEmpException
	{
		System.out.println("I am in add employee");
	
		if (br.hasErrors())
			throw new ValidateEmpException(br.getFieldErrors());
		int eid= service.addEmployee(empdto);
		
		return new SuccessMessage("Your generated id is "+ eid);
		
	}	
	
	//@RequestMapping(value="editemployee", method = RequestMethod.PUT)
	@PutMapping("editemployee")
	public SuccessMessage editEmployee(@Valid @RequestBody EmpDto empdto, BindingResult br) throws EmpNotFoundException, DeptException, ValidateEmpException
	{
		if (br.hasErrors())
		{
			throw new ValidateEmpException(br.getFieldErrors());
		}
		service.editEmployee(empdto);
		return new SuccessMessage("Employee edited successfully");
	}
	
	//@RequestMapping(value="deleteemployee", method = RequestMethod.DELETE)
	@DeleteMapping("removeemployee/{eid}")
	public SuccessMessage deleteEmployee(@PathVariable ("eid") int eid) throws EmpNotFoundException
	{
		service.removeEmployee(eid);
		return new SuccessMessage("Employee deleted successfully");
		
	}
}