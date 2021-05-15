package com.cg.dto;

import java.time.LocalDate;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;

//import org.springframework.format.annotation.DateTimeFormat;

public class EmpDto {

	private Integer empId;
	
	@NotBlank(message = "Employee name must not be blank")
	@Pattern(regexp = "([a-zA-Z]+)|([a-zA-Z]+[\\s][a-zA-Z]+)", message = "name must contain alphabets")
	private String empName;
	
	@Min(value= 5000, message = "salary must be minimum 5000.0")
	//@NotBlank(message = "Emp salary must not be blank")
	private Double empSal;
	
	@PastOrPresent(message = "Date of joining must be past or present")
	//@NotBlank(message = "Date cannot be blank")
	private LocalDate doj;
	
	@NotBlank(message = "Department name cannot be blank")
	@Pattern(regexp = "(hr|production)", message = "department must be hr or production")
	private String deptName;
	
	public EmpDto() {
		
	}
	public EmpDto(int empId, String empName, double empSal, LocalDate doj, String deptName) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empSal = empSal;
		this.doj = doj;
		this.deptName = deptName;
	}
	public EmpDto(String empName, double empSal, LocalDate doj, String deptName) {
		super();
		
		this.empName = empName;
		this.empSal = empSal;
		this.doj = doj;
		this.deptName = deptName;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public double getEmpSal() {
		return empSal;
	}
	public void setEmpSal(double empSal) {
		this.empSal = empSal;
	}
	public LocalDate getDoj() {
		return doj;
	}
	public void setDoj(LocalDate doj) {
		this.doj = doj;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}	

}